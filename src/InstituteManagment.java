import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

public class InstituteManagment {
    private ArrayList<Professor> professors;

    public InstituteManagment() {
        professors = new ArrayList<>();
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public TimeRange getTimeRangeInput(DayOfWeek dayOfWeek, String startTimeStr, String endTimeStr) {
        LocalTime startTime = convertStringToLocalTime(startTimeStr);
        LocalTime endTime = convertStringToLocalTime(endTimeStr);

        return new TimeRangeImpl(dayOfWeek, startTime, endTime);
    }

    private LocalTime convertStringToLocalTime(String timeString) {
        return LocalTime.parse(timeString);
    }

    public ArrayList<StudioHead> showAvailableSubstitutes(DayOfWeek dayOfWeek, String startTimeStr, String endTimeStr) {
        TimeRange timeRange = getTimeRangeInput(dayOfWeek, startTimeStr, endTimeStr);
        ArrayList<StudioHead> availableSubstitutes = new ArrayList<>();

        for (Professor professor : professors) {
            if (professor instanceof StudioHead) {
                StudioHead studioHead = (StudioHead) professor;
                if (studioHead.isAvailable(timeRange.getDayOfWeek(), timeRange.getStartTime(), timeRange.getEndTime())) {
                    availableSubstitutes.add(studioHead);
                }
            }
        }

        showMessage(availableSubstitutes);
        return availableSubstitutes;
    }

    private static void showMessage(ArrayList<StudioHead> availableSubstitutes) {
        if (availableSubstitutes.isEmpty())
            System.out.println("No professors are available for substitutions at the specified time.");
        else {
            System.out.println("Available professors for substitutions:");
            for (StudioHead studioHead : availableSubstitutes) {
                System.out.println(" - " + studioHead.getName() + " (ID: " + studioHead.getIdProfessor() + ")");
            }
        }
    }

    public void assignSubstituteProfessor(String startTimeStr, String endTimeStr, DayOfWeek dayOfWeek, Subject subject) {
        ArrayList<StudioHead> availableSubstitutes = showAvailableSubstitutes(dayOfWeek, startTimeStr, endTimeStr);

        if (!availableSubstitutes.isEmpty()) {
            StudioHead selectedSubstitute = availableSubstitutes.get(0);

            CoverHour newCoverHour = new CoverHour(dayOfWeek,
                    LocalTime.parse(startTimeStr),
                    LocalTime.parse(endTimeStr),
                    Status.PENDING,
                    subject);

            selectedSubstitute.addCoverHour(newCoverHour);

            System.out.println("Professor " + selectedSubstitute.getName() + " has been assigned to substitute the class: " + subject.getName());
        } else {
            System.out.println("No professors are available for substitution in this time range.");
        }
    }


    public void sendNotificationIfNoSubstituteAvailable(String startTimeStr, String endTimeStr, DayOfWeek dayOfWeek, Subject subject) {
        ArrayList<StudioHead> availableSubstitutes = showAvailableSubstitutes(dayOfWeek, startTimeStr, endTimeStr);

        showNotification(availableSubstitutes);
    }

    private static void showNotification(ArrayList<StudioHead> availableSubstitutes) {
        if (availableSubstitutes.isEmpty()) {
            System.out.println("No professors are available to substitute. The study group can go home.");
        } else {
            System.out.println("There are available substitutes, no need to send a notification.");
        }
    }

    public void registerAbsence(int id, String reason) {
        boolean professorFound = false;
        for (Professor professor : professors) {
            if (professor.getIdProfessor() == id) {
                professorFound = true;
                System.out.println("Absence registered of " + professor.getName() + " for reason: " + reason);
                break;
            }
        }

        showMessageNotFound(id, professorFound);
    }

    private static void showMessageNotFound(int id, boolean professorFound) {
        if (!professorFound) {
            System.out.println("No professor found with ID: " + id);
        }
    }

    public void showSubjectsAssignedToProfessors() {
        for (Professor professor : professors) {
            System.out.println("Professor: " + professor.getName() + " (ID: " + professor.getIdProfessor() + ")");

            // Accedemos al SubjectManager del profesor para mostrar los subjects asignados
            printSubjects(professor);
        }
    }

    private void printSubjects(Professor professor) {
        SubjectManager subjectManager = professor.getSubjectManager();

        if (!subjectManager.getAllSubjects().isEmpty()) {
            System.out.println("Subjects assigned:");
            subjectManager.showSubjects();
        } else {
            System.out.println("No subjects assigned.");
        }
        System.out.println();
    }

}

