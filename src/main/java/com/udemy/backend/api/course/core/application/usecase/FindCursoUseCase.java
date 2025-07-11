package com.udemy.backend.api.course.core.application.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.course.core.adapter.out.repository.CursoRepository;
import com.udemy.backend.api.course.core.application.port.in.FindCoursePort;
import com.udemy.backend.api.course.core.domain.model.Course;
import com.udemy.backend.api.shared.domain.operator.ListE;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
/**
 * * Implementación de la lógica para buscar cursos.
 */
public final class FindCursoUseCase implements FindCoursePort {

  private final CursoRepository cursoRepository;

  @Override
  public ListE<Course> getAll() {
    return cursoRepository.findAll();
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
