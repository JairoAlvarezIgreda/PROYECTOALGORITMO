package com.udemy.backend.api.shared.application.repository;

import java.util.Optional;
import java.util.function.Function;

import com.udemy.backend.api.shared.domain.operator.BinarySearchTree;
import com.udemy.backend.api.shared.domain.operator.ListE;
import com.udemy.backend.api.shared.domain.repository.BasicRepository;

public abstract class GlobalBasicRepository<E, ID extends Comparable<? super ID>> implements BasicRepository<E, ID> {
  private final ListE<E> list = new ListE<>();
  private final BinarySearchTree<E, ID> tree;
  private final Function<E, ID> idExtractor;

  public GlobalBasicRepository(Function<E, ID> idExtractor) {
    this.idExtractor = idExtractor;
    this.tree = new BinarySearchTree<>(idExtractor);
  }

  @Override
  public E save(E entity) {
    E saved = list.add(entity);
    tree.insert(saved);
    return saved;
  }

  @Override
  public E update(E data) {
    E updated = list.update(data, idExtractor);
    tree.insert(updated);
    return updated;
  }

  @Override
  public void deleteById(ID id) {
    Optional<E> found = tree.searchBy(idExtractor, id);
    found.ifPresent(tree::delete);
    list.deleteBy(idExtractor, id);
  }

  @Override
  public <R> void deleteBy(Function<E, R> extractor, R expected) {
    Optional<E> found = list.getBy(extractor, expected);
    found.ifPresent(tree::delete);
    list.deleteBy(extractor, expected);
  }

  @Override
  public Optional<E> findById(ID id) {
    return tree.searchBy(idExtractor, id);
  }

  @Override
  public <R> Optional<E> findBy(Function<E, R> extractor, R expected) {
    return list.getByLike(extractor, expected);
  }

  @Override
  public ListE<E> findAll() {
    return list;
  }

  @Override
  public <R> ListE<E> findAllBy(Function<E, R> extractor, R expected) {
    ListE<E> result = new ListE<>();
    list.forEach((item) -> {
      if (extractor.apply(item).equals(expected)) {
        result.add(item);
      }
    });
    return result;
  }

  @Override
  public ListE<E> findAllByLike(Function<E, String> extractor, String partial) {
    ListE<E> result = new ListE<>();
    list.forEach(item -> {
      String field = extractor.apply(item);
      if (field != null && field.toLowerCase().contains(partial.toLowerCase())) {
        result.add(item);
      }
    });
    return result;
  }

}
