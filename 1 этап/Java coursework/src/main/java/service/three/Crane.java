package service.three;

import common.Configuration;
import common.Ship;
import common.Time;
import common.TypesCargoShips;

import java.util.Queue;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Crane implements Runnable {

    Ship unloadedShip; // текущий разгружаемый корабль
    Port port; // порт, к которому принадлежит кран
    Queue<Ship> queueShipFotThisTypeCrane; // очередь, в которой лежат корабли в ожидании
    TypesCargoShips.TypesCargo typesCargo; // тип груза, который может разгружать кран
    boolean busy; // индикатор работы крана
    private static Random r = new Random(); // для вычисления случайной задержки разгрузки
    Object mutex; // для синхронизации внутри потоков
    CyclicBarrier barrier;
    Vector<Ship> setUnloadedShip;

    public Crane(Port port, TypesCargoShips.TypesCargo typesCargo, Queue<Ship> queue, Object mutex, CyclicBarrier barrier, Vector<Ship> res) {
        this.unloadedShip = null;
        this.port = port;
        this.typesCargo = typesCargo;
        this.queueShipFotThisTypeCrane = queue;
        unloadedShip = null;
        busy = false;
        this.mutex = mutex;
        this.barrier = barrier;
        this.setUnloadedShip = res;
    }


    @Override
    public void run() throws IllegalArgumentException
    {
        try {
            int randomValue_delay = 0;
            int counter = 0;
            while (true) {
                if (unloadedShip == null) {
                    randomValue_delay = r.nextInt(Configuration.maximumUnloadingDelay * 24 * 60 + 1);
                    counter = randomValue_delay;
                    synchronized (mutex) {
                        Ship tempShip = port.searchShipWithTypeCargo(typesCargo);
                        if (tempShip != null) {
                            int unloadTimeForTempShip = 0;
                            int waitingTimeForShipInTheQueue = 0;
                            if (!queueShipFotThisTypeCrane.isEmpty()) {
                                unloadTimeForTempShip = (int) Math.ceil(tempShip.getTonnage()
                                        / ((double) TypesCargoShips.getEngineForThisType(tempShip.getTypeCargo())));
                                unloadTimeForTempShip /= 2;
                                waitingTimeForShipInTheQueue = port.timer.getCommonTime()
                                        - queueShipFotThisTypeCrane.peek().getArrivalTime().getTime();
                            }
                            if ((!queueShipFotThisTypeCrane.isEmpty()
                                    && waitingTimeForShipInTheQueue > 0// добавить условие что waitingTimeForShipInTheQueue > 0
                                    && (double) (queueShipFotThisTypeCrane.peek().getTonnage() / tempShip.getTonnage()) < 1.2
                                    && (double) (queueShipFotThisTypeCrane.peek().getTonnage() / tempShip.getTonnage()) > 0.8
                                    && (unloadTimeForTempShip + waitingTimeForShipInTheQueue) < (int) Math.ceil(((double) queueShipFotThisTypeCrane.peek().getUnloadTime().getTime() / 2))
                                    && tempShip.getNumberUnloadingCranes() < 2)

                                    || (waitingTimeForShipInTheQueue < 0 && tempShip.getNumberUnloadingCranes() < 2)

                                    || (tempShip.getNumberUnloadingCranes() < 2 && queueShipFotThisTypeCrane.isEmpty())) {
                                unloadedShip = tempShip;
                                counter = unloadedShip.getShipDelayOnCrane().getTime();
                                unloadedShip.incNumberUnloadingCranes();
                            } else {
                                if (waitingTimeForShipInTheQueue >= 0 && !queueShipFotThisTypeCrane.isEmpty()) {
                                    excludeShipFromQueue();
                                    unloadedShip.setShipDelayOnCrane(new Time(randomValue_delay));
                                }
                            }
                        } else if (!queueShipFotThisTypeCrane.isEmpty()
                                && port.timer.getCommonTime() - queueShipFotThisTypeCrane.peek().getArrivalTime().getTime() >= 0) {
                            excludeShipFromQueue();
                            unloadedShip.setShipDelayOnCrane(new Time(randomValue_delay));
                        }
                    }
                } else if (unloadedShip != null) {
                    synchronized (unloadedShip) {
                        synchronized (port) {
                            port.addTotalWeightUnloadedCargo(unloadedShip.unload(TypesCargoShips.getEngineForThisType(typesCargo)));
                        }
                        if (unloadedShip.getTonnage() == 0) counter--;

                        if (unloadedShip.getTonnage() == 0 && counter <= 0)
                        {
                            if (unloadedShip != null && port.searchShipAmongUnloadedOnes(unloadedShip)) {
                                synchronized (port) {
                                    port.addTotalNumberUnloadedShips(1);
                                }
                            }
                            unloadedShip.decNumberUnloadingCranes(unloadedShip.getNumberUnloadingCranes());
                            unloadedShip.setEndOfUnloading(new Time(port.timer.getCommonTime()));
                            //обнулить и удалить среди разгружаемых
                            synchronized (port) {
                                port.deleteShipAmongUnloadedOnes(unloadedShip);
                            }
                            unloadedShip = null;
                        }
                    }

                }


                barrier.await();
                if (port.timer.getPeek()) break;

            }
        }
        catch (InterruptedException | BrokenBarrierException e)
        {
            e.printStackTrace();
        }
    }

    private synchronized void excludeShipFromQueue() {
        unloadedShip = queueShipFotThisTypeCrane.poll();

        synchronized (setUnloadedShip) {
            setUnloadedShip.add(unloadedShip);
        }

        if (unloadedShip.getTypeCargo() != this.typesCargo) {
            throw new IllegalArgumentException("A ship with a different " +
                    "type of cargo has been transferred to this crane");
            }
        unloadedShip.incNumberUnloadingCranes();
        unloadedShip.addWaitingTime(port.timer.getCommonTime() - unloadedShip.getArrivalTime().getTime());
        port.addShipForUnload(unloadedShip);
    }
}

