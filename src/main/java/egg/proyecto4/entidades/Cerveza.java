package egg.proyecto4.entidades;

import javax.persistence.Entity;

@Entity
public class Cerveza extends Producto {

    
    private String familia;//--

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    
}
