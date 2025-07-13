package com.udemy.backend.api.course.core.application.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.course.category.core.application.port.FindCategoryPort;
import com.udemy.backend.api.course.category.core.domain.model.Category;
import com.udemy.backend.api.course.core.adapter.out.repository.CursoRepository;
import com.udemy.backend.api.course.core.application.port.in.CreateCursoPort;
import com.udemy.backend.api.course.core.domain.model.Course;
import com.udemy.backend.api.course.core.domain.request.CreateCursoRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
/**
 * * Implementación de la lógica para crear un curso.
 */
public final class CreateCursoUseCase implements CreateCursoPort {
  private final CursoRepository cursoRepository;
  private final FindCategoryPort findCategoryPort;
  private Long idGenerator = 0L;

  @Override
  public Course create(CreateCursoRequest request) {
    Category category = findCategoryPort.getById(request.getCategoryId())
        .orElseThrow(() -> new RuntimeException("La categoría no existe"));

    idGenerator += 1;

    // Primero se deben obtener y construir un nuevo objeto con los datos de la
    // request.
    Course newCurso = Course
        .builder()
        .id(idGenerator)
        .name(request.getName())
        .littleDescription(request.getLittleDescription())
        .description(request.getDescription())
        .tags(request.getTags())
        .price(request.getPrice())
        .category(category)
        .createdAt(LocalDateTime.now())
        .build();

    // Se guarda el nuevo curso en la base de datos con las funciones del
    // repositorio.
    return cursoRepository.save(newCurso);
  }
}
