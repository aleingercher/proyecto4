package egg.proyecto4.entidades;

import javax.persistence.Entity;

@Entity
public class Vino extends Producto {
    

    private String bodega;//--

    // GETTERS / SETTERS

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }
    
}
