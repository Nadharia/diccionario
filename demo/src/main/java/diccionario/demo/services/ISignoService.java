package diccionario.demo.services;

import java.util.List;
import java.util.Optional;

import diccionario.demo.dto.SignoDTO;
import diccionario.demo.entity.Signo;

public interface ISignoService {
   
    Optional<Signo> buscarPorId(Long id);
    String  guardar(SignoDTO dto);
    List<Signo> buscarPorQuery(String query);
}
