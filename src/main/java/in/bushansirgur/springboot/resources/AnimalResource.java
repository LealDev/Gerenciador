package in.bushansirgur.springboot.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import in.bushansirgur.springboot.domain.Animal;
import in.bushansirgur.springboot.dto.AnimalDTO;
import in.bushansirgur.springboot.services.AnimalService;

@RestController
@RequestMapping(value = "/animais")
public class AnimalResource {
	
	@Autowired
	AnimalService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Animal> find(@PathVariable Integer id){
		Animal obj = service.find(id);
			return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Animal obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method =  RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Animal obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AnimalDTO>> findAll(){
		List<Animal> list = service.findAll();
		List<AnimalDTO> listDTO = list.stream().map(obj -> new AnimalDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDTO);
	}
	
}