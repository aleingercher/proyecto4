
package egg.proyecto4.repositorios;

import egg.proyecto4.entidades.Vino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VinoRepositorio extends JpaRepository <Vino ,String> {

}
