
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

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }



    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", department=" + department +
                ", professor=" + professor +
                 +
                '}';
    }
}
