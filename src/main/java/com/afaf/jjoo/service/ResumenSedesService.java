package com.afaf.jjoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afaf.jjoo.data.ResumenSedesDao;
import com.afaf.jjoo.data.model.ResumenSedes;

/**
 * Clase de servicio para comunicar con el DAO de resumen de sedes
 *
 */
@Service
public class ResumenSedesService {
	
	@Autowired
	private ResumenSedesDao resumenSedesDao;
	
	/**
	 * Metodo para obtener la lista de resumen de sedes
	 * @return lista de resumen de sedes
	 */
	public List<ResumenSedes> listaResumenSedes(){
		List<ResumenSedes> listaResumenSedes = resumenSedesDao.listaResumenSedes();
		return listaResumenSedes;
	}

}
