package egg.proyecto4.enums;

public enum EspirituosasEnvase_e {
	
	LITRO("Litro"), 
	BOTELLA_750ML("Botella 750"),
	LATA_269ml("Lata 269"),
	LATA_473ml("Lata 473");

    private final String displayValue;

    private EspirituosasEnvase_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
