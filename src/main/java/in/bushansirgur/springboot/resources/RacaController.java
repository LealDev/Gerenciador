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

import in.bushansirgur.springboot.entity.Raca;
import in.bushansirgur.springboot.repositories.IRacaRepo;

@RestController
public class RacaController {

	@Autowired
	IRacaRepo racaRepo;
	
	@PostMapping("/raca")
	public ResponseEntity<Raca> save(@RequestBody Raca Raca) {
		try {
			return new ResponseEntity<>(racaRepo.save(Raca), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/raca")
	public ResponseEntity<List<Raca>> getAllRaca() {
		try {
			List<Raca> list = racaRepo.findAll();
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Raca>>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Raca>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/raca/{id}")
	public ResponseEntity<Raca> getSingleRaca(@PathVariable Long id) {
		Optional<Raca> Raca = racaRepo.findById(id);
		
		if (Raca.isPresent()) {
			return new ResponseEntity<Raca>(Raca.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Raca>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/raca/{id}")
	public ResponseEntity<Raca> updateRaca(@RequestBody Raca Raca) {
		
		try {
			return new ResponseEntity<Raca>(racaRepo.save(Raca), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/raca/{id}")
	public ResponseEntity<HttpStatus> deleteRaca(@PathVariable Long id) {
		try {
			Optional<Raca> Raca = racaRepo.findById(id);
			if (Raca.isPresent()) {
				racaRepo.delete(Raca.get());
			}
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}