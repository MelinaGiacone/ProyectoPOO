import java.util.List;

public interface ManageableDepartment {
    void addProfessor(Professor professor);
    void removeProfessor(Professor professor);
    List<Professor> getProfessorsList();
}
