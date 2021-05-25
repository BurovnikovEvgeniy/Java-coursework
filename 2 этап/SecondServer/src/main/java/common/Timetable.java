package common;

import java.util.Collections;
import java.util.Random;
import java.util.Vector;


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
        Vector<Ship> newSetShip = new Vector<>();
        timetable.getSetShips().forEach((ship) -> {
            newSetShip.add(new Ship(ship));
        });
        this.setShips = newSetShip;
    }
    public Timetable(Vector<Ship> setShips)
    {
        this.setShips = setShips;
        numberShip = setShips.size();
    }
    public boolean empty()
    {
        return setShips.isEmpty();
    }
//    public Vector<Ship> createTimetableWithRandomValue()
//    {
//        for (int i = 0; i < numberShip; ++i)
//        {
//            setShips.add(ShipConfigurationGenerator.generateRandomShip());
//        }
//        Collections.sort(setShips);
//        return setShips;
//    }
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
