package egg.proyecto4.enums;

public enum VinoMarca_e {
	
    SANTA_JULIA("Santa Julia"),
    ALMA_MORA("Alma Mora"),
	TRAPICHE("Trapiche"),
	TRUMPETER("Trumpeter"),
	VIÑASdeBALBO("Viñas de Balbo"),
	RUTINI("Rutini"),
	LUIGI_BOSCA("Luigi Bosca"),
	DADA("Dada"),
	NORTON("Norton"),
	LAS_PERDICES("Las Perdices");
	
    private final String displayValue;

    private VinoMarca_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
