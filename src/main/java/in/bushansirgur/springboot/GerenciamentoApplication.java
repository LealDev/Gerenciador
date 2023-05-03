package in.bushansirgur.springboot;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.bushansirgur.springboot.domain.Animal;
import in.bushansirgur.springboot.domain.Vacina;
import in.bushansirgur.springboot.domain.enums.TipoAnimal;
import in.bushansirgur.springboot.repositories.AnimalRepository;
import in.bushansirgur.springboot.repositories.VacinaRepository;

@SpringBootApplication
public class GerenciamentoApplication implements CommandLineRunner {
		
		@Autowired
		private VacinaRepository vacinaRepository;
		@Autowired
		private AnimalRepository animalRepo;
	
		public static void main(String[] args) {
		SpringApplication.run(GerenciamentoApplication.class, args);
}
		
	public void run(String... args) throws Exception{
		
//(Integer id, String dataNascimento, String brinco, String nome, Character sexo, Animal pai, Animal mae,
//String raca, TipoAnimal tipoAnimal)
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Animal animal1 = new Animal(null, sdf.parse("01/11/1986 10:32"),"Gegex15","general",'M',"General","mimosa","karacu",TipoAnimal.BOVINO);
		Animal animal2 = new Animal(null, sdf.parse("01/11/1976 10:32"),"Gegex15","general",'M',"cavalo","karina","karacu",TipoAnimal.BOVINO);
		
		Vacina vac1 = new Vacina(null, sdf.parse("01/11/1986 10:32"), "astrazeneca", new Animal(2, "General"));
		Vacina vac2 = new Vacina(null, sdf.parse("01/11/1986 10:32"), "astrazeneca", new Animal(3, "Mimosa"));
		
		animal1.getVacina().addAll(Arrays.asList(vac1,vac2));
		animal2.getVacina().addAll(Arrays.asList(vac2,vac1));
		
		
		vacinaRepository.saveAll(Arrays.asList(vac1,vac2));
		animalRepo.saveAll(Arrays.asList(animal1,animal2));
		
	}	
}
