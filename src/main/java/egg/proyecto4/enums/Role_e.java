package egg.proyecto4.enums;

public enum Role_e {

    ADMIN("Administrador"), 
    USER("Usuario");

    private final String displayValue;

    private Role_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
