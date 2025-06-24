package diccionario.demo.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diccionario.demo.dto.SignoDTO;
import diccionario.demo.entity.Signo;
import diccionario.demo.repository.SignoRepository;

@Service
public class SignoService implements ISignoService {

    @Autowired
    private SignoRepository repository;

    @Override
    public List<Signo> buscar(String letra, String query) {
        if (letra != null) return repository.findByLetra(letra.toUpperCase());
        if (query != null) return repository.findByPalabraContainingIgnoreCase(query);
        return repository.findAll();
    }

    @Override
    public Optional<Signo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public String guardar(SignoDTO s) {
        mapearDesdeDTO(s);    
        return "Guardado con éxito";
    }


    private void mapearDesdeDTO(SignoDTO dto) {
        Signo s = new Signo();
        s.setPalabra(dto.getPalabra());
        s.setDefinicion(dto.getDefinicion());
        s.setCategoria(dto.getCategoria());
        s.setLetra(dto.getLetra());
        s.setVideoUrl(dto.getVideoUrl());
        s.setFechaAlta(LocalDateTime.now());
        repository.save(s);
    }
}