package com.udemy.backend.api.curso.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.curso.adapter.out.repository.CursoRepository;
import com.udemy.backend.api.curso.application.port.in.CreateCursoPort;
import com.udemy.backend.api.curso.domain.model.Curso;
import com.udemy.backend.api.curso.domain.request.CreateCursoRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * * Aquí se implementa toda la lógica para crear un curso.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public final class CreateCursoUseCase implements CreateCursoPort {

  private final CursoRepository cursoRepository;

  @Override
  public Curso create(CreateCursoRequest request) {
    // Primero se deben obtener y construir un nuevo objeto con los datos de la
    // request.
    Curso newCurso = Curso.builder().name(request.getName()).build();

    // Se guarda el nuevo curso en la base de datos con las funciones del
    // repositorio.
    return cursoRepository.save(newCurso);
  }
}
