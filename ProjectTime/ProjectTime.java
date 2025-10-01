import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectTime {
    private String startTime;
    private String endTime;
    private float hoursLogged;

    public ProjectTime(String start, String end) {
        this.startTime = start;
        this.endTime = end;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getHoursLogged() {
        return calculater();
    }

    private String calculater() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            Date startDate = formatter.parse(getStartTime());
            Date endDate = formatter.parse(getEndTime());
            this.hoursLogged = (endDate.getTime() - startDate.getTime());
        } catch (ParseException e) {
            return "-1";
        }

        long oneMin = 1000 * 60;
        long oneHour = oneMin * 60;
        long oneDay = oneHour * 24;
        long oneMonth = oneDay * 30;
        long milisecends = (long) this.hoursLogged;

        if (milisecends < 0) {
            return "-1";
        }

        if ((milisecends / oneMin) < 120)
            return (milisecends / oneMin) + " m";

        else if ((milisecends / oneHour) < 120)
            return (milisecends / oneHour) + " h";

        else if ((milisecends / oneDay) < 120)
            return (milisecends / oneDay) + " d";

        else
            return (milisecends / oneMonth) + " mo";
    }
}