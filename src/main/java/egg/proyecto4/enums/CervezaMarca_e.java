package egg.proyecto4.enums;

public enum CervezaMarca_e {

    AMSTEL("Amstel"),
    ANDES("Andes"),
    BRAHMA("Brahma"),
    CORONA("Corona"),
    HEINEKEN("Heineken"),
    IMPERIAL("Imperial"),
    QUILMES("Quilmes"),
    PATAGONIA("Patagonia"),
    SCHNEIDER("Schneider"),
    SALTA("Salta"),
    STELLA("Stella Artois");

    private final String displayValue;

    private CervezaMarca_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}

