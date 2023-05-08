package in.bushansirgur.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.bushansirgur.springboot.domain.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

	@Query(value = "select a from Animal a where a.nome like %?1%")
	List<Animal> buscarPorNome(String nome);
	
}