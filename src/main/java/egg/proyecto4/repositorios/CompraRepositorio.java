package egg.proyecto4.repositorios;

import egg.proyecto4.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepositorio extends JpaRepository <Compra ,String>  {

}
