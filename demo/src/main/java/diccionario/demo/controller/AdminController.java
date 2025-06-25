package diccionario.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import diccionario.demo.entity.Usuario;
import diccionario.demo.services.IUsuarioService;


@RestController
@RequestMapping()
@CrossOrigin
public class AdminController {

@Autowired
IUsuarioService iService;

@PreAuthorize("hasRole('ADMIN')")
@GetMapping("/obtenerusuarios")
public ResponseEntity<?> obtenerTodosLosUsuarios(){
    List<Usuario> listaUsuarios = iService.obtenerUsuarios();
    
    if (listaUsuarios.isEmpty())return ResponseEntity.noContent().build(); 

    return ResponseEntity.ok(listaUsuarios);
}

}
