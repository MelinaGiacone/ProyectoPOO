import java.util.Scanner;
import java.time.LocalTime;
import java.time.DayOfWeek;


public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

// Objetos departamento
        Commerce commerceDepartment1 = new Commerce("Commerce", 1, "Marketing");
        InformationTechnology iTDepartment1 = new InformationTechnology("DAW", 1, true);

// Objetos profesor
        Professor professor1 = new Professor("Sofía Gomez", 101, commerceDepartment1);
        Professor professor2 = new Professor("Luis Peréz", 102, iTDepartment1);
        Professor professor3 = new Professor("Josef Gele", 103, iTDepartment1);
        Professor professor4 = new Professor("Josefina Loren", 107, iTDepartment1);
        StudioHead studioHead1 = new StudioHead("Alberto Valiente", 104, commerceDepartment1, "Head of Marketing");
        StudioHead studioHead2 = new StudioHead("Maria López", 105, iTDepartment1, "Head of Development");
        StudioHead studioHead3 = new StudioHead("Carlos Ramos", 106, commerceDepartment1, "Head of Sales");

// Objeto subject
        Subject digitalMarketing = new Subject("Digital Marketing", commerceDepartment1,professor1);
        Subject devEnviroments = new Subject("Development Environments", iTDepartment1,professor2);
        Subject programming = new Subject("Programming", iTDepartment1, professor3);
        Subject computerScience = new Subject("Computer Science", iTDepartment1, professor4);
        professor1.addSubject(digitalMarketing);
        professor2.addSubject(devEnviroments);
        professor3.addSubject(programming);

// Objetos horas
        ClassHour classMon1 = new ClassHour(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(10, 0), "DAW1", devEnviroments);
        ClassHour classMon2 = new ClassHour(DayOfWeek.MONDAY, LocalTime.of(10, 30), LocalTime.of(12, 30), "DAW1", programming);
        ClassHour classMon3 = new ClassHour(DayOfWeek.MONDAY, LocalTime.of(12, 30), LocalTime.of(14, 30), "DAW1", computerScience);
        ClassHour classTues1 = new ClassHour(DayOfWeek.TUESDAY, LocalTime.of(8, 0), LocalTime.of(10, 0), "DAW1", programming);
        ClassHour classTues2 = new ClassHour(DayOfWeek.TUESDAY, LocalTime.of(10, 30), LocalTime.of(12, 30), "DAW1", computerScience);
        ClassHour classTues3 = new ClassHour(DayOfWeek.TUESDAY, LocalTime.of(12, 30), LocalTime.of(14, 30), "DAW1",devEnviroments);

        CoverHour coverHour1 = new CoverHour(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(10, 0), "Covered");
        CoverHour coverHour2 = new CoverHour(DayOfWeek.MONDAY, LocalTime.of(10, 30), LocalTime.of(12, 30), "Covered");
        CoverHour coverHour3 = new CoverHour(DayOfWeek.TUESDAY, LocalTime.of(10, 30), LocalTime.of(12, 30), "Covered");
        CoverHour coverHour4 = new CoverHour(DayOfWeek.TUESDAY, LocalTime.of(14, 30), LocalTime.of(14, 30), "Pending");

        // Asignación de horarios
        professor2.addClassHour(classMon1);
        professor3.addClassHour(classMon2);
        professor4.addClassHour(classMon3);
        professor3.addClassHour(classTues1);
        professor4.addClassHour(classTues2);
        professor2.addClassHour(classTues3);

        studioHead3.addCoverHour(coverHour3);
        studioHead1.addCoverHour(coverHour1);
        studioHead2.addCoverHour(coverHour4);
        studioHead3.addCoverHour(coverHour2);

        studioHead2.addCoverHour(coverHour2);
        studioHead1.addCoverHour(coverHour2);

        // Agregar profesores a departamentos
        commerceDepartment1.addProfessor(professor1);
        commerceDepartment1.addProfessor(studioHead1);
        commerceDepartment1.addProfessor(studioHead3);

        iTDepartment1.addProfessor(professor2);
        iTDepartment1.addProfessor(professor3);
        iTDepartment1.addProfessor(professor4);
        iTDepartment1.addProfessor(studioHead2);


        InstituteManagment managment = new InstituteManagment();
        managment.addProfessor(professor1);
        managment.addProfessor(professor2);
        managment.addProfessor(professor3);
        managment.addProfessor(professor4);
        managment.addProfessor(studioHead1);
        managment.addProfessor(studioHead2);
        managment.addProfessor(studioHead3);


        //Menú
        int option = -1;

        while (option != 0) {
            menu();
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    managment.showAvailableSubstitutes();
                    break;
                case 2:
                    managment.assignSubstituteProfessor();
                    break;
                case 3:
                    managment.sendNotificationIfNoSubstituteAvailable();
                    break;
                case 4:
                    managment.registerAbsence();
                    break;
                case 5:
                    managment.showSubjectsAssignedToProfessors();
                    break;
                default:
                    System.out.println("Invalid option. Please, select an available option.");
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("Menu: ");
        System.out.println("1- Show the list of professors available for substitutions within a specific time range.");
        System.out.println("2- Assign a substitute professor to a class.");
        System.out.println("3- Send a notification to the study group when no professors are available to cover the substitute.");
        System.out.println("4- Record the absences of professors for tracking purposes.");
        System.out.println("5- Show the subjects assigned to each professor.");
        System.out.println("Please, select an option:");
    }

}
