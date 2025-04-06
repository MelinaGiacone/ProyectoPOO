import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class StudioHead extends Professor {
    private Responsibility responsibility;
    private ArrayList<CoverHour> coverHours;
    private AvailabilityChecker availabilityChecker;

    public StudioHead(String name, int idProfessor, Department department, Responsibility responsibility, AvailabilityChecker availabilityChecker) {
        super(name, idProfessor, department);
        this.responsibility = responsibility;
        coverHours = new ArrayList<>();
        this.availabilityChecker = availabilityChecker;
    }

    public void addCoverHour(CoverHour coverHour){
        coverHours.add(coverHour);
    }

    public ArrayList<CoverHour> getCoverHours() {
        return coverHours;
    }

    public boolean isAvailable(DayOfWeek dayOfWeek, LocalTime start, LocalTime end) {
        List<ClassHour> classHours = getAllClassHours();
        return availabilityChecker.isAvailable(dayOfWeek, start, end, classHours, coverHours);
    }


    @Override
    public String toString() {
        return "StudioHead{" +
                "responsibility='" + responsibility + '\'' +
                ", coverHours=" + coverHours +
                '}';
    }
}
