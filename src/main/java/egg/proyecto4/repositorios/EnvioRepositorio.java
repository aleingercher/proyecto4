
package egg.proyecto4.repositorios;

import egg.proyecto4.entidades.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvioRepositorio extends JpaRepository <Envio ,String> {

}
