package egg.proyecto4.entidades;

import egg.proyecto4.enums.Categoria_e;
import egg.proyecto4.enums.Origen_e;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Producto implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Enumerated(EnumType.STRING)
    private Categoria_e categoria;
    @Enumerated(EnumType.STRING)
    private Marca marca;//crear paquete enum
    private String otrasMarcas;
    private Float precio;
    private Integer stock;
    private Integer vendidos;
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private Envase envase;//crear paquete enum
    @Enumerated(EnumType.STRING)
    private Tipo tipo;//crear paquete enum
    @OneToOne
    private Foto foto;
    @Enumerated(EnumType.STRING)
    private Origen_e origen;

    // GETTERS / SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Categoria_e getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria_e categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getOtrasMarcas() {
        return otrasMarcas;
    }

    public void setOtrasMarcas(String otrasMarcas) {
        this.otrasMarcas = otrasMarcas;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getVendidos() {
        return vendidos;
    }

    public void setVendidos(Integer vendidos) {
        this.vendidos = vendidos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Envase getEnvase() {
        return envase;
    }

    public void setEnvase(Envase envase) {
        this.envase = envase;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public Origen_e getOrigen() {
        return origen;
    }

    public void setOrigen(Origen_e origen) {
        this.origen = origen;
    }

}
