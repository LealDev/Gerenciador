package in.bushansirgur.springboot.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "raca")

public class Raca implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Nullable
	private String raca;
	
	@OneToOne(cascade = { CascadeType.DETACH})
	@JoinColumn(name = "animal_id")
	private Animal animal;

	public Raca() {
		super();
	}
	
	public Raca(Long id, String raca) {
		super();
		this.id = id;
		this.raca = raca;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
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
		Raca other = (Raca) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Raca [id=" + id + ", raca=" + raca + "]";
	}

}