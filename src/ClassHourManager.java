import java.util.List;

public interface ClassHourManager {
    void addClassHour(ClassHour classHour);
    void removeClassHour(ClassHour classHour);
    List<ClassHour> getAllClassHours();
    void showClassHours();
}

