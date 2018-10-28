package com.afaf.jjoo.data.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * Clase de entidad para mapear los datos de SedeJjoo de la BBDD
 *
 */
@Entity
@Table(name="sede_jjoo")
public class SedeJjoo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SedeJjooPK sedeJjooPK;
	
	@MapsId("id_tipo_jjoo")
	@JoinColumn(name="id_tipo_jjoo", referencedColumnName="id_tipo_jjoo")
	@ManyToOne 
    private TipoJjoo tipojjoo;
	
	@ManyToOne
	@JoinColumn(name="sede")
	private Ciudad ciudad;
	
	public SedeJjoo() {
	}
	
	public SedeJjoo(SedeJjooPK sedeJjooPK, TipoJjoo tipojjoo, 
			Ciudad ciudad) {
		this.sedeJjooPK = sedeJjooPK;
		this.tipojjoo = tipojjoo;
		this.ciudad = ciudad;
	}

	public SedeJjooPK getSedeJjooPK() {
		return sedeJjooPK;
	}

	public void setSedeJjooPK(SedeJjooPK sedeJjooPK) {
		this.sedeJjooPK = sedeJjooPK;
	}
	
	public TipoJjoo getTipojjoo() {
		return tipojjoo;
	}

	public void setTipojjoo(TipoJjoo tipojjoo) {
		this.tipojjoo = tipojjoo;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	

}
