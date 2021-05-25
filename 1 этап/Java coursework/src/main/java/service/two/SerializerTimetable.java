package service.two;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import service.one.Timetable;

import java.io.File;
import java.io.IOException;

public class SerializerTimetable {
    public static void serializeTimetable(Timetable timetable, String nameFile) throws IOException
    {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        ow.writeValue(new File(nameFile), timetable.getSetShips());
    }
}
