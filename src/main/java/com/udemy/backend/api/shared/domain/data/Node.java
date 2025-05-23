package com.udemy.backend.api.shared.domain.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Node<T> {
  public T dato;
  public Integer index;
  public Node<T> siguiente;

  public Node(T dato, Integer index) {
    this.dato = dato;
    this.index = index;
    this.siguiente = null;
  }
}
