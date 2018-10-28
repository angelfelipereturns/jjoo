package com.afaf.jjoo.data.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase de entidad para mapear los datos de Pais de la BBDD
 *
 */
@Entity
public class Pais implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_pais;
	
	@NotNull
	@Size(min=3, max=64)
	@Column(name="nombre_pais")
	private String nombrePais;
	
	@NotNull
	@Size(min=2, max=2)
	private String codigo_pais;
	
	@NotNull
	private Integer valor_pais;
	
	@OneToMany(mappedBy="pais", cascade = CascadeType.ALL)
	private List<Ciudad> ciudades;
	
	public Pais() {
	}
	
	public Pais(Integer id_pais, String nombrePais, 
			String codigo_pais, Integer valor_pais) {
		this.id_pais = id_pais;
		this.nombrePais = nombrePais;
		this.codigo_pais = codigo_pais;
		this.valor_pais = valor_pais;
	}

	public Integer getId_pais() {
		return id_pais;
	}

	public void setId_pais(Integer id_pais) {
		this.id_pais = id_pais;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public String getCodigo_pais() {
		return codigo_pais;
	}

	public void setCodigo_pais(String codigo_pais) {
		this.codigo_pais = codigo_pais;
	}

	public Integer getValor_pais() {
		return valor_pais;
	}

	public void setValor_pais(Integer valor_pais) {
		this.valor_pais = valor_pais;
	}
	
	

}
