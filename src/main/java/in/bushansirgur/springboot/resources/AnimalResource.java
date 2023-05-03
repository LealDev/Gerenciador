package in.bushansirgur.springboot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.bushansirgur.springboot.domain.Animal;
import in.bushansirgur.springboot.services.AnimalService;

@RestController
@RequestMapping(value = "/animais")
public class AnimalResource {
	
	@Autowired
	AnimalService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Animal obj = service.find(id);
			return ResponseEntity.ok().body(obj);
		
	}
	
	
	

}