package egg.proyecto4.servicios;

import egg.proyecto4.repositorios.CompraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServicio {
    
    @Autowired
    private CompraRepositorio compraRepo;

}
