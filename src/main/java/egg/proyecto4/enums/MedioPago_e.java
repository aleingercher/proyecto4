package egg.proyecto4.enums;

public enum MedioPago_e {

    EFECTIVO("Efectivo"),
    TARJETA("Tarjeta");

    private final String displayValue;

    private MedioPago_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
