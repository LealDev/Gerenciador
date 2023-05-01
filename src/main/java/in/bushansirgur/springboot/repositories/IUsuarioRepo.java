package in.bushansirgur.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bushansirgur.springboot.entity.Usuario;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Long> {

}