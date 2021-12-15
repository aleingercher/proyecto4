package egg.proyecto4.enums;

public enum VinoEnvase_e {

	
	LITRO("Litro"),
	BOTELLA_750ml("Botella 750ml"),
        BOTELLA_375ml("Botella 375ml"),
        BOX("Bag in Box"),
        DAMAJUANA("Damajuana"),
	LATA("Lata");
	
    private final String displayValue;

    private VinoEnvase_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
