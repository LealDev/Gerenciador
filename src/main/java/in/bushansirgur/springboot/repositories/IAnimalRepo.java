package in.bushansirgur.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bushansirgur.springboot.domain.Animal;

@Repository
public interface IAnimalRepo extends JpaRepository<Animal, Long> {

	Object save(Long id);

}