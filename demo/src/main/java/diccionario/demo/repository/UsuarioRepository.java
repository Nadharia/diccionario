package diccionario.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import diccionario.demo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByUsername(String username);

}
