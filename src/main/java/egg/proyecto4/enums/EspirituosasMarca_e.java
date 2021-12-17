package egg.proyecto4.enums;

public enum EspirituosasMarca_e {
	
	ABSOLUT("Absolut"),/**/
	//GREY_GOOSE("Grey Goose"),
	//FINLANDIA("Finlandia"),
//	SMIRNOFF("Smirnoff"),/**/
        
        BALLANTINES("Ballantines"),/**/
        CHIVAS("Chivas Regal"),/**/
        HAVANA("Havana"),/**/
        CAPITAN("Capitan Morgan"),/**/
        JACK("Jack Daniel"),/**/
	JAMESON("Jameson"),/**/
        JIM("Jim Beam"),/**/
        BULLDOG("Bulldog"),
	BRANCA("Branca"),/**/
        VITONE("Vitone"),/**/
        MIL_OCHO("1882"),/**/
        CINZANO("Cinzano"),/**/
        ANICA("Anica Fórmula"),
        ANIS("Anis Chinchon"),/**/
        AMARGO_OBRERO("Amargo Obrero"),/**/
        APEROL("Aperol"),/**/
        GANCIA("Gancia"),/**/
        JOHNNIE("Johnnie Walker"),
        HIERRO("Hierro Quina Pereti"),/**/
        LUNFA("Lunfa"),/**/
        MARTINI("Martini"),/**/
        PIMMS("Pimms"),/**/
        PINERAL("Pineral"),/**/
        RED("Red Label"),/**/
        SWING("Swing"),/**/
        BAT("Bat 69"),/**/
        PINA_COL("American Club"),/**/
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
