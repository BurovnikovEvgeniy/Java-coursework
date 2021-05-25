package common;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import service.one.TimetableService;
import service.three.ProcessingResult;
import service.three.WorkingPort;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootApplication
public class JobSimulation {
    public static void main(String[] args) {
        try
        {
            TimetableService k = new TimetableService();
            String fileWithResult = "result.json";
            String fileWithTimetable = "timedtable.json";
            try {
                Files.deleteIfExists(Path.of(fileWithResult));
            } catch (IOException e) {
                e.printStackTrace();
            }
            RestTemplate restTemplate = new RestTemplate();
            String urlService2 = "http://localhost:8062/second_service";
            restTemplate.getForEntity(urlService2 + "/getConfiguration", Configuration.class);
            restTemplate.getForEntity(urlService2 + "/getTimetableInJson", File.class).getBody();
            try {
                ResponseEntity reqestTimetable = restTemplate.getForEntity(urlService2 + "/getTimetableByName/" + fileWithTimetable, Timetable.class);
                if (reqestTimetable.getStatusCode() == HttpStatus.OK) {
                    Timetable ourTimetable =
                            restTemplate.getForEntity(urlService2 + "/getTimetableByName/" + fileWithTimetable, Timetable.class).getBody();
                    ProcessingResult result = WorkingPort.findOptimalPortOperation(ourTimetable);
                    restTemplate.postForObject(urlService2 + "/sendStatistic", result, Void.class);
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            System.out.println("I like my computer");
            //ProcessingResult result = WorkingPort.findOptimalPortOperation(ourTimetable);
//            StringWriter writer = new StringWriter();
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.writeValue(writer, result);
//            String resultInString = new String(writer.toString());
            //restTemplate.postForObject(urlService2 + "/sendStatistic", result, Void.class);
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("error");
        }
    }
}
