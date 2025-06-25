package diccionario.demo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import diccionario.demo.entity.Usuario;
import diccionario.demo.repository.UsuarioRepository;
@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> obtenerUsuarios() {
       List<Usuario> usuarios=usuarioRepository.findAll();
       return usuarios;
        
      
    }

}
