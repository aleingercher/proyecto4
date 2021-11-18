
package egg.proyecto4.repositorios;

import egg.proyecto4.entidades.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepositorio extends JpaRepository <Foto ,String> {

}
