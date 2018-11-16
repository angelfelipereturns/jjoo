package com.afaf.jjoo.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.afaf.jjoo.data.mapper.ResumenSedesRowMapper;
import com.afaf.jjoo.data.model.ResumenSedes;

/**
 * Clase de repositorio DAO para la consulta de resumen de sedes
 * Hace uso de JdbcTemplate
 *
 */
@Repository
public class ResumenSedesDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	private String consultaResumenSedes;
	
	/**
	 * Metodo para obtener de la BBDD la lista de resumen de sedes	
	 * @return lista de resumen de sedes
	 */
	public List<ResumenSedes> listaResumenSedes(){
		List<ResumenSedes> listaResumenSedes = jdbc.query(this.consultaResumenSedes(), 
				new ResumenSedesRowMapper().getRowMapper());
		return listaResumenSedes;
	}
	
	
	private String consultaResumenSedes() {
		this.consultaResumenSedes = "select "
										+ "p.id_pais, p.nombre_pais, "
										+ "c.id_ciudad, c.nombre_ciudad, "
										+ "ifnull(c.valor_ciudad, p.valor_pais) as valor, "
										+ "t.descripcion_tipo as descripcion_tipo_jjoo, "
										+ "count(s.sede) as numero_veces_sede " + 
									"from "
										+ "pais p, sede_jjoo s, ciudad c, tipo_jjoo t " + 
									"where " + 
										"c.id_ciudad = s.sede " + 
									"and " + 
										"p.id_pais = c.id_pais " + 
									"and " + 
										"s.id_tipo_jjoo = t.id_tipo_jjoo " + 
									"group by " + 
										"s.sede " + 
									"order by  " + 
										"s.año " + 
									";";
		return this.consultaResumenSedes;
	}
	

}
