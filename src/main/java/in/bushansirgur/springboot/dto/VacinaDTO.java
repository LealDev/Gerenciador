package in.bushansirgur.springboot.dto;

import java.util.Date;

import in.bushansirgur.springboot.domain.Animal;
import in.bushansirgur.springboot.domain.Vacina;

public class VacinaDTO {

	private Integer id;
	private String vacina;
	private Date dataAplicacao;
	private Animal animal;

	public VacinaDTO() {
	}

	public VacinaDTO(Vacina obj) {
		super();
		this.id = obj.getId();
		this.vacina = obj.getVacina();
		this.dataAplicacao = obj.getDataAplicacao();
		this.animal = obj.getAnimal();
	}

	public Integer getId() {
		return id;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVacina() {
		return vacina;
	}

	public void setVacina(String vacina) {
		this.vacina = vacina;
	}

	public Date getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(Date dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

}
