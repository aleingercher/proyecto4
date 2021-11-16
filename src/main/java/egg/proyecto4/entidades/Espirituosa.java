package egg.proyecto4.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Espirituosa implements Serializable{
    //ATRIBUTO AGREGADO NACIONAL-IMPORTADO A CONSULTAR CON EL GRUPO
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Enumerated(EnumType.STRING)
    private Nacional nacional;//crear paquete enum
    @Enumerated(EnumType.STRING)
    private Importado importado;//crear paquete enum        

    // GETTERS / SETTERS

    public Nacional getNacional() {
        return nacional;
    }

    public void setNacional(Nacional nacional) {
        this.nacional = nacional;
    }

    public Importado getImportado() {
        return importado;
    }

    public void setImportado(Importado importado) {
        this.importado = importado;
    }
    
    
}
