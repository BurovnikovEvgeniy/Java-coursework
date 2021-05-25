package common;

import Controller.TimetableController;
import org.springframework.boot.SpringApplication;

//@SpringBootApplication
public class JobSimulation {
    public static void main(String[] args) {
        try {
            SpringApplication.run(TimetableController.class, args);
            //SpringApplication.run(JobSimulation.class, args);
//            Timetable ourTimetable = new Timetable();
//            ourTimetable.showTimetable();
//            CustomAdditionToTimetable.addCustomShipInTheTimetable(ourTimetable);
//            SerializerTimetable.serializeTimetable(ourTimetable, "timetable.json");
            //WorkingPort.findOptimalPortOperation(ourTimetable);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
