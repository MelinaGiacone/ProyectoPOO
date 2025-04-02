import java.util.ArrayList;
import java.util.List;

public abstract class Department implements ManageableDepartment{
    private int idDepartment;
    private String name;
    private List<Professor> professorsList;

    public Department(String name, int idDepartment) {
        this.name = name;
        this.idDepartment = idDepartment;
        professorsList = new ArrayList<>();
    }

    @Override
    public void addProfessor(Professor professor) {
        if (professor == null) {
            throw new IllegalArgumentException("Professor cannot be null");
        }
        professorsList.add(professor);
    }

    @Override
    public void removeProfessor(Professor professor) {
        professorsList.remove(professor);
    }

    @Override
    public List<Professor> getProfessorsList() {
        return professorsList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", name='" + name + '\'' +
                ", professorsList=" + professorsList +
                '}';
    }
}