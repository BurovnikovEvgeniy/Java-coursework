package service.one;

import common.Configuration;
import common.Ship;
import common.Time;

import java.util.Collections;
import java.util.Random;
import java.util.Vector;

import static service.three.WorkingPort.copyVector;

public class Timetable {
    private Vector<Ship> setShips = new Vector<Ship>();
    private static Random r = new Random();
    private final int numberShip;

    public Timetable()
    {
        this.numberShip = r.nextInt(Configuration.maxNumberShip + 1);
    }
    public Timetable(Timetable timetable)
    {
        this.numberShip = timetable.getNumberShip();
        this.setShips = copyVector(timetable.getSetShips());
    }

    public Vector<Ship> createTimetableWithRandomValue()
    {
        for (int i = 0; i < numberShip; ++i)
        {
            setShips.add(ShipConfigurationGenerator.generateRandomShip());
        }
        Collections.sort(setShips);
        return setShips;
    }
    public void showTimetable()
    {
        setShips.forEach(System.out::println);
    }

    public Vector<Ship> getSetShips() {
        return setShips;
    }
    public void addShipInTimetable(Ship ship)
    {
        setShips.addElement(ship);
        Collections.sort(setShips);
    }

    public int getNumberShip() {
        return numberShip;
    }
}
