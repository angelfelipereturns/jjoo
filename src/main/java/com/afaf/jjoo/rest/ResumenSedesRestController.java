package com.afaf.jjoo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afaf.jjoo.data.model.ResumenSedes;
import com.afaf.jjoo.service.ResumenSedesService;

/**
 * Clase de API REST para servir por consulta GET el resumen de sedes
 *
 */
@RestController
public class ResumenSedesRestController {

	@Autowired
	private ResumenSedesService resumenSedesService;
	
	/**
	 * Metodo REST para obtener json de resumen de sedes
	 * url: http://hostdelservidor/jjoo/resumensedes
	 * @return json de resumen de sedes
	 */
	@RequestMapping(value="/resumensedes", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ResumenSedes> getResumenSedes(){
		List<ResumenSedes> listaResumenSedes = resumenSedesService.listaResumenSedes();
		return listaResumenSedes;
	}
}
