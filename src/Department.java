import java.util.ArrayList;

public class Department {
    private String name;
    private int idDepartment;
    private ArrayList<Professor> professorsList;

    public Department(String name, int idDepartment) {
        this.name = name;
        this.idDepartment = idDepartment;
        professorsList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public ArrayList<Professor> getProfessorsList() {
        return professorsList;
    }

    public void setProfessorsList(ArrayList<Professor> professorsList) {
        this.professorsList = professorsList;
    }

    public void addProfessor(Professor professor) {
        professorsList.add(professor);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", idDepartment=" + idDepartment +
                ", professorsList=" + professorsList +
                '}';
    }
}