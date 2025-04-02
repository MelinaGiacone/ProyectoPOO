import java.util.ArrayList;
import java.time.LocalTime;

public class Professor {
    private String name;
    private int idProfessor;
    private Department department;
    private ArrayList<ClassHour> classHours;
    private ArrayList<Subject> subjects;

    public Professor(String name, int idProfessor, Department department) {
        this.name = name;
        this.idProfessor = idProfessor;
        this.department = department;
        classHours = new ArrayList<>();
        subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ArrayList<ClassHour> getClassHours() {
        return classHours;
    }

    public void setClassHours(ArrayList<ClassHour> classHours) {
        this.classHours = classHours;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addClassHour(ClassHour classHour){
        classHours.add(classHour);
    }

    public void addSubject(Subject subject){
        subjects.add(subject);
    }

    public void subjectsList(int id){
        if(idProfessor == id){
            for(Subject subject : subjects) {
                System.out.println(subject);
            }
       }
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                ", idProfessor=" + idProfessor +
                ", department=" + department +
                ", classHours=" + classHours +
                ", subjects=" + subjects +
                '}';
    }
}
