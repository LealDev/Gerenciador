package in.bushansirgur.springboot.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "vacina")
@Setter
@Getter
@ToString
public class Vacina implements Serializable {
	private static final long serialVersionUID = 1L;

	String pattern;
	SimpleDateFormat sdf = new SimpleDateFormat(pattern = "MM-dd-yyyy");

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String vacina;
	private String date;

	@ManyToOne()
	@JoinColumn(name = "animal_id", nullable = true)
	private Animal animal;

	public Vacina() {
	}

	public Vacina(String date, Integer id, String vacina, Animal animal) {
		super();
		this.date = sdf.format(date);
		this.id = id;
		this.vacina = vacina;
		this.animal = animal;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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