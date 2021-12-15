package egg.proyecto4.enums;

public enum VinoMarca_e {

    SANTA_JULIA("Santa Julia"),
    ALMA_MORA("Alma Mora"),
    TRAPICHE("Trapiche"),
    TRUMPETER("Trumpeter"),
    VINAS_BALBO("Viñas de Balbo"),
    RUTINI("Rutini"),
    LUIGI_BOSCA("Luigi Bosca"),
    DADA("Dada"),
    LA_IRIDE("La Iride"),
    MALAMADO("Malamado"),
    NORTON("Norton"),
    ESTANCIA_MENDOZA("Estancia Mendoza"),
    DONA_PAULA("Doña Paula"),
    NIETO("Nieto Senetiner"),
    EMILIA("Emilia"),
    LATITUD("Latitud 33"),
    LAS_PERDICES("Las Perdices");

    private final String displayValue;

    private VinoMarca_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
