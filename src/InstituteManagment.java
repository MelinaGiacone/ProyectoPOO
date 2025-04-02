import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;


public class InstituteManagment {
    private ArrayList<Professor> professors;
    private TimeRange timeRange;

    public InstituteManagment() {
        professors = new ArrayList<>();
    }

    public void addProfessor(Professor professor){
        professors.add(professor);
    }

    Scanner sc = new Scanner(System.in);

    public ArrayList<StudioHead> showAvailableSubstitutes() {
        TimeRange timeRange = getTimeRangeInput();
        ArrayList<StudioHead> availableSubstitutes = new ArrayList<>();

        for (Professor professor : professors) {
            if (professor instanceof StudioHead) {
                StudioHead studioHead = (StudioHead) professor;
                if (studioHead.isAvailable(timeRange.getDayOfWeek(), timeRange.getStartTime(), timeRange.getEndTime())) {
                    availableSubstitutes.add(studioHead);
                }
            }
        }

        if (!availableSubstitutes.isEmpty()) {
            System.out.println("Available professors for substitutions:");
            for (StudioHead studioHead : availableSubstitutes) {
                System.out.println(" - " + studioHead.getName() + " (ID: " + studioHead.getIdProfessor() + ")");
            }
        } else {
            System.out.println("No professors are available for substitutions at the specified time.");
        }

        return availableSubstitutes;
    }


    public void assignSubstituteProfessor() {
        ArrayList<StudioHead> availableSubstitutes = showAvailableSubstitutes();

        if (!availableSubstitutes.isEmpty()) {
            StudioHead selectedSubstitute = availableSubstitutes.get(0);

            System.out.println("Enter the class to be substituted: ");
            String className = sc.nextLine();

            CoverHour newCoverHour = new CoverHour(timeRange.getDayOfWeek(), timeRange.getStartTime(), timeRange.getEndTime(), className);
            selectedSubstitute.addCoverHour(newCoverHour);

            System.out.println("Professor " + selectedSubstitute.getName() + " has been assigned to the class: " + className);
        } else {
            System.out.println("No professors are available for substitution in this time range.");
        }
    }


    public void sendNotificationIfNoSubstituteAvailable() {
        ArrayList<StudioHead> availableSubstitutes = showAvailableSubstitutes();

        if (availableSubstitutes.isEmpty()) {
            System.out.println("No professors are available to substitute. The study group can go home.");
        } else {
            System.out.println("There are available substitutes, no need to send a notification.");
        }
    }

    public void registerAbsence() {
        System.out.println("Enter the ID of the absent professor: ");
        int idProfessor = sc.nextInt();sc.nextLine();

        boolean professorFound = false;
        for (Professor professor : professors) {
            if (professor.getIdProfessor() == idProfessor) {
                professorFound = true;
                System.out.println("Enter the reason for the absence: ");
                String reason = sc.nextLine();
                System.out.println("Absence registered of " + professor.getName() + " for reason: " + reason);
                break;
            }
        }

        if (!professorFound) {
            System.out.println("No professor found with ID: " + idProfessor);
        }
    }

    public void showSubjectsAssignedToProfessors() {
        if (professors.isEmpty()) {
            System.out.println("No professors available in the system.");
            return;
        }

        for (Professor professor : professors) {
            System.out.println("Professor: " + professor.getName() + " (ID: " + professor.getIdProfessor() + ")");
            if (professor.getSubjects().isEmpty()) {
                System.out.println("  No subjects assigned.");
            } else {
                System.out.println("  Subjects assigned:");
                for (Subject subject : professor.getSubjects()) {
                    System.out.println("    - " + subject.getName());
                }
            }
            System.out.println();
        }
    }

    public TimeRange getTimeRangeInput() {
        System.out.println("Enter the day of the week: ");
        String dayInput = sc.nextLine().toUpperCase();
        DayOfWeek dayOfWeek = DayOfWeek.valueOf(dayInput);

        System.out.println("Enter the start time (format HH:mm): ");
        String entrada = sc.nextLine();

        System.out.println("Enter the end time (format HH:mm): ");
        String salida = sc.nextLine();

        LocalTime startTime = convertStringToLocalTime(entrada);
        LocalTime endTime = convertStringToLocalTime(salida);

        return new TimeRange(dayOfWeek, startTime, endTime);
    }

    // Existing helper method to convert string to LocalTime
    private LocalTime convertStringToLocalTime(String timeString) {
        return LocalTime.parse(timeString);
    }
}
