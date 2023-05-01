package in.bushansirgur.springboot.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import in.bushansirgur.springboot.enumerators.TipoAnimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "animal")
@Setter
@Getter
@ToString
public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;

	String pattern;
	SimpleDateFormat sdf = new SimpleDateFormat(pattern = "MM-dd-yyyy");

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Nullable
	private String dataNascimento;
	@Nullable
	private String brinco;
	@Nullable
	private String nome;
	@Nullable
	private Character sexo;
	@Nullable
	private Animal pai;
	@Nullable
	private Animal mae;

	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "raca_id")
	 @Nullable
	 private Raca raca;

	@Enumerated(value = EnumType.STRING)
	@Nullable
	private TipoAnimal tipoAnimal;

	@OneToMany(mappedBy = "animal")
	@Nullable
	List<Vacina> vacina = new ArrayList<>();

	public Animal() {
		super();
	}

	public Animal(Long id, String dataNascimento, String brinco, String nome, Character sexo, Animal pai, Animal mae,
			Raca raca, TipoAnimal tipoAnimal, List<Vacina> vacina) {
		super();
		this.id = id;
		this.dataNascimento = dataNascimento;
		this.brinco = brinco;
		this.nome = nome;
		this.sexo = sexo;
		this.pai = pai;
		this.mae = mae;
		this.raca = raca;
		this.tipoAnimal = tipoAnimal;
		this.vacina = vacina;
	}

	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public Animal getPai() {
		return pai;
	}

	public void setPai(Animal pai) {
		this.pai = pai;
	}

	public Animal getMae() {
		return mae;
	}

	public void setMae(Animal mae) {
		this.mae = mae;
	}

	public String getDate() {
		return dataNascimento;
	}

	public void setDate(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@JsonIgnore
	public List<Vacina> getVacina() {
		return vacina;
	}

	public void setVacina(List<Vacina> vacina) {
		this.vacina = vacina;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrinco() {
		return brinco;
	}

	public void setBrinco(String brinco) {
		this.brinco = brinco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
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
		Animal other = (Animal) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", brinco=" + brinco + ", nome=" + nome + ", sexo=" + sexo + ", createdAt=" + "]";
	}

}