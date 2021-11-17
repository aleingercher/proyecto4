package egg.proyecto4.entidades;

import egg.proyecto4.enums.VinoBodega_e;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Vino extends Producto {
    
    @Enumerated(EnumType.STRING)
    private String varietal;//debatir  atributo varietal
    @Enumerated(EnumType.STRING)
    private String bodega;

    // GETTERS / SETTERS

    public String getVarietal() {
        return varietal;
    }

    public void setVarietal(String varietal) {
        this.varietal = varietal;
    }

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }
    
}
