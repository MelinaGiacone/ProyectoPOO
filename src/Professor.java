public class Professor {
    private String name;
    private int idProfessor;
    private Department department;
    private SubjectManager subjectManager;
    private ClassHourManager classHourManager;

    public Professor(String name, int idProfessor, Department department,
                     SubjectManager subjectManager, ClassHourManager classHourManager) {
        this.name = name;
        this.idProfessor = idProfessor;
        this.department = department;
        this.subjectManager = subjectManager;
        this.classHourManager = classHourManager;
    }

    public void addSubject(Subject subject) {
        subjectManager.addSubject(subject);
    }

    public void addClassHour(ClassHour classHour) {
        classHourManager.addClassHour(classHour);
    }

    public void showSubjects() {
        subjectManager.showSubjects();
    }

    public void showClassHours() {
        classHourManager.showClassHours();
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                ", idProfessor=" + idProfessor +
                ", department=" + department +
                '}';
    }
}

