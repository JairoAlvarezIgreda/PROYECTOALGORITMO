package com.udemy.backend.api.curso.adapter.out.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.curso.domain.model.Curso;
import com.udemy.backend.api.shared.domain.operator.ListE;
import com.udemy.backend.api.shared.domain.query.FieldUpdate;
import com.udemy.backend.api.shared.domain.repository.BasicRepository;

/**
 * * Se implementa una interfaz para obtener los datos de la base de datos
 * * extendiendo las funcionalidades que da Jpa, pasando como primer parámetro
 * * clase o la entidad definida y como segundo parámetro el tipo del
 * * identificado.
 */
@Service
public class CursoRepository implements BasicRepository<Curso, Long> {
  private static final ListE<Curso> cursos = new ListE<Curso>();

  @Override
  public ListE<Curso> getAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

  @Override
  public Optional<Curso> findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public Curso save(Curso entity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'save'");
  }

  @Override
  public void deleteById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
  }

  @Override
  public boolean existsById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'existsById'");
  }

  @Override
  public Curso update(Long id, FieldUpdate necessaryField, FieldUpdate... fieldUpdates) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public Curso update(Long id, Collection<FieldUpdate> fieldUpdates) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

}
