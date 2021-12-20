package egg.proyecto4.enums;

public enum VinoVarietalBlanco_e {


	
	CHARDONNAY("Chardonnay"),
	SAUVIGNON_BLANC("Sauvignon blanc"),
        MOSCATEL("Moscatel"),
        CHENIN("Chenin"),
        TORRONTES("Torrontes");

    private final String displayValue;

    private VinoVarietalBlanco_e(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
