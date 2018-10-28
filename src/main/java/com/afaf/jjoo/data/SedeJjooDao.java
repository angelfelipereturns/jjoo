package com.afaf.jjoo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afaf.jjoo.data.model.SedeJjoo;
import com.afaf.jjoo.data.model.SedeJjooPK;

/**
 * Clase de repositorio DAO para la entidad sede_jjoo de jjoo
 * Hace uso de JpaRepository
 *
 */
@Repository
public interface SedeJjooDao extends JpaRepository<SedeJjoo, SedeJjooPK> {

}
