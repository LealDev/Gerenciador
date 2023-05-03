package in.bushansirgur.springboot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.bushansirgur.springboot.domain.Animal;
import in.bushansirgur.springboot.domain.Vacina;
import in.bushansirgur.springboot.repositories.IAnimalRepo;
import in.bushansirgur.springboot.repositories.VacinaRepository;

@SpringBootApplication
public class GerenciamentoApplication implements CommandLineRunner {
		
		@Autowired
		private VacinaRepository vacinaRepository;
		@Autowired
		private IAnimalRepo animalRepo;
	
		public static void main(String[] args) {
		SpringApplication.run(GerenciamentoApplication.class, args);
}
		
	public void run(String... args) throws Exception{
		

		
		Animal animal1 = new Animal(null, "01/11/1986","Gegex15","general",'M',"sargento","mimosa","karacu","Bovino");
		Animal animal2 = new Animal(null, "01/11/1976","Gegex19","varsalo",'M',"hurgot","carlota","karacu","Bovino");

		Vacina vac1 = new Vacina(null, "01/11/1996", "astrazeneca", null);
		Vacina vac2 = new Vacina(null, "01/11/1997", "astrazeneca", new Animal(1,"General"));
		
		animal1.getVacina().addAll(Arrays.asList(vac1,vac2));
		animal2.getVacina().addAll(Arrays.asList(vac2,vac1));
		
		
		vacinaRepository.saveAll(Arrays.asList(vac1,vac2));
		animalRepo.saveAll(Arrays.asList(animal1,animal2));
		
	}	
}
