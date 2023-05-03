package in.bushansirgur.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bushansirgur.springboot.domain.Raca;

@Repository
public interface IRacaRepo extends JpaRepository<Raca, Long> {

}