package com.udemy.backend.api.course.core.application.port.in;

import java.util.Optional;

import com.udemy.backend.api.course.core.domain.model.Course;
import com.udemy.backend.api.shared.domain.operator.ListE;

/**
 * * Definición de métodos para obtener cursos.
 */
public interface FindCursoPort {

  /**
   * * Obtiene todos los cursos.
   *
   * @return Los cursos.
   */
  ListE<Course> getAll();

  /**
   * * Obtiene un curso por su id.
   * 
   * @param id El id.
   * @return El curso, si no lo encuentra retorna vacío.
   */
  Optional<Course> getById(Long id);

  /**
   * * Obtiene un curso por su nombre.
   *
   * @param name El nombre del curso.
   * @return El curso, si no lo encuentra retorna vacío.
   */
  Optional<Course> getByName(String name);
}
