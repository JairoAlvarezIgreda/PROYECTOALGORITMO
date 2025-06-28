package com.udemy.backend.api.curso.core.application.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.curso.core.adapter.out.repository.CursoRepository;
import com.udemy.backend.api.curso.core.application.port.in.FindCursoPort;
import com.udemy.backend.api.curso.core.domain.model.Course;
import com.udemy.backend.api.shared.domain.operator.ListE;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
/**
 * * Implementación de la lógica para buscar cursos.
 */
public final class FindCursoUseCase implements FindCursoPort {

  private final CursoRepository cursoRepository;

  @Override
  public ListE<Course> getAll() {
    return cursoRepository.getAll();
  }

  @Override
  public Optional<Course> getById(Long id) {
    return cursoRepository.findById(id);
  }

  @Override
  public Optional<Course> getByName(String name) {
    return cursoRepository.findBy(Course::getName, name);
  }
}
