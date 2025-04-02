public class InformationTechnology extends Department{
    private boolean hasHackathonProgram;

    public InformationTechnology(String name, int idDepartment, boolean hasHackathonProgram) {
        super(name, idDepartment);
        this.hasHackathonProgram = hasHackathonProgram;
    }

    public boolean isHasHackathonProgram() {
        return hasHackathonProgram;
    }

    public void setHasHackathonProgram(boolean hasHackathonProgram) {
        this.hasHackathonProgram = hasHackathonProgram;
    }

    @Override
    public String toString() {
        return "InformationTechnology{" +
                "hasHackathonProgram=" + hasHackathonProgram +
                '}';
    }
}
