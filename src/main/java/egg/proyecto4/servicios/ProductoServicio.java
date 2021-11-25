package egg.proyecto4.servicios;

import egg.proyecto4.entidades.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductoServicio {

    @Autowired
    private CervezaServicio serviCerveza;
    @Autowired
    private VinoServicio serviVino;
    @Autowired
    private EspirituosaServicio serviEspirituosa;

    public List<Producto> findAllProductos() {

        List<Producto> allProducts = null;

        allProducts.add((Producto) serviCerveza.consultarCervezas());
        allProducts.add((Producto) serviVino.consultarVinos());
        allProducts.add((Producto) serviEspirituosa.consultarEspirituosas());

        return allProducts;

    }

}
