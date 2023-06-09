package in.bushansirgur.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.bushansirgur.springboot.domain.Animal;
import in.bushansirgur.springboot.dto.AnimalDTO;
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
	
	public Animal insert (Animal obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Animal update(Animal obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<Animal> findAll(){
		return repo.findAll();
	}
	
	public List<Animal> findByName(String name){
		return repo.buscarPorNome(name);
	}
	
	public Page<Animal> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	public Animal fromDTO(AnimalDTO objDto) {
		return new Animal(objDto.getId(),
				objDto.getDataNascimento(),
				objDto.getBrinco(),
				objDto.getNome(),
				objDto.getSexo(),
				objDto.getPai(),
				objDto.getMae(),
				objDto.getRaca(),
				objDto.getTipoAnimal());
	}
	
}
