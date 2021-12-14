package egg.proyecto4.enums;

public enum CervezaTipo_e {
        
    ARTESANAL("Artesanal"),
    INDUSTRIAL("Industrial");

    private final String displayValue;

    private CervezaTipo_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
