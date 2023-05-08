package in.bushansirgur.springboot.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vacina")

public class Vacina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String vacina;
	
	private Date dataAplicacao;

	
	@ManyToOne
	@JoinColumn(name = "animal_id", nullable = true)
	private Animal animal;

	public Vacina() {
	}

	public Vacina(Integer id, Date dataAplicacao, String vacina, Animal animal) {
		this.id = id;
		this.dataAplicacao = dataAplicacao;
		this.vacina = vacina;
		this.animal = animal;
	}


	public Date getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDate(Date date) {
		this.dataAplicacao = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@JsonIgnore
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public String getVacina() {
		return vacina;
	}

	public void setVacina(String vacina) {
		this.vacina = vacina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacina other = (Vacina) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", vacina=" + vacina + ", age=" + "]";
	}

}