package egg.proyecto4.enums;

public enum VinoBodega_e {

	
	ALTAVISTA("Altavista"),
	ATAMISQUE("Atamisque"), 
	CATENA_ZAPATA("Catena Zapata"),
	EL_MALEANTE("El maleante"),
	HUARPES("Huarpes"), 
	NORTON("Norton"), 
	PIATTELLI("Piattelli"),
        BIANCHI("Bianchi"),
        ZUCCARDI("Zuccardi"),
        RUCA_MALEN("Ruca Malen"),
        TIERRAS_ALTAS("Tierras Altas"),
        ESCORIHUELA("Escorihuela"),
        ESTANCIA_MENDOZA("Estancia Mendoza"),
	RICCITELLI("Riccitelli");
	
    private final String displayValue;

    private VinoBodega_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
