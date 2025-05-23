package com.udemy.backend.api.curso.application.port.in;

import java.util.Optional;

import com.udemy.backend.api.curso.domain.model.Curso;
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
  ListE<Curso> getAll();

  /**
   * * Obtiene un curso por su id.
   * 
   * @param id El id.
   * @return El curso, si no lo encuentra retorna vacío.
   */
  Optional<Curso> getById(Long id);

  /**
   * * Obtiene un curso por su nombre.
   *
   * @param name El nombre del curso.
   * @return El curso, si no lo encuentra retorna vacío.
   */
  Optional<Curso> getByName(String name);
}
