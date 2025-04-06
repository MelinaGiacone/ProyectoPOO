import java.time.DayOfWeek;
import java.time.LocalTime;

public class TimeRangeImpl extends TimeRange {
    public TimeRangeImpl(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        super(dayOfWeek, startTime, endTime);
    }
}

