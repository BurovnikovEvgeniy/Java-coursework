package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import common.Configuration;
import common.Timetable;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.one.TimetableService;

import java.util.Arrays;

@SpringBootApplication
@RestController
@RequestMapping("/first_service")
public class TimetableController {

    private final TimetableService service = new TimetableService();

    @GetMapping(value = "/generateTimetable")
    public ResponseEntity<Timetable> read()
    {
        Timetable res = service.create();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping(value = "/getConfiguration")
    public ResponseEntity<Configuration> getConfiguration() {
        Configuration res = null;
        try {
            res = service.getTimetableConfiguration();
        }catch (JsonProcessingException e)
        {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
