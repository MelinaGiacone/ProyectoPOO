import java.time.DayOfWeek;
import java.time.LocalTime;

public class CoverHour extends Hour {
    private Status status;
    private Subject subject;

    public CoverHour(DayOfWeek weekDay, LocalTime startTime, LocalTime endTime, Status status, Subject subject) {
        super(weekDay, startTime, endTime);
        this.status = status;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "CoverHour{" +
                "status='" + status + '\'' +
                ", subject=" + subject +
                '}';
    }
}
