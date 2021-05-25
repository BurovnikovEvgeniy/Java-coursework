package service.two;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Configuration;
import common.Ship;
import common.Timetable;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Vector;

public class TimetableService {

    public File getTimetableAndSaveInFile() throws IOException {
        String nameFile = "timetable.json";
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8060/first_service/generateTimetable";

        Timetable timetable = restTemplate.getForEntity(url, Timetable.class).getBody();
        //CustomAdditionToTimetable.addCustomShipInTheTimetable(timetable);
        SerializerTimetable.serializeTimetable(Objects.requireNonNull(timetable), nameFile);
        return new File(nameFile);
    }

    public Configuration setConfiguration()
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8060/first_service/getConfiguration";
        return restTemplate.getForEntity(url, Configuration.class).getBody();
    }

    public Timetable deserializeTimetable(String nameFile) throws IOException {
        ObjectMapper or = new ObjectMapper();
        return new Timetable(or.readValue(new File(nameFile), new TypeReference<Vector<Ship>>(){}));
    }
}
