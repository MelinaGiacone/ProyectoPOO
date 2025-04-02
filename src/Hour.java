import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.DayOfWeek;

public class Hour {
    private DayOfWeek weekDay;
    private LocalTime startTime;
    private LocalTime endTime;

    public Hour(DayOfWeek weekDay, LocalTime startTime, LocalTime endTime) {
        this.weekDay = weekDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public DayOfWeek getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(DayOfWeek weekDay) {
        this.weekDay = weekDay;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Hour{" +
                "weekDay='" + weekDay + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
