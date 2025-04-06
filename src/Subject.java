
public class Subject {
    private String name;
    private Department department;
    private Professor professor;

    public Subject(String name, Department department, Professor professor) {
        this.name = name;
        this.department = department;
        this.professor = professor;

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", department=" + department +
                ", professor=" + professor +
                +'}';
    }
}
