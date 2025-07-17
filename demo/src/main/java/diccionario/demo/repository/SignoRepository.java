package diccionario.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import diccionario.demo.entity.Signo;




public interface SignoRepository extends JpaRepository<Signo,Long>{

    List<Signo> findByPalabraContainingIgnoreCase(String query);

}
