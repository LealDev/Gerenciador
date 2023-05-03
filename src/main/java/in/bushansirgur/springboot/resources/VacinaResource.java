package in.bushansirgur.springboot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.bushansirgur.springboot.domain.Vacina;
import in.bushansirgur.springboot.services.VacinaService;

@RestController
@RequestMapping(value = "/vacinas")
public class VacinaResource {
	
	@Autowired
	VacinaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Vacina obj = service.find(id);
			return ResponseEntity.ok().body(obj);
		
	}
	
	
	

}
