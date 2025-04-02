import java.time.DayOfWeek;
import java.time.LocalTime;

public class CoverHour extends Hour {
    private String status;

    public CoverHour(DayOfWeek weekDay, LocalTime startTime, LocalTime endTime, String status) {
        super(weekDay, startTime, endTime);
        this.status = status;
    }

    @Override
    public String toString() {
        return "CoverHour{" +
                "status='" + status + '\'' +
                '}';
    }
}
