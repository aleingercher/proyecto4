package egg.proyecto4.entidades;

import egg.proyecto4.enums.CervezaFamilia_e;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Cerveza extends Producto {

    @Enumerated(EnumType.STRING)
    private String familia;//crear paquete enums

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    
}
