package com.phoebus.StarWars.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_rebelde")
public class Rebelde implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private double idade;
	
	@NotNull
	private String genero;
	
	@NotNull
	private String localidade;
	
	@NotNull
	private boolean traidor;
	
	@OneToMany(mappedBy = "rebelde", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Inventario> inventario;
	@Transient
	private int denuncias = 0;
	
	public Rebelde() {
		
	}
	
	
	public Rebelde(@NotNull String nome, @NotNull double idade, @NotNull String genero, @NotNull String localidade,
			@NotNull boolean traidor, int denuncias) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.genero = genero;
		this.localidade = localidade;
		this.traidor = traidor;
		this.denuncias = denuncias;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getIdade() {
		return idade;
	}

	public void setIdade(double idade) {
		this.idade = idade;
	}


	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}



	public boolean isTraidor() {
		if (denuncias >= 3){
			return true;
		}
		return false;
	}

	public void setTraidor(boolean traidor) {
		this.traidor = traidor;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public int getDenuncias() {
		return denuncias;
	}


	public void setDenuncias(int denuncias) {
		this.denuncias = denuncias;
	}


	public List<Inventario> getInventario() {
		return inventario;
	}


	public void setInventario(List<Inventario> inventario) {
		this.inventario = inventario;
	}


	
	
}
