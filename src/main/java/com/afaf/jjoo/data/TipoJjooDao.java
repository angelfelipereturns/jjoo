package com.afaf.jjoo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afaf.jjoo.data.model.TipoJjoo;

/**
 * Clase de repositorio DAO para la entidad tipo_jjoo de jjoo
 * Hace uso de JpaRepository
 *
 */
@Repository
public interface TipoJjooDao extends JpaRepository<TipoJjoo, Integer> {

}
