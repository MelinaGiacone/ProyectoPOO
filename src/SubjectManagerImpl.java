import java.util.ArrayList;
import java.util.List;

public class SubjectManagerImpl implements SubjectManager {
    private final List<Subject> subjects;

    public SubjectManagerImpl() {
        subjects = new ArrayList<>();
    }



    @Override
    public void addSubject(Subject subject) {
        if (subject == null) {
            System.out.println("The subject cannot be null.");
        } else {
            subjects.add(subject);
            System.out.println("Subject added: " + subject.getName());  // Para verificar que la asignatura se agrega
        }
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
