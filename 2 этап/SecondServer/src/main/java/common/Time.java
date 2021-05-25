package common;

public class Time
{
    private int time = 0;
    public Time()
    {
        this.time = 0;
    }

    public Time(int minutes)
    {
        this.time = minutes;
    }

    public Time(int days, int hours, int minutes)
    {
        this.time = days * 24 * 60 + hours * 60 + minutes;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime()
    {
        return time;
    }
    public void incTime() { time++; }
    public void addTime(int minutes)
    {
        this.time += minutes;
    }


    @Override
    public String toString() {
        int days = time / (24 * 60);
        int hours = (time - days * 24 * 60) / 60;
        int minutes = time - (days * 24 * 60 + hours * 60);
        return days + ":" + hours + ":" + minutes;
    }
    public static Time fromStringToTime(String string)
    {
        string = string.trim();
        int indexFirstColon = string.indexOf(":");
        int indexLastColon = string.lastIndexOf(":");
        String day = new String(string.substring(0, indexFirstColon));
        String hour = new String(string.substring(indexFirstColon + 1, indexLastColon));
        String minutes = new String(string.substring(indexLastColon + 1, string.length()));
        return new Time(Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minutes));
    }

}
