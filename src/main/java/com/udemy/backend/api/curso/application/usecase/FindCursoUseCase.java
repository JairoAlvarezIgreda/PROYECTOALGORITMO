package com.udemy.backend.api.curso.application.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.curso.adapter.out.repository.CursoRepository;
import com.udemy.backend.api.curso.application.port.in.FindCursoPort;
import com.udemy.backend.api.curso.domain.model.Curso;
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
  public ListE<Curso> getAll() {
    return cursoRepository.getAll();
  }

  @Override
  public Optional<Curso> getById(Long id) {
    return cursoRepository.findById(id);
  }
}
