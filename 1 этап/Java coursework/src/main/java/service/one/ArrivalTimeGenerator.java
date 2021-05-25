package service.one;

import common.Time;

import java.util.Random;

public class ArrivalTimeGenerator
{
    private static Random r = new Random();
    public static Time getArrivalData(int borderForDay, int borderForHours, int borderForMinutes)
    {
        try
        {
            if (borderForHours > 24 || borderForMinutes > 60)
                throw new IllegalArgumentException("Going beyond the logical boundary of time");
        }
        catch (IllegalArgumentException e)
        {
            e.getStackTrace();
        }
        return new Time(generateRandomDay(borderForDay), generateRandomHour(borderForHours),
            generateRandomMinutes(borderForMinutes));
    }

    private static int generateRandomDay(int borderForDay)
    {
        int a = r.nextInt(borderForDay);
        return a;
    }
    private static int generateRandomHour(int borderForHours)
    {
        return r.nextInt(borderForHours);
    }
    private static int generateRandomMinutes(int borderForMinutes)
    {
        return r.nextInt(borderForMinutes);
    }
}
