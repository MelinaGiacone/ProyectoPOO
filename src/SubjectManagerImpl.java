import java.util.ArrayList;
import java.util.List;

public class SubjectManagerImpl implements SubjectManager {
    private List<Subject> subjects;

    public SubjectManagerImpl() {
        subjects = new ArrayList<>();
    }

    @Override
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    @Override
    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjects;
    }

    @Override
    public void showSubjects() {
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
    }
}
