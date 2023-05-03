package in.bushansirgur.springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bushansirgur.springboot.domain.Animal;
import in.bushansirgur.springboot.repositories.AnimalRepository;
import in.bushansirgur.springboot.services.exceptions.ObjectNotFoundException;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository repo;

	public Animal find(Integer id) {
		Optional<Animal> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!" + id + ", Tipo " + Animal.class.getName()));
	}
			
}
