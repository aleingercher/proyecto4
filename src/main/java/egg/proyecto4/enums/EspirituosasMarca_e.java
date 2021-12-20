package egg.proyecto4.enums;

public enum EspirituosasMarca_e {
	
	ABSOLUT("Absolut"),/**/
	//GREY_GOOSE("Grey Goose"),
	//FINLANDIA("Finlandia"),
//	SMIRNOFF("Smirnoff"),/**/
        
        BALLANTINES("Ballantines"),/**/
        CHIVAS_REGAL("Chivas Regal"),/**/
        HAVANA("Havana"),/**/
        CAPITAN_MORGAN("Capitan Morgan"),/**/
        JACK_DANIELS("Jack Daniels"),/**/
	JAMESON("Jameson"),/**/
        JIM("Jim Beam"),/**/
        BULLDOG("Bulldog"),
	BRANCA("Branca"),/**/
        VITONE("Vitone"),/**/
        MIL_OCHO("1882"),/**/
        CINZANO("Cinzano"),/**/
        ANICA_FORMULA("Anica Fórmula"),
        ANIS_CHINCHON("Anis Chinchon"),/**/
        AMARGO_OBRERO("Amargo Obrero"),/**/
        APEROL("Aperol"),/**/
        GANCIA("Gancia"),/**/
        JOHNNY_WALKER("Johnnie Walker"),
        HIERRO_QUINA_PERETI("Hierro Quina Pereti"),/**/
        LUNFA("Lunfa"),/**/
        MARTINI("Martini"),/**/
        PIMMS("Pimms"),/**/
        PINERAL("Pineral"),/**/
        RED_LABEL("Red Label"),/**/
        SWING("Swing"),/**/
        BAT("Bat 69"),/**/
        AMERICAN_CLUB("American Club"),/**/
        PUNT("Punt"),/**/
        RICARD("Ricard"),/**/
        FUERZA("La Fuerza"),/**/
        CARPANO("Carpano"),/**/
        MARCELA("Marcela"),
        CAMPARI("Campari"),/**/
        CYNAR("Cynar"),
        WYBOROWA("Wyborowa");/**/
        

    private final String displayValue;

    private EspirituosasMarca_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
