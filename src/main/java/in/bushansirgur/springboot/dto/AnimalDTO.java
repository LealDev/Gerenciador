package in.bushansirgur.springboot.dto;

import java.io.Serializable;
import java.util.Date;

import in.bushansirgur.springboot.domain.Animal;

public class AnimalDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date dataNascimento;
	private String brinco;
	private String nome;
	private Character sexo;
	private String pai;
	private String mae;
	private String raca;
	private Integer tipoAnimal;
	
	public AnimalDTO() {
	}
	
	
	public AnimalDTO(Animal obj) {
		super();
		this.id = obj.getId();
		this.dataNascimento = obj.getDataNascimento();
		this.brinco = obj.getBrinco();
		this.nome = obj.getNome();
		this.sexo = obj.getSexo();
		this.pai = obj.getPai();
		this.mae = obj.getMae();
		this.raca = obj.getRaca();
		this.tipoAnimal = obj.getTipoAnimal().getCod();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public Integer getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(Integer tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}
	
	
} 
