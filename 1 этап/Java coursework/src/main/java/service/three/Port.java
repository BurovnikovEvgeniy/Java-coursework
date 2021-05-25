package service.three;

import common.*;
import service.one.Timetable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import static service.three.WorkingPort.copyVector;

public class Port {
    private int totalNumberUnloadedShips;
    private long totalWeightUnloadedCargo;
    private ArrayList<Ship> setOfUnloadedShipsInPort;
    private Vector<Ship> setShipInPort;
    public Timer timer;


    public Port(Timetable timetable) throws IOException {
        this.setShipInPort = copyVector(timetable.getSetShips());
        this.totalNumberUnloadedShips = 0;
        this.setOfUnloadedShipsInPort = new ArrayList<Ship>(10);
        this.timer = new Timer(this.setShipInPort);
    }

    public int getTotalNumberUnloadedShips() {
        return totalNumberUnloadedShips;
    }

    public void addTotalNumberUnloadedShips(int totalNumberUnloadedShips) {
        this.totalNumberUnloadedShips += totalNumberUnloadedShips;
    }

    public long getTotalWeightUnloadedCargo() {
        return totalWeightUnloadedCargo;
    }

    public long addTotalWeightUnloadedCargo(long weightUnloadedCargo) {
        this.totalWeightUnloadedCargo += weightUnloadedCargo;
        return weightUnloadedCargo;
    }

    public void addShipForUnload(Ship ship)
    {
        setOfUnloadedShipsInPort.add(ship);
    }
    public boolean searchShipAmongUnloadedOnes(Ship ship)
    {
        return setOfUnloadedShipsInPort.contains(ship);
    }

    public Ship searchShipWithTypeCargo(TypesCargoShips.TypesCargo typesCargo) throws InterruptedException {
        Ship tempShip = new Ship("",typesCargo, Integer.MAX_VALUE);
        if (!setOfUnloadedShipsInPort.isEmpty())
        synchronized (setOfUnloadedShipsInPort) {
            for (Ship s : setOfUnloadedShipsInPort) {
                if (s.getTypeCargo() == typesCargo && s.getTonnage() > TypesCargoShips.getEngineForThisType(typesCargo)) {
                    if (s.getTonnage() < tempShip.getTonnage() && s.getNumberUnloadingCranes() < Configuration.maxNumberCraneOnOneShip) {
                        tempShip = s;
                    }
                }
            }
        }
        if (tempShip.getShipName().equals("")) return null;
        return tempShip;
    }

    public int getTotalAverageQueueLengthInPort()
    {
        return timer.getTotalAverageQueueLength();
    }


    public void deleteShipAmongUnloadedOnes(Ship ship)
    {
        setOfUnloadedShipsInPort.remove(ship);
    }

    public Vector<Ship> getSetShipInPort() {
        return setShipInPort;
    }
}
