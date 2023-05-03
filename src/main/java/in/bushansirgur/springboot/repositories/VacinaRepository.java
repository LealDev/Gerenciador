package in.bushansirgur.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bushansirgur.springboot.domain.Vacina;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Integer> {

}
