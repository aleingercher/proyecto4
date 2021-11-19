package egg.proyecto4.repositorios;

import egg.proyecto4.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepositorio extends JpaRepository <Producto ,String> {

 @Query("SELECT c FROM Producto c WHERE c.categoria= :categoria")
public Producto findByCategoria(@Param("categoria") String categoria);
//en productoRepositorio, hacete una query por categoria 
}
