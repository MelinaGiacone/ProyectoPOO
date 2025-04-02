public class Administration extends Department{
    private boolean dualProgram;

    public Administration(String name, int idDepartment, boolean dualProgram) {
        super(name, idDepartment);
        this.dualProgram = dualProgram;
    }

    public boolean isDualProgram() {
        return dualProgram;
    }

    public void setDualProgram(boolean dualProgram) {
        this.dualProgram = dualProgram;
    }

    @Override
    public String toString() {
        return "Administration{" +
                "dualProgram=" + dualProgram +
                '}';
    }
}
