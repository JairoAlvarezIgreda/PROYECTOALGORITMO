package com.udemy.backend.api.shared.domain.repository;

import java.util.Optional;
import java.util.function.Function;

import com.udemy.backend.api.shared.domain.operator.ListE;

/**
 * * Funcionalidades básicas para un repositorio.
 *
 * @param <E>  El tipo de la entidad.
 * @param <ID> El tipo del identificador único de la entidad.
 * @param <F>  El tipo de excepción.
 */
public interface BasicRepository<E, ID> {

  /**
   * * Busca todas las entidades.
   *
   * @return La lista de las entidades.
   */
  ListE<E> findAll();

  /**
   * * Busca una entidad por su id.
   *
   * @param id El id.
   * @return La entidad.
   */
  Optional<E> findById(ID id);

  /**
   * * Busca una entidad por uno de sus parámetros.
   * 
   * @param extractor El identificador del parámetro.
   * @param <R>       El valor de la búsqueda.
   * @return La entidad.
   */
  <R> Optional<E> findBy(Function<E, R> extractor, R expected);

  public <R> ListE<E> findAllBy(Function<E, R> extractor, R expected);

  /**
   * * Guarda la entidad en la lista.
   *
   * @param entity La entidad.
   * @return La entidad guardada.
   */
  E save(E entity);

  /**
   * * Elimina una entidad por su id.
   *
   * @param id El id.
   * @return void si lo elimina, failure si es que algo falla.
   */
  void deleteById(ID id);

  <R> void deleteBy(Function<E, R> extractor, R expected);

  /**
   * Actualiza los parámetros de la entidad por el id.
   *
   * @param id           El id de la entidad.
   * @param fieldUpdates Los parámetros a actualizar.
   * @return La entidad actualizada.
   */
  E update(E data);
}
