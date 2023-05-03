package in.bushansirgur.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bushansirgur.springboot.domain.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

	Object save(Long id);

}