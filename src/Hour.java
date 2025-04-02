import java.time.DayOfWeek;
import java.time.LocalTime;

//Esta la voy a hacer abstracta porque no me interesa instanciarla
public abstract class Hour {
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

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
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
