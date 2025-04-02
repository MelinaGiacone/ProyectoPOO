import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

public class StudioHead extends Professor {
    private String responsibility;
    private ArrayList<CoverHour> coverHours;

    public StudioHead(String name, int idProfessor, Department department, String responsibility) {
        super(name, idProfessor, department);
        this.responsibility = responsibility;
        coverHours = new ArrayList<>();
    }

    public ArrayList<CoverHour> getCoverHours() {
        return coverHours;
    }

    public void setCoverHours(ArrayList<CoverHour> coverHours) {
        this.coverHours = coverHours;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public void addCoverHour(CoverHour coverHour){
        coverHours.add(coverHour);
    }

    public boolean isAvailable(DayOfWeek dayOfWeek, LocalTime start, LocalTime end) {
        for (ClassHour classHour : getClassHours()) {
            if (classHour.getWeekDay() == dayOfWeek && isTimeOverlap(classHour.getStartTime(), classHour.getEndTime(), start, end)) {
                return false;
            }
        }

        for (CoverHour coverHour : coverHours) {
            if (coverHour.getWeekDay() == dayOfWeek && isTimeOverlap(coverHour.getStartTime(), coverHour.getEndTime(), start, end)) {
                return false;
            }
        }

        return true;
    }

    private boolean isTimeOverlap(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
        return !start1.isAfter(end2) && !end1.isBefore(start2);
    }

    @Override
    public String toString() {
        return "StudioHead{" +
                "responsibility='" + responsibility + '\'' +
                ", coverHours=" + coverHours +
                '}';
    }
}
