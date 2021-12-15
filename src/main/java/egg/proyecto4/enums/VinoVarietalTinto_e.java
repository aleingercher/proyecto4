package egg.proyecto4.enums;

public enum VinoVarietalTinto_e {

	 
	
	MALBEC("Malbec"),
	CABERNET("Cabernet"),
	BONARDA("Bonarda"),
	MERLOT("Merlot"),
	PINOT_NOIR("Pinot Noir"),
        SYRAH("Syrah"),
        TEMPRANILLO("Tempranillo"),
        BLEND("Blend"),
	CARMENERE("Carmenere");
	
    private final String displayValue;

    private VinoVarietalTinto_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
