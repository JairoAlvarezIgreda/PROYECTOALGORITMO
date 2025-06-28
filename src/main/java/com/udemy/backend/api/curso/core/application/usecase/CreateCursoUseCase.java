package com.udemy.backend.api.curso.core.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.curso.core.adapter.out.repository.CursoRepository;
import com.udemy.backend.api.curso.core.application.port.in.CreateCursoPort;
import com.udemy.backend.api.curso.core.domain.model.Course;
import com.udemy.backend.api.curso.core.domain.request.CreateCursoRequest;

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
  private Long idGenerator = 0L;

  @Override
  public Course create(CreateCursoRequest request) {
    // Primero se deben obtener y construir un nuevo objeto con los datos de la
    // request.
    Course newCurso = Course.builder().id(idGenerator).name(request.getName()).build();
    idGenerator += 1;

    // Se guarda el nuevo curso en la base de datos con las funciones del
    // repositorio.
    return cursoRepository.save(newCurso);
  }
}
