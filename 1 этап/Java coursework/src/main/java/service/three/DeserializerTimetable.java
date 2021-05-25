package service.three;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Ship;
import service.one.Timetable;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class DeserializerTimetable {
    public static Vector<Ship> deserializeTimetable(Timetable timetable, String nameFile) throws IOException {
        ObjectMapper or = new ObjectMapper();
        //Vector<Ship> listCar = or.readValue(new File("timetable.json"), new TypeReference<Vector<Ship>>(){});
        return or.readValue(new File(nameFile), new TypeReference<Vector<Ship>>(){});
    }
}
