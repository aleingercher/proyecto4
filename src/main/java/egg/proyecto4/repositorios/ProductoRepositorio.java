package egg.proyecto4.repositorios;

import egg.proyecto4.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepositorio extends JpaRepository <Producto ,String> {

    // CONSTRUCTORES

    // GETTERS / SETTERS
}
