public class Administration extends Department implements DualProgram {
    private boolean dualProgram;

    public Administration(String name, int idDepartment, boolean dualProgram) {
        super(name, idDepartment);
        this.dualProgram = dualProgram;
    }

    @Override
    public boolean isDualProgram() {
        return dualProgram;
    }

    @Override
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
