
package egg.proyecto4.repositorios;

import egg.proyecto4.entidades.Cerveza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CervezaRepositorio extends JpaRepository <Cerveza ,String> {

}
