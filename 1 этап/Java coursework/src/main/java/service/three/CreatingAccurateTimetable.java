package service.three;

import common.Configuration;
import common.Time;
import service.one.Timetable;
import service.two.SerializerTimetable;

import java.io.IOException;
import java.util.Collections;
import java.util.Random;

public class CreatingAccurateTimetable {
    private static Random r = new Random();
    private static final int deltaArrivalTime = Configuration.deltaOfTheShipArrivalAtThePort * 24 * 60;

    public static Timetable creatAccurateTimetable(Timetable timetable, String fileName) throws IOException {
        for (int i = 0; i < timetable.getNumberShip(); ++i)
        {
            timetable.getSetShips().elementAt(i)
                    .setArrivalTime(new Time(timetable.getSetShips().elementAt(i).getArrivalTime().getTime()
                    + ((-1) * r.nextInt(deltaArrivalTime) + deltaArrivalTime)));
            if (timetable.getSetShips().elementAt(i).getArrivalTime().getTime() < 0)
            {
                timetable.getSetShips().elementAt(i).setArrivalTime(new Time(0));
            }
        }
        Collections.sort(timetable.getSetShips());
        if (fileName != null)
        {
            SerializerTimetable.serializeTimetable(timetable, fileName);
        }
        return timetable;
    }
}
