package diccionario.demo.services;

import java.util.List;
import java.util.Optional;

import diccionario.demo.dto.SignoDTO;
import diccionario.demo.entity.Signo;

public interface ISignoService {
    List<Signo> buscar(String letra,String query);
    Optional<Signo> buscarPorId(Long id);
    String  guardar(SignoDTO dto);
}
