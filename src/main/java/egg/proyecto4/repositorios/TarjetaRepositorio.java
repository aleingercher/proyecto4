
package egg.proyecto4.repositorios;

import egg.proyecto4.entidades.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TarjetaRepositorio extends JpaRepository <Tarjeta ,String> {

}
