import java.time.DayOfWeek;
import java.time.LocalTime;

public class ClassHour extends Hour {
    private String group;
    private Subject subject;

    public ClassHour(DayOfWeek weekDay, LocalTime startTime, LocalTime endTime, String group, Subject subject) {
        super(weekDay, startTime, endTime);
        this.group = group;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "ClassHour{" +
                "group='" + group + '\'' +
                ", subject=" + subject +
                '}';
    }
}
