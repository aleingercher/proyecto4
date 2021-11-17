package egg.proyecto4.entidades;

import egg.proyecto4.enums.CervezaFamilia_e;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Cerveza extends Producto {

    @Enumerated(EnumType.STRING)
    private CervezaFamilia_e familia;//crear paquete enum 

    public CervezaFamilia_e getFamilia() {
        return familia;
    }

    public void setFamilia(CervezaFamilia_e familia) {
        this.familia = familia;
    }

}
