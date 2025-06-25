package diccionario.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import diccionario.demo.dto.SignoDTO;
import diccionario.demo.entity.Signo;
import diccionario.demo.services.ISignoService;

@RestController
@CrossOrigin
@RequestMapping("/api/signos")
public class SignoController {

    @Autowired
    private ISignoService service;

    @GetMapping
    public List<Signo> buscar(@RequestParam(required = false) String letra,@RequestParam(required = false) String query) {
        return service.buscar(letra, query);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Signo> obtener(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> guardar(@RequestBody SignoDTO dto) {
        return ResponseEntity.ok(service.guardar(dto));
    }
}  
