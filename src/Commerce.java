public class Commerce extends Department {
    private String specialization;

    public Commerce(String name, int idDepartment, String specialization) {
        super(name, idDepartment);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Commerce{" +
                "specialization=" + specialization +
                '}';
    }
}
