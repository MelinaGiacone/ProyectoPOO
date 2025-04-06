import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestInstitute {
    private InstituteManagment instituteManagment;
    private Professor professor1;
    private StudioHead studioHead;
    private ClassHour classHour1;
    private AvailabilityChecker availabilityChecker;
    private CoverHour coverHour1;
    private Department dept1, dept3;
    private Subject subject1;
    private SubjectManagerImpl subjectManager;


    @BeforeEach
    public void setUp() {
        // Creo instancias de departamentos,profesor, subject
        dept1 = new Commerce("Marketing", 1, "Digital Marketing");
        dept3 = new InformationTechnology("Software Engineering", 3);

        // Creamos primero el profesor
        professor1 = new Professor("Alice Smith", 101, dept1);

        // Creamos la asignatura después de tener al profesor
        subject1 = new Subject("Marketing Strategy", dept1, professor1);

        // Creamos y asignamos el SubjectManager al profesor
        subjectManager = new SubjectManagerImpl();
        professor1.setSubjectManager(subjectManager);
        professor1.setClassHourManager(new ClassHourManagerImpl());

        // Añadimos la asignatura al SubjectManager del profesor
        professor1.addSubject(subject1);

        // Creamos la instancia de InstituteManagment y agregamos profesores
        instituteManagment = new InstituteManagment();
        instituteManagment.addProfessor(professor1);

        // Creo un StudioHead
        availabilityChecker = new AvailabilityChecker();
        studioHead = new StudioHead("Carlos Martínez", 54321, dept1, Responsibility.DIRECTOR, availabilityChecker);
        studioHead.setClassHourManager(new ClassHourManagerImpl());

        // Creo y añado horas de clase y cobertura
        classHour1 = new ClassHour(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(11, 0), "Grupo A", subject1);
        studioHead.addClassHour(classHour1);

        coverHour1 = new CoverHour(DayOfWeek.MONDAY, LocalTime.of(11, 0), LocalTime.of(13, 0), Status.PENDING, subject1);
        studioHead.addCoverHour(coverHour1);

        // Añado StudioHead al InstituteManagment
        instituteManagment.addProfessor(studioHead);
    }
    @Test
    public void testAddProfessor() {
        Professor professor2 = new Professor("Bob Johnson", 102, dept3);
        instituteManagment.addProfessor(professor2);
        assertEquals(3, instituteManagment.getProfessors().size());
    }

    @Test
    public void testAssignSubjectToProfessor() {
        // Asignamos la materia al profesor
        professor1.addSubject(subject1);

        // Imprimir los sujetos para ver si se agrega correctamente
        System.out.println("Subjects assigned to Professor: " + subjectManager.getAllSubjects());

        // Verificamos que la asignatura esté en el SubjectManager del profesor
        assertTrue(subjectManager.getAllSubjects().contains(subject1), "The subject should be assigned to the professor.");

        // Verifica si el profesor tiene al menos una asignatura
        assertTrue(professor1.getDepartment() != null, "Professor department should not be null.");
    }


    @Test
    public void testShowAvailableSubstitutes() {
        // Verifico que el StudioHead no está disponible de 9:00 a 11:00 el lunes
        String startTimeStr = "09:00";
        String endTimeStr = "11:00";
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
        ArrayList<StudioHead> availableSubstitutes = instituteManagment.showAvailableSubstitutes(dayOfWeek, startTimeStr, endTimeStr);
        assertTrue(availableSubstitutes.isEmpty());

        // Verifico que el StudioHead está disponible de 14:00 a 16:00
        startTimeStr = "14:00";
        endTimeStr = "16:00";
        availableSubstitutes = instituteManagment.showAvailableSubstitutes(dayOfWeek, startTimeStr, endTimeStr);
        assertEquals(1, availableSubstitutes.size());
        assertEquals("Carlos Martínez", availableSubstitutes.get(0).getName());
    }

    @Test
    public void testAssignSubstituteProfessor() {
        // Parámetros para el test
        String startTimeStr = "11:00";
        String endTimeStr = "13:00";
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;

        // Llam0 al metodo para asignar el sustituto
        instituteManagment.assignSubstituteProfessor(startTimeStr, endTimeStr, dayOfWeek, subject1);

        // Verific0 que el CoverHour ha sido asignado correctamente
        ArrayList<CoverHour> coverHours = studioHead.getCoverHours();
        assertEquals(1, coverHours.size(), "The StudioHead should have 1 cover hours now.");

        // Verific0 que el nuevo CoverHour se ha agregado correctamente
        CoverHour newCoverHour = coverHours.get(0); // El segundo CoverHour debería ser el nuevo
        assertEquals(LocalTime.parse(startTimeStr), newCoverHour.getStartTime(), "The start time of the new CoverHour should be 13:00.");
        assertEquals(LocalTime.parse(endTimeStr), newCoverHour.getEndTime(), "The end time of the new CoverHour should be 15:00.");
    }

    @Test
    void testSendNotificationIfNoSubstituteAvailable_WithSubstitute() {
        // Redirigo la salida a un ByteArrayOutputStream para capturar la salida
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);  // Establecer el flujo de salida

        // Simulamos que hay sustitutos disponibles (el StudioHead está libre en el rango de tiempo dado)
        ArrayList<StudioHead> availableSubstitutes = new ArrayList<>();
        availableSubstitutes.add(studioHead); // El StudioHead está libre durante ese tiempo

        String startTimeStr = "14:00";
        String endTimeStr = "16:00";
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;

        instituteManagment.sendNotificationIfNoSubstituteAvailable(startTimeStr, endTimeStr, dayOfWeek, subject1);

        // Verificar que la salida contiene el mensaje esperado de que no se necesita enviar notificación
        String expectedOutput = "There are available substitutes, no need to send a notification.";
        assertTrue(outputStream.toString().contains(expectedOutput), "The output should indicate that no notification is needed.");
    }

    @Test
    void testSendNotificationIfNoSubstituteAvailable_NoSubstitute() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);  // Establecer el flujo de salida

        // Llamar al metodo con un rango de tiempo en el que no hay sustitutos
        String startTimeStr = "09:00";
        String endTimeStr = "11:00";
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;

        // Simular que no hay sustitutos disponibles
        ArrayList<StudioHead> availableSubstitutes = new ArrayList<>();
        availableSubstitutes.add(studioHead); // El StudioHead está ocupado durante ese tiempo.

        // Aquí estamos invocando el metodo con la suposición de que no hay sustitutos disponibles
        instituteManagment.sendNotificationIfNoSubstituteAvailable(startTimeStr, endTimeStr, dayOfWeek, subject1);

        // Verificar que la salida contiene el mensaje esperado
        String expectedOutput = "No professors are available to substitute. The study group can go home.";
        assertTrue(outputStream.toString().contains(expectedOutput), "The output should indicate no substitutes available.");
    }

    @Test
    void testRegisterAbsence_ProfessorFound() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        String reason = "Personal reasons";
        int id = 101;
        instituteManagment.registerAbsence(id, reason);

        String expectedOutput = "Absence registered of Alice Smith for reason: Personal reasons";
        assertTrue(outputStream.toString().contains(expectedOutput), "The output should indicate the absence was registered correctly.");
    }
}


