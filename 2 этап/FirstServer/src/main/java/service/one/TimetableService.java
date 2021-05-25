package service.one;

import com.fasterxml.jackson.core.JsonProcessingException;
import common.Configuration;
import common.Timetable;
import org.springframework.stereotype.Service;

@Service
public class TimetableService {

    public Timetable timetable = new Timetable();

    public Timetable create()
    {
        if (timetable.empty())
        {
            timetable.createTimetableWithRandomValue();
        }
        timetable.showTimetable();
        return timetable;
    }

    public Configuration getTimetableConfiguration() throws JsonProcessingException {
        return new Configuration();
    }


}
