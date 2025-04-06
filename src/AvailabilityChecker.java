import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public class AvailabilityChecker {
    public boolean isAvailable(DayOfWeek dayOfWeek, LocalTime start, LocalTime end,
                               List<ClassHour> classHours, List<CoverHour> coverHours) {
        for (ClassHour classHour : classHours) {
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
}

