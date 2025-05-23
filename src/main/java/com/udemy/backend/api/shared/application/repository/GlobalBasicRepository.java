package com.udemy.backend.api.shared.application.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

import com.udemy.backend.api.shared.domain.data.Node;
import com.udemy.backend.api.shared.domain.operator.ListE;
import com.udemy.backend.api.shared.domain.query.FieldUpdate;
import com.udemy.backend.api.shared.domain.repository.BasicRepository;

/**
 * * Clase global para establecer todas las funciones básicas de un repositorio.
 */
public abstract class GlobalBasicRepository<E, ID> implements BasicRepository<E, ID> {
  private final ListE<E> list = new ListE<E>(); // Inicializa la lista dependiendo la instancia.
  private final Function<E, ID> idExtractor;

  @Override
  public ListE<E> getAll() {
    return list;
  }

  public GlobalBasicRepository(Function<E, ID> idExtractor) {
    this.idExtractor = idExtractor;
  }

  @Override
  public Optional<E> findById(ID id) {
    Node<E> current = list.getHead();

    while (current != null) {
      if (idExtractor.apply(current.getData()).equals(id))
        return Optional.of(current.getData());
      current = current.getNext();
    }

    return Optional.empty();
  }

  @Override
  public E save(E entity) {
    list.add(entity);
    return list.buscar(entity);
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
