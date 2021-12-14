package egg.proyecto4.enums;

public enum VinoBodega_e {

	
	ALTAVISTA("Lata"),
	ATAMISQUE("Atamisque"), 
	CATENA_ZAPATA("Catena Zapata"),
	EL_MALEANTE("El maleante"),
	HUARPES("Huarpes"), 
	NORTON("Norton"), 
	PIATTELLI("Piattelli"),
	RICCITELLI("Riccitelli");
	
    private final String displayValue;

    private VinoBodega_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
