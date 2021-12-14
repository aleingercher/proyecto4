package egg.proyecto4.enums;

public enum VinoVarietalRosado_e {

	
	BRUT("Brut"),
	BRUT_NATURE("Burt Nature"),
	DULCE("Dulce"),
	EXTRA_BRUT("Extra brut"),
	ROSE("Rose");
	
    private final String displayValue;

    private VinoVarietalRosado_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
