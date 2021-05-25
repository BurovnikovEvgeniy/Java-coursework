package common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.one.Timetable;
import service.three.WorkingPort;
import service.two.CustomAdditionToTimetable;
import service.two.SerializerTimetable;

import java.util.Vector;

public class JobSimulation {
    public static void main(String[] args){
        try {
            Timetable ourTimetable = new Timetable();
            Vector<Ship> cat = ourTimetable.createTimetableWithRandomValue();
            ourTimetable.showTimetable();
            CustomAdditionToTimetable.addCustomShipInTheTimetable(ourTimetable);
            SerializerTimetable.serializeTimetable(ourTimetable, "timetable.json");
            WorkingPort.findOptimalPortOperation(ourTimetable);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
