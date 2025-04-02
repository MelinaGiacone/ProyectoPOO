public class Commerce extends Department {
    private String specialization;

    public Commerce(String name, int idDepartment, String specialization) {
        super(name, idDepartment);
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Commerce{" +
                "specialization='" + specialization + '\'' +
                '}';
    }
}
