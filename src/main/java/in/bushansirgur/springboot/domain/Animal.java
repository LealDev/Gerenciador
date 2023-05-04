package in.bushansirgur.springboot.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import in.bushansirgur.springboot.domain.enums.TipoAnimal;

@Entity
@Table(name = "animal")

public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataNascimento;
	private String brinco;
	private String nome;
	private Character sexo;
	private String pai;
	private String mae;
	private String raca;
	private Integer tipoAnimal;

	@OneToMany(mappedBy = "animal")
	List<Vacina> vacina = new ArrayList<>();

	public Animal() {
		super();
	}

	public Animal(Integer id, Date dataNascimento, String brinco, String nome, Character sexo, String pai, String mae,
			String raca, TipoAnimal tipoAnimal) {
		this.id = id;
		this.dataNascimento = dataNascimento;
		this.brinco = brinco;
		this.nome = nome;
		this.sexo = sexo;
		this.pai = pai;
		this.mae = mae;
		this.raca = raca;
		this.tipoAnimal = tipoAnimal.getCod();
	}

	public Animal(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public TipoAnimal getTipoAnimal() {
		return TipoAnimal.toEnum(tipoAnimal);
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal.getCod();
	}


	public List<Vacina> getVacina() {
		return vacina;
	}

	public void setVacina(List<Vacina> vacina) {
		this.vacina = vacina;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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