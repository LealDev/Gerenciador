package in.bushansirgur.springboot.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import in.bushansirgur.springboot.domain.Vacina;
import in.bushansirgur.springboot.dto.VacinaDTO;
import in.bushansirgur.springboot.services.VacinaService;

@RestController
@RequestMapping(value = "/vacinas")
public class VacinaResource {
	
	@Autowired
	VacinaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vacina> find(@PathVariable Integer id){
		Vacina obj = service.find(id);
			return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody VacinaDTO objDto){
		Vacina obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method =  RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody VacinaDTO objDto, @PathVariable Integer id){
		Vacina obj = service.fromDTO(objDto);
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
	public ResponseEntity<List<VacinaDTO>> findAll(){
		List<Vacina> list = service.findAll();
		List<VacinaDTO> listDTO = list.stream().map(obj -> new VacinaDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<VacinaDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Vacina> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<VacinaDTO> listDto = list.map(obj -> new VacinaDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
	
	

}
