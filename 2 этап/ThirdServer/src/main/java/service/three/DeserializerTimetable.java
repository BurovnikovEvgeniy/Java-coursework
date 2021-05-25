package service.three;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.Timetable;

import java.io.File;
import java.io.IOException;

public class DeserializerTimetable {
    public static Timetable deserializeTimetable(File file) throws IOException {
        ObjectMapper or = new ObjectMapper();
        return or.readValue(file, Timetable.class);
    }
}
