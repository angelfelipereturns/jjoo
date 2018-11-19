package com.afaf.jjoo.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.afaf.jjoo.data.model.ResumenSedes;

/**
 * Clase mapeadora de los resultados obtenidos en BBDD al POJO de resumen de sedes
 *
 */
public class ResumenSedesRowMapper {
	
	private RowMapper<ResumenSedes> rowMapper;
	
	/**
	 * Constructor para instanciar el objeto RowMapper<ResumenSedes>
	 * @throws SQLException 
	 */
	public ResumenSedesRowMapper() throws SQLException {
		try {
			rowMapper = new RowMapper<ResumenSedes>() {
				@Override
				public ResumenSedes mapRow(ResultSet rs, int rowNum) throws SQLException {
					ResumenSedes resumenSedes = new ResumenSedes(rs.getInt(1), rs.getString(2), 
							rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
					return resumenSedes;
				}
				
			};
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
	
	/**
	 * Metodo getter para obtener el objeto RowMapper<ResumenSedes>
	 * @return objeto RowMapper<ResumenSedes>
	 */
	public RowMapper<ResumenSedes> getRowMapper() {
		return rowMapper;
	}

}
