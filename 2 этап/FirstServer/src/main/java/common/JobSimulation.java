package common;

import controller.TimetableController;
import org.springframework.boot.SpringApplication;

public class JobSimulation {
    public static void main(String[] args) {
        try {

            SpringApplication.run(TimetableController.class, args);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
