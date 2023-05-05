package in.bushansirgur.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.bushansirgur.springboot.domain.Vacina;
import in.bushansirgur.springboot.dto.VacinaDTO;
import in.bushansirgur.springboot.repositories.VacinaRepository;
import in.bushansirgur.springboot.services.exceptions.ObjectNotFoundException;

@Service
public class VacinaService {
	
	@Autowired
	private VacinaRepository repo;

	public Vacina find(Integer id) {
		Optional<Vacina> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!" + id + ", Tipo " + Vacina.class.getName()));
	}
	
	public Vacina insert (Vacina obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Vacina update(Vacina obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<Vacina> findAll(){
		return repo.findAll();
	}
	
	public Page<Vacina> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Vacina fromDTO(VacinaDTO objDto) {
		
		return new Vacina(objDto.getId(),objDto.getDataAplicacao(),objDto.getVacina(),objDto.getAnimal());
	}
	
}
