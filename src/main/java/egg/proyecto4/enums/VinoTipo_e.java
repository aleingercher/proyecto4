package egg.proyecto4.enums;

public enum VinoTipo_e {

    BLANCO("Blanco"),
    TINTO("Tinto"),
    ESPUMANTE("Espumante"),
    ROSADO("Rosado");

    private final String displayValue;

    private VinoTipo_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
