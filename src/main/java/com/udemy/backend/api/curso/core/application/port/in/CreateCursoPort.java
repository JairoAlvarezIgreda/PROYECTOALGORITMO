package com.udemy.backend.api.curso.core.application.port.in;

import com.udemy.backend.api.curso.core.domain.model.Course;
import com.udemy.backend.api.curso.core.domain.request.CreateCursoRequest;

/**
 * * Definición de métodos para crear un curso.
 */
public interface CreateCursoPort {

  /**
   * * Crea un nuevo curso.
   * 
   * @param request La request.
   * @return {@link Course}
   */
  Course create(CreateCursoRequest request);
}
