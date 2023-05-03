package in.bushansirgur.springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bushansirgur.springboot.domain.Vacina;
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
			
}
