package egg.proyecto4.enums;

public enum VinoMarca_e {
//	, , TRAPICHE, TRUMPETER, VIÑASdeBALBO, RUTINI, LUIGI_BOSCA, DADÁ, NORTON, LAS_PERDICES;
    SANTA_JULIA("Santa Julia"),
    ALMA_MORA("Alma Mora");

    private final String displayValue;

    private VinoMarca_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
