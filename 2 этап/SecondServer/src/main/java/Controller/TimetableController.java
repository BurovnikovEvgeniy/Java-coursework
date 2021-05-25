package Controller;

import common.Configuration;
import common.ProcessingResult;
import common.Timetable;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import service.two.TimetableService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootApplication
@RestController
@RequestMapping("/second_service")
public class TimetableController {

    private final TimetableService service = new TimetableService();

    @GetMapping(value = "/getTimetableInJson")
    public ResponseEntity<File> getTimetableInJson()
    {
        service.setConfiguration();
        File file = null;
        try {
            file = service.getTimetableAndSaveInFile();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return (file != null && file.length() != 0) ? new ResponseEntity<>(file, HttpStatus.OK):
                new ResponseEntity<>(file, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping(value = "/getConfiguration")
    public ResponseEntity<Configuration> getConfiguration()
    {
        return new ResponseEntity<>(service.setConfiguration(), HttpStatus.OK);
    }

    @GetMapping(value = "/getTimetableByName/{nameFile}")
    public ResponseEntity<Timetable> getTimetableByName(@PathVariable("nameFile") String nameFile) throws ResponseStatusException, IOException {
        if (Files.exists(Path.of(nameFile)))
        {
            return new ResponseEntity<>(service.deserializeTimetable(nameFile), HttpStatus.OK);
        }
        else
        {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File not exist");
        }
    }

    @PostMapping(value = "/sendStatistic")
    public void saveResults(@RequestBody ProcessingResult result) throws IOException {
        ProcessingResult.saveResults(result, "result.json");
    }
}

