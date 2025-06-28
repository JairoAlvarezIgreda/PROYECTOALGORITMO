package com.udemy.backend.api.curso.core.adapter.out.repository.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.udemy.backend.api.curso.core.adapter.out.repository.CursoRepository;
import com.udemy.backend.api.curso.core.domain.model.Course;
import com.udemy.backend.api.shared.application.repository.GlobalBasicRepository;

@Primary // Equivale a un bean como iniciador.
@Repository // Componente que refiere a un repositorio que encapsula un data storage.
/**
 * * Se inicializa el repositorio extendiendo los métodos de
 * * GlobalBasicRepository y CursoRepository.
 */
public class ImplCursoRepository extends GlobalBasicRepository<Course, Long> implements CursoRepository {
  public ImplCursoRepository() {
    super(Course::getId);
  }

}
