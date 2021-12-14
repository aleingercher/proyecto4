package egg.proyecto4.enums;

public enum Origen_e {

	
	NACIONAL("Nacional"),
	IMPORTADO("Importado");
	
    private final String displayValue;

    private Origen_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
