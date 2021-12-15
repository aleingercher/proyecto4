package egg.proyecto4.enums;

public enum Categoria_e {

    VINO("Vino"),
    CERVEZA("Cerveza"),
    ESPIRITUOSAS("Bebida Espirituosa");

    private final String displayValue;

    private Categoria_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
