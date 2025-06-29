package com.udemy.backend.api.course.core.application.port.in;

import com.udemy.backend.api.course.core.domain.model.Course;
import com.udemy.backend.api.course.core.domain.request.CreateCursoRequest;

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
