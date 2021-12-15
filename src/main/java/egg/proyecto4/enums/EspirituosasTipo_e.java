package egg.proyecto4.enums;

public enum EspirituosasTipo_e {

	VODKA("Vodka"),
	RON("Ron"),
	WHISKY("Whysky"),
	BOURBON("Bourbon"),
	TEQUILA("Tequila"),
        MEZCAL("Mezcal"),
	GIN("Gin"),
	FERNET("Fernet"),
	APERITIVO("Aperitivo"),
        VERMUT("Vermut");
	
    private final String displayValue;

    private EspirituosasTipo_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
