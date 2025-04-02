import java.time.DayOfWeek;
import java.time.LocalTime;

public class ClassHour extends Hour{
    private String group;
    private Subject subject;

    public ClassHour(DayOfWeek weekDay, LocalTime startTime, LocalTime endTime, String group, Subject subject) {
        super(weekDay, startTime, endTime);
        this.group = group;
        this.subject = subject;
    }
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "ClassHour{" +
                "group='" + group + '\'' +
                ", subject=" + subject +
                '}';
    }
}
