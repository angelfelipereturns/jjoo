package com.afaf.jjoo.data.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase de entidad para mapear los datos de TipoJjoo de la BBDD
 *
 */
@Entity
@Table(name="tipo_jjoo")
public class TipoJjoo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_tipo_jjoo;
	
	@NotNull
	@Size(min=3, max=32)
	private String descripcion_tipo;
	
	@OneToMany(mappedBy="sedeJjooPK.id_tipo_jjoo", cascade=CascadeType.ALL)
	private List<SedeJjoo> sedes;
	
	
	public TipoJjoo() {
	}
	
	public TipoJjoo(Integer id_tipo_jjoo, String descripcion_tipo, 
			List<SedeJjoo> sedes) {
		this.id_tipo_jjoo = id_tipo_jjoo;
		this.descripcion_tipo = descripcion_tipo;
		this.sedes = sedes;
	}

	public Integer getId_tipo_jjoo() {
		return id_tipo_jjoo;
	}

	public void setId_tipo_jjoo(Integer id_tipo_jjoo) {
		this.id_tipo_jjoo = id_tipo_jjoo;
	}

	public String getDescripcion_tipo() {
		return descripcion_tipo;
	}

	public void setDescripcion_tipo(String descripcion_tipo) {
		this.descripcion_tipo = descripcion_tipo;
	}

	public List<SedeJjoo> getSedes() {
		return sedes;
	}

	public void setSedes(List<SedeJjoo> sedes) {
		this.sedes = sedes;
	}

	
	

}
