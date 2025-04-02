import java.util.List;

public interface SubjectManager {
    void addSubject(Subject subject);
    void removeSubject(Subject subject);
    List<Subject> getAllSubjects();
    void showSubjects();
}
