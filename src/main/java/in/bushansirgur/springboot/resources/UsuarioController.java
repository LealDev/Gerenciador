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

import in.bushansirgur.springboot.entity.Usuario;
import in.bushansirgur.springboot.repositories.IUsuarioRepo;

@RestController
public class UsuarioController {

	@Autowired
	IUsuarioRepo usuarioRepo;
	
	@PostMapping("/usuario")
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
		try {
			return new ResponseEntity<>(usuarioRepo.save(usuario), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/usuario")
	public ResponseEntity<List<Usuario>> getAllusuario() {
		try {
			List<Usuario> list = usuarioRepo.findAll();
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getSingleUsuario(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepo.findById(id);
		
		if (usuario.isPresent()) {
			return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
		
		try {
			return new ResponseEntity<Usuario>(usuarioRepo.save(usuario), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<HttpStatus> deleteUsuario(@PathVariable Long id) {
		try {
			Optional<Usuario> usuario = usuarioRepo.findById(id);
			if (usuario.isPresent()) {
				usuarioRepo.delete(usuario.get());
			}
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}