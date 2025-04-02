public class InformationTechnology extends Department implements HackathonProgram {

    public InformationTechnology(String name, int idDepartment) {
        super(name, idDepartment);
    }

    public boolean hasHackathonProgram() {
        return true; // En este caso asumo que siempre lo tiene
    }

    @Override
    public String toString() {
        return super.toString() + ", hasHackathonProgram=" + hasHackathonProgram();
    }
}
