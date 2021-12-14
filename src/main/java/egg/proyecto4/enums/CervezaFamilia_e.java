package egg.proyecto4.enums;

public enum CervezaFamilia_e {

    RUBIA("Rubia"),
    ROJA("Roja"),
    NEGRA("Negra"),
    STOUT("Stout"),
    APA("APA"),
    IPA("IPA"),
    HONEY("Honey");

    private final String displayValue;

    private CervezaFamilia_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}

