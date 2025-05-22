package com.udemy.backend.api.curso.application.port.in;

import com.udemy.backend.api.curso.domain.model.Curso;
import com.udemy.backend.api.curso.domain.request.CreateCursoRequest;

/**
 * * Definición de métodos para crear un curso.
 */
public interface CreateCursoPort {

  /**
   * * Crea un nuevo curso.
   * 
   * @param request La request.
   * @return {@link Curso}
   */
  Curso create(CreateCursoRequest request);
}
