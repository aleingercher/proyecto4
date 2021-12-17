package egg.proyecto4.enums;

public enum VinoMarca_e {

    
    ALMA_MORA("Alma Mora"),/**/
    ALTOS("Altos del Plata"),/**/
    CABALLERO("Caballero"),/**/
    CAFAYATE("Cafayate"),/**/
    CINCO("Cinco Sentidos"),/**/
    DESIERTO("Desierto 25"),/**/
    ESCORIHUELA("Escorihuela"),/**/
    FINCA("Finca Flichman"),/**/
    LUIGI_BOSCA("Luigi Bosca"),/**/
    TRAPICHE("Trapiche"),/**/
    TRASLA("Tras la Piedra"),/**/
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
