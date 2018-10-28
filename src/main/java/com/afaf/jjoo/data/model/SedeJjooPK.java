package com.afaf.jjoo.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase de clave compuesta para la clave primaria de SedeJjoo
 *
 */
@Embeddable
public class SedeJjooPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="año")
	@NotNull
	@Size(min=4, max=4)
	private Integer anio;
	
	private Integer id_tipo_jjoo;
	
	public SedeJjooPK() {
	}
	
	public SedeJjooPK(Integer anio, Integer id_tipo_jjoo) {
		this.anio = anio;
		this.id_tipo_jjoo = id_tipo_jjoo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getId_tipo_jjoo() {
		return id_tipo_jjoo;
	}

	public void setId_tipo_jjoo(Integer id_tipo_jjoo) {
		this.id_tipo_jjoo = id_tipo_jjoo;
	}
	
	@Override
	public String toString() {
		return this.anio+"/"+this.id_tipo_jjoo;
	}
	

}
