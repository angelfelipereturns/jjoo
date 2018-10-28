package com.afaf.jjoo.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afaf.jjoo.data.model.Pais;

/**
 * Clase de repositorio DAO para la entidad pais de jjoo
 * Hace uso de JpaRepository
 *
 */
@Repository
public interface PaisDao extends JpaRepository<Pais, Integer> {
	
	/**
	 * Metodo para buscar un pais por su nombre
	 * @param nombrePais nombre del pais
	 * @return objeto Optional<Pais>
	 */
	public Optional<Pais> findByNombrePais(String nombrePais);

}
