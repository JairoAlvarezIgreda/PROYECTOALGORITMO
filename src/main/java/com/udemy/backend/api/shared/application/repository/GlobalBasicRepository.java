package com.udemy.backend.api.shared.application.repository;

import java.util.Collection;
import java.util.Optional;

import com.udemy.backend.api.shared.domain.operator.ListE;
import com.udemy.backend.api.shared.domain.query.FieldUpdate;
import com.udemy.backend.api.shared.domain.repository.BasicRepository;

/**
 * * Clase global para establecer todas las funciones básicas de un repositorio.
 */
public final class GlobalBasicRepository<E, ID> implements BasicRepository<E, ID> {
  private final ListE<E> list = new ListE<E>(); // Inicializa la lista dependiendo la instancia.

  @Override
  public ListE<E> getAll() {
    return list;
  }

  @Override
  public Optional<E> findById(ID id) {
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public E save(E entity) {
    throw new UnsupportedOperationException("Unimplemented method 'save'");
  }

  @Override
  public void deleteById(ID id) {
    throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
  }

  @Override
  public boolean existsById(ID id) {
    throw new UnsupportedOperationException("Unimplemented method 'existsById'");
  }

  @Override
  public E update(ID id, FieldUpdate necessaryField, FieldUpdate... fieldUpdates) {
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public E update(ID id, Collection<FieldUpdate> fieldUpdates) {
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }
}
