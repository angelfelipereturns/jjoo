package com.afaf.jjoo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.afaf.jjoo.data.CiudadDao;
import com.afaf.jjoo.data.PaisDao;
import com.afaf.jjoo.data.SedeJjooDao;
import com.afaf.jjoo.data.TipoJjooDao;
import com.afaf.jjoo.data.model.Ciudad;
import com.afaf.jjoo.data.model.Pais;
import com.afaf.jjoo.data.model.SedeJjoo;
import com.afaf.jjoo.data.model.SedeJjooPK;
import com.afaf.jjoo.data.model.TipoJjoo;

/**
 * Clase de servicio para comunicar con los DAO de entidades de jjoo
 *
 */
@Service
public class JjooService {
	
	@Autowired
	private PaisDao paisDao;
	
	@Autowired
	private CiudadDao ciudadDao;
	
	@Autowired
	private TipoJjooDao tipoJjooDao;
	
	@Autowired
	private SedeJjooDao sedeJjooDao;
	
	
	/**
	 * Metodo para obtener la lista de sedes de jjoo ordenada por anio
	 * @return lista de sedes de jjoo ordenada por anio
	 * @throws Exception 
	 */
	public List<SedeJjoo> listaSedesJjoo() throws Exception {
		try {
			List<SedeJjoo> listaSedeJjoo = sedeJjooDao.findAll(Sort.by(Order.by("sedeJjooPK.anio")));
			return listaSedeJjoo;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	/**
	 * Metodo para obtener una sede de jjoo por su id
	 * @param sedeJjooPK id de la sede
	 * @return objeto SedeJjoo
	 * @throws Exception 
	 */
	public SedeJjoo getSede(SedeJjooPK sedeJjooPK) throws Exception {
		try {
			Optional<SedeJjoo> sedeJjooGet = sedeJjooDao.findById(sedeJjooPK);
			return sedeJjooGet.get();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	/**
	 * Metodo para borrar una sede de jjoo por su id
	 * @param sedeJjooPK id de la sede
	 * @throws Exception 
	 */
	public void borrarSede(SedeJjooPK sedeJjooPK) throws Exception {
		try {
			sedeJjooDao.deleteById(sedeJjooPK);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	/**
	 * Metodo para obtener la lista de tipo de jjoo
	 * @return lista de tipo de jjoo
	 * @throws Exception 
	 */
	public List<TipoJjoo> listaTipoJjoo() throws Exception{
		try {
			List<TipoJjoo> listaTipoJjoo = tipoJjooDao.findAll();
			return listaTipoJjoo;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	/**
	 * Metodo para insertar nueva o modificar sede de jjoo
	 * @param sedeJjoo objeto SedeJjoo
	 * @throws Exception 
	 */
	public void salvaSede(SedeJjoo sedeJjoo) throws Exception {
		try {
			String nombrePais = sedeJjoo.getCiudad().getPais().getNombrePais().toUpperCase();
			String codigo_pais = sedeJjoo.getCiudad().getPais().getCodigo_pais().toUpperCase();
			Optional<Pais> pais = paisDao.findByNombrePais(nombrePais);
			if(!pais.isPresent()) {
				sedeJjoo.getCiudad().getPais().setNombrePais(nombrePais);
				sedeJjoo.getCiudad().getPais().setCodigo_pais(codigo_pais);
				Pais paisSave = paisDao.save(sedeJjoo.getCiudad().getPais());
				sedeJjoo.getCiudad().setPais(paisSave);
			}
			else {
				if(!codigo_pais.equalsIgnoreCase(pais.get().getCodigo_pais())) {
					pais.get().setCodigo_pais(codigo_pais);
				}
				if(pais.get().getValor_pais()!=sedeJjoo.getCiudad().getPais().getValor_pais()) {
					pais.get().setValor_pais(sedeJjoo.getCiudad().getPais().getValor_pais());
				}
				sedeJjoo.getCiudad().setPais(pais.get());
			}
			String nombreCiudad = sedeJjoo.getCiudad().getNombreCiudad().toUpperCase();
			Optional<Ciudad> ciudad = ciudadDao.findByNombreCiudad(nombreCiudad);
			if(!ciudad.isPresent()) {
				sedeJjoo.getCiudad().setNombreCiudad(nombreCiudad);
				Ciudad ciudadSave = ciudadDao.save(sedeJjoo.getCiudad());
				sedeJjoo.setCiudad(ciudadSave);
			}
			else {
				if(ciudad.get().getValor_ciudad()!=sedeJjoo.getCiudad().getValor_ciudad()) {
					ciudad.get().setValor_ciudad(sedeJjoo.getCiudad().getValor_ciudad());
				}
				sedeJjoo.setCiudad(ciudad.get());
			}
			if(null==sedeJjoo.getSedeJjooPK().getId_tipo_jjoo()) {
				sedeJjoo.getSedeJjooPK().setId_tipo_jjoo(sedeJjoo.getTipojjoo().getId_tipo_jjoo());
			}
			sedeJjooDao.save(sedeJjoo);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	

}
