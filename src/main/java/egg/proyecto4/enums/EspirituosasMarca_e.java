package egg.proyecto4.enums;

public enum EspirituosasMarca_e {
	
	ABSOLUT("Absolut"),
	GREY_GOOSE("Grey Goose"),
	FINLANDIA("Finlandia"),
	SMIRNOFF("Smirnoff"),
	BULLDOG("Bulldog"),
	BRANCA("Branca"),
        VITONE("Vitone"),
        MIL_OCHO("1882"),
        CINZANO("Cinzano"),
        AMARGO_OBRERO("Amargo Obrero"),
        APEROL("Aperol"),
        GANCIA("Gancia"),
        MARCELA("Marcela"),
        CAMPARI("Campari"),
        CYNAR("Cynar"),
        RAMAZZOTTI("Ramazzotti"),
	BAILEYS("Baileys");
        

    private final String displayValue;

    private EspirituosasMarca_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
