package com.udemy.backend.api.shared.application.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;

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
  public E save(E entity) {
    list.add(entity);
    return list.buscar(entity);
  }

  @Override
  public ListE<E> findAll() {
    return list;
  }

  public GlobalBasicRepository(Function<E, ID> idExtractor) {
    this.idExtractor = idExtractor;
  }

  @Override
  public Optional<E> findById(ID id) {
    return list.getBy(idExtractor, id);
  }

  @Override
  public <R> Optional<E> findBy(Function<E, R> extractor, R expected) {
    return list.getBy(extractor, expected);
  }

  @Override
  public void deleteById(ID id) {
    list.deleteBy(idExtractor, id);
  }

  @Override
  public <R> void deleteBy(Function<E, R> extractor, R expected) {
    list.deleteBy(extractor, expected);
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
