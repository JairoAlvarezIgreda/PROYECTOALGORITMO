package com.udemy.backend.api.curso.core.adapter.out.repository;

import com.udemy.backend.api.curso.core.domain.model.Course;
import com.udemy.backend.api.shared.domain.repository.BasicRepository;

/**
 * * Se implementa una interfaz para obtener los datos de la base de datos
 * * extendiendo las funcionalidades que da BasicRepository, pasando como primer
 * * parámetro la clase o la entidad definida y como segundo parámetro el tipo
 * * del identificador.
 */
public interface CursoRepository extends BasicRepository<Course, Long> {
}
