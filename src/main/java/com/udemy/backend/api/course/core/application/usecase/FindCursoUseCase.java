package com.udemy.backend.api.course.core.application.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.course.category.core.application.port.FindCategoryPort;
import com.udemy.backend.api.course.category.core.domain.model.Category;
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
  private final FindCategoryPort findCategoryPort;

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
    Optional<Course> curso = cursoRepository.findBy(Course::getName, name);
    return curso;
  }

  @Override
  public ListE<Course> getAllByName(String name) {
    return cursoRepository.findAllByLike(Course::getName, name);
  }

  @Override
  public ListE<Course> getAllByCategory(Long id) {
    Category category = findCategoryPort.getById(id).orElseThrow(() -> new RuntimeException("La categoría no existe"));
    return cursoRepository.findAllBy(Course::getCategory, category);
  }
}
