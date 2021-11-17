package egg.proyecto4.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Foto implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    private String tipoFoto;
    private String nombre;
    private byte contenido;

    // GETTERS / SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoFoto() {
        return tipoFoto;
    }

    public void setTipoFoto(String tipoFoto) {
        this.tipoFoto = tipoFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getContenido() {
        return contenido;
    }

    public void setContenido(byte contenido) {
        this.contenido = contenido;
    }

}
