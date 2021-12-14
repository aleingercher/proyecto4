package egg.proyecto4.enums;

public enum EspirituosasMarca_e {
	
	ABSOLUT("Absolut"),
	GREY_GOOSE("Grey Goose"),
	FINLANDIA("Finlandia"),
	SMIRNOFF("Smirnoff"),
	BULLDOG("Bulldog"),
	BRANCA("branca"),
	BAILEYS("Baileys");

    private final String displayValue;

    private EspirituosasMarca_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
