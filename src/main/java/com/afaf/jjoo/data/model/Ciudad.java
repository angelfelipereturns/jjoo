package com.afaf.jjoo.data.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase de entidad para mapear los datos de Ciudad de la BBDD
 *
 */
@Entity
public class Ciudad implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_ciudad;
	
	@NotNull
	@Size(min=3, max=64)
	@Column(name="nombre_ciudad")
	private String nombreCiudad;
	
	@ManyToOne
	@JoinColumn(name="id_pais")
	private Pais pais;
	
	private Integer valor_ciudad;
	
	@OneToMany(mappedBy="ciudad", cascade=CascadeType.ALL)
	private List<SedeJjoo> sedes;
	
	public Ciudad() {
	}
	
	public Ciudad(Integer id_ciudad, String nombreCiudad, 
			Pais pais, Integer valor_ciudad, List<SedeJjoo> sedes) {
		this.id_ciudad = id_ciudad;
		this.nombreCiudad = nombreCiudad;
		this.pais = pais;
		this.valor_ciudad = valor_ciudad;
		this.sedes = sedes;
	}

	public Integer getId_ciudad() {
		return id_ciudad;
	}

	public void setId_ciudad(Integer id_ciudad) {
		this.id_ciudad = id_ciudad;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Integer getValor_ciudad() {
		return valor_ciudad;
	}

	public void setValor_ciudad(Integer valor_ciudad) {
		this.valor_ciudad = valor_ciudad;
	}

	public List<SedeJjoo> getSedes() {
		return sedes;
	}

	public void setSedes(List<SedeJjoo> sedes) {
		this.sedes = sedes;
	}
	
	

}
