package egg.proyecto4.enums;

public enum VinoMarca_e {

    
    ALMA_MORA("Alma Mora"),/**/
    ALTOS_DEL_PLATA("Altos del Plata"),/**/
    CABALLERO("Caballero"),/**/
    CAFAYATE("Cafayate"),/**/
    CINCO_SENTIDOS("Cinco Sentidos"),/**/
    DESIERTO_25("Desierto 25"),/**/
    ESCORIHUELA_GASCON("Escorihuela"),/**/
    FINCA_FLICHMAN("Finca Flichman"),/**/
    LUIGI_BOSCA("Luigi Bosca"),/**/
    TRAPICHE("Trapiche"),/**/
    TRAS_LA_PIEDRA("Tras la Piedra"),/**/
    ZUCCARDI("Zuccardi"),/**/
    SANTA_JULIA("Santa Julia");/**/

    private final String displayValue;

    private VinoMarca_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
