import java.util.ArrayList;
import java.util.List;

public class ClassHourManagerImpl implements ClassHourManager {
    private List<ClassHour> classHours;

    public ClassHourManagerImpl() {
        classHours = new ArrayList<>();
    }

    @Override
    public void addClassHour(ClassHour classHour) {
        if (classHour != null) {
            classHours.add(classHour);
        } else {
            System.out.println("The class hour cannot be null.");
        }
    }

    @Override
    public List<ClassHour> getAllClassHours() {
        return classHours;
    }

    @Override
    public void showClassHours() {
        for (ClassHour classHour : classHours) {
            System.out.println(classHour);
        }
    }
}
