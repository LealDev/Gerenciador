package in.bushansirgur.springboot.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.bushansirgur.springboot.entity.Animal;
import in.bushansirgur.springboot.repositories.IAnimalRepo;

@RestController
public class AnimalController {

	@Autowired
	IAnimalRepo animalRepo;
	
	@PostMapping("/animal")
	public ResponseEntity<Animal> save(@RequestBody Animal animal) {
		try {
			return new ResponseEntity<>(animalRepo.save(animal), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/animal")
	public ResponseEntity<List<Animal>> getAllAnimals() {
		try {
			List<Animal> list = animalRepo.findAll();
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Animal>>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Animal>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/animal/{id}")
	public ResponseEntity<Animal> getSingleAnimal(@PathVariable Long id) {
		Optional<Animal> animal = animalRepo.findById(id);
		
		if (animal.isPresent()) {
			return new ResponseEntity<Animal>(animal.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/animal/{id}")
	public ResponseEntity<Animal> updateAnimal(@RequestBody Animal animal) {
		
		try {
			return new ResponseEntity<Animal>(animalRepo.save(animal), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/animal/{id}")
	public ResponseEntity<HttpStatus> deleteAnimal(@PathVariable Long id) {
		try {
			Optional<Animal> animal = animalRepo.findById(id);
			if (animal.isPresent()) {
				animalRepo.delete(animal.get());
			}
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}