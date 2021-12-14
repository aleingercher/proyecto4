package egg.proyecto4.enums;

public enum CervezaEnvase_e {

    LITRO("Litro"),
    LATA("Lata"),
    PORRON("Porron"),
    PACKx6("Pack de 6");

    private final String displayValue;

    private CervezaEnvase_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
