import java.util.List;

public class Professor {
    private String name;
    private int idProfessor;
    private Department department;
    private SubjectManager subjectManager;
    private ClassHourManager classHourManager;

    public Professor(String name, int idProfessor, Department department) {
        this.name = name;
        this.idProfessor = idProfessor;
        this.department = department;
    }

    public void setSubjectManager(SubjectManager subjectManager) {
        this.subjectManager = subjectManager;
    }

    public void setClassHourManager(ClassHourManager classHourManager) {
        this.classHourManager = classHourManager;
    }

    public SubjectManager getSubjectManager() {
        return subjectManager;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public List<ClassHour> getAllClassHours() {
        return classHourManager.getAllClassHours();
    }


    public void addSubject(Subject subject) {
        if (this.subjectManager != null) {
            this.subjectManager.addSubject(subject);
        }
    }


    public void addClassHour(ClassHour classHour) {
        if (classHourManager != null) {
            classHourManager.addClassHour(classHour);
        } else {
            System.out.println("ClassHourManager is not initialized.");
        }
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

