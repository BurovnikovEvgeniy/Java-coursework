package service.three;

import common.Configuration;
import common.Ship;
import common.Time;
import common.TypesCargoShips;
import service.one.Timetable;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkingPort {
    public static void findOptimalPortOperation(Timetable timetable) throws IOException {
        // тут описывваем все переменные
        int numberCraneForBULK = 1;
        int numberCraneForLIQUID = 1;
        int numberCraneForCONTAINER = 1;

        int totalNumberUnloadedShips = 0;

        Object bulkMutex = new Object();
        Object liquidMutex = new Object();
        Object containerMutex = new Object();

        boolean a = true;
        boolean b = true;
        boolean c = true;

        Timetable t = new Timetable(timetable);
        CreatingAccurateTimetable.creatAccurateTimetable(t, "timetable_with_accurate.json");

        ProcessingResult scanRes = new ProcessingResult();

        // тут моделируем работу порта с разным кол-вом кранов
        while (true) {
            AtomicInteger totalCostForBULK = new AtomicInteger(0);
            AtomicInteger totalCostForLIQUID = new AtomicInteger(0);
            AtomicInteger totalCostForCONTAINER = new AtomicInteger(0);


            Port port = new Port(t);
            Vector<Ship> tempVectorOfShip = port.getSetShipInPort();

            Queue<Ship> queueForBULK = addThisTypeShipsInQueue(tempVectorOfShip, TypesCargoShips.TypesCargo.BULK);
            Queue<Ship> queueForLIQUID = addThisTypeShipsInQueue(tempVectorOfShip, TypesCargoShips.TypesCargo.LIQUID);
            Queue<Ship> queueForCONTAINERS = addThisTypeShipsInQueue(tempVectorOfShip, TypesCargoShips.TypesCargo.CONTAINER);

            Vector<Ship> res = new Vector<Ship>();

            CyclicBarrier barrier
                    = new CyclicBarrier(numberCraneForBULK + numberCraneForLIQUID + numberCraneForCONTAINER, port.timer);

            Vector<Thread> threads = new Vector<Thread>();

            for (int i = 0; i < numberCraneForBULK; ++i) {
                threads.add(new Thread(new Crane(port, TypesCargoShips.TypesCargo.BULK, queueForBULK, bulkMutex, barrier, res)));
            }

            for (int i = 0; i < numberCraneForLIQUID; ++i) {
                threads.add(new Thread(new Crane(port, TypesCargoShips.TypesCargo.LIQUID, queueForLIQUID, liquidMutex, barrier, res)));
            }

            for (int i = 0; i < numberCraneForCONTAINER; ++i) {
                threads.add(new Thread(new Crane(port, TypesCargoShips.TypesCargo.CONTAINER, queueForCONTAINERS, containerMutex, barrier, res)));
            }
            threads.forEach(Thread::start);

            threads.forEach((thread -> {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));

            System.out.println("\n\n");
            Vector<Ship> unloadSetOfShip = res;
            Collections.sort(unloadSetOfShip);

            unloadSetOfShip.forEach((ship) -> {
                if (ship.getTonnage() == 0) {
                    ship.showDataForStatistic();
                }
            });

            //вывод статитики
            int countUnloadedShip = port.getTotalNumberUnloadedShips();
            System.out.println("total number of ships unloaded " + countUnloadedShip); // общее кол-во разгруженных судов
            scanRes.addTotalNumberShipsUnloaded(countUnloadedShip);

            System.out.println("average length of the unloading queue " + port.timer.getTotalAverageQueueLength()); // средняя длина очереди на разгрузку
            scanRes.addAverageLengthUnloadingQueue(port.timer.getTotalAverageQueueLength());

            long fullWaitingTime = unloadSetOfShip.stream().filter(ship -> ship.getTonnage() == 0)
                    .mapToLong(ship -> ship.getWaitingTime().getTime()).sum();
            System.out.println("average waiting time in the queue " + new Time((int) Math.ceil((double) fullWaitingTime / countUnloadedShip))); // среднее время ожидания в очереди
            scanRes.addAverageWaitingTimeInQueue(new Time((int) Math.ceil((double) fullWaitingTime / countUnloadedShip)));

            int maxDelay = unloadSetOfShip.stream().filter(ship -> ship.getTonnage() == 0) // средняя и максимальная задержка
                    .mapToInt(ship -> ship.getShipDelayOnCrane().getTime()).max().orElse(Integer.MIN_VALUE);
            int averageDelay = unloadSetOfShip.stream().filter(ship -> ship.getTonnage() == 0)
                    .mapToInt(ship -> ship.getShipDelayOnCrane().getTime()).sum();
            averageDelay = (int) Math.ceil((double) averageDelay / countUnloadedShip);
            System.out.println("average delay " + new Time(averageDelay));
            scanRes.addAverageDelay(new Time(averageDelay));
            System.out.println("Max delay " + new Time(maxDelay));
            scanRes.addMaxDelay(new Time(maxDelay));

            int totalCost = 0;

            unloadSetOfShip.forEach((ship -> {
                if (ship.getTonnage() == 0) {
                    if (ship.getTypeCargo() == TypesCargoShips.TypesCargo.BULK)
                        totalCostForBULK.addAndGet(ship.calculateAmountFine());
                    else if (ship.getTypeCargo() == TypesCargoShips.TypesCargo.LIQUID)
                        totalCostForLIQUID.addAndGet(ship.calculateAmountFine());
                    else if (ship.getTypeCargo() == TypesCargoShips.TypesCargo.CONTAINER)
                        totalCostForCONTAINER.addAndGet(ship.calculateAmountFine());
                }
            }));

            totalCost = totalCostForBULK.get() + totalCostForLIQUID.get() + totalCostForCONTAINER.get();
            totalCost += Configuration.oneCraneFine * (numberCraneForBULK + numberCraneForLIQUID + numberCraneForCONTAINER);
            System.out.println("Total cost " + totalCost);
            scanRes.addTotalCost(totalCost);

            System.out.println("BULK - " + totalCostForBULK.get() + " crane " + numberCraneForBULK * Configuration.oneCraneFine);
            System.out.println("LIQUID - " + totalCostForLIQUID.get() + " crane " + numberCraneForLIQUID * Configuration.oneCraneFine);
            System.out.println("CONTAINER - " + totalCostForCONTAINER.get() + " crane " + numberCraneForCONTAINER * Configuration.oneCraneFine);

            scanRes.addUnloadedBulkShip(numberCraneForBULK);
            scanRes.addUnloadedLiquidShip(numberCraneForLIQUID);
            scanRes.addUnloadedContainerShip(numberCraneForCONTAINER);

            // необходимое кол-во кранов каждого вида
            if (a || b || c) {
                System.out.println("Current statistic cranes :\n" + "BULK - " + numberCraneForBULK
                        + "\nLIQUID - " + numberCraneForLIQUID + "\nCONTAINER - " + numberCraneForCONTAINER);
                if (totalCostForBULK.get() > Configuration.oneCraneFine && a) {
                    numberCraneForBULK++;

                } else a = false;
                if (totalCostForLIQUID.get() > Configuration.oneCraneFine && b) {
                    numberCraneForLIQUID++;
                } else b = false;
                if (totalCostForCONTAINER.get() > Configuration.oneCraneFine && c) {
                    numberCraneForCONTAINER++;
                } else c = false;
            }

            if (!a && !b && !c) {
                System.out.println("The number of cranes need to be installed :\n" + "BULK - " + numberCraneForBULK
                        + "\nLIQUID - " + numberCraneForLIQUID + "\nCONTAINER - " + numberCraneForCONTAINER);
                ProcessingResult.saveResults(scanRes, "result.json");
                break;
            }
        }
    }

    public static Vector<Ship> copyVector(Vector<Ship> setShip)
    {
        Vector<Ship> newSetShip = new Vector<>();
        setShip.forEach((ship) -> {
            newSetShip.add(new Ship(ship));
        });
        return newSetShip;
    }

    private static Queue<Ship> addThisTypeShipsInQueue(Vector<Ship> ships, TypesCargoShips.TypesCargo comparator)
    {
        Queue<Ship> queue = new LinkedList<Ship>();
        ships.forEach((ship) -> {
            if (ship.getTypeCargo() == comparator)
            {
                queue.add(ship);
            }
        });
        return queue;
    }
}
