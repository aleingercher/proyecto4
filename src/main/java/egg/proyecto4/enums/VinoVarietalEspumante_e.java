package egg.proyecto4.enums;

public enum VinoVarietalEspumante_e {

	   
	
	BRUT("Brut"),
	BRUT_NATURE("Brut Nature"),
	DULCE("Dulce"),
	EXTRA_BRUT("Extra Brut"),
	ROSE("Rose");
	
    private final String displayValue;

    private VinoVarietalEspumante_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
