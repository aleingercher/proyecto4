package egg.proyecto4.entidades;

import egg.proyecto4.enums.VinoBodega_e;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Vino extends Producto {
    
    @Enumerated(EnumType.STRING)
    private Varietal varietal;//debatir  atributo varietal
    @Enumerated(EnumType.STRING)
    private VinoBodega_e bodega;

    // GETTERS / SETTERS
    public Varietal getVarietal() {
        return varietal;
    }

    public void setVarietal(Varietal varietal) {
        this.varietal = varietal;
    }

    public VinoBodega_e getBodega() {
        return bodega;
    }

    public void setBodega(VinoBodega_e bodega) {
        this.bodega = bodega;
    }

}
