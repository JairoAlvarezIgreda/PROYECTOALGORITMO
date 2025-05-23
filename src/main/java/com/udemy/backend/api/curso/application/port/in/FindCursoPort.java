package com.udemy.backend.api.curso.application.port.in;

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
}
