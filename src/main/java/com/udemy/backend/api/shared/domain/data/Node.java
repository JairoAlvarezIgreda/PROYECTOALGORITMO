package com.udemy.backend.api.shared.domain.data;

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
