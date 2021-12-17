package egg.proyecto4.enums;

public enum CervezaEnvase_e {

    //LITRO("Litro"),
    LATA("Lata"),
   // CAJON("Cajón de Birra"),
    PORRON("Porrón"),
    PACKx6("Six-Pack de latas");

    private final String displayValue;

    private CervezaEnvase_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
