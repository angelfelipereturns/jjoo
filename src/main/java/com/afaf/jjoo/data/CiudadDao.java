package com.afaf.jjoo.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afaf.jjoo.data.model.Ciudad;

/**
 * Clase de repositorio DAO para la entidad ciudad de jjoo
 * Hace uso de JpaRepository
 *
 */
@Repository
public interface CiudadDao extends JpaRepository<Ciudad, Integer> {
	
	/**
	 * Metodo para buscar una ciudad por su nombre
	 * @param nombreCiudad nombre de la ciudad
	 * @return objeto Optional<Ciudad>
	 */
	public Optional<Ciudad> findByNombreCiudad(String nombreCiudad);

}
