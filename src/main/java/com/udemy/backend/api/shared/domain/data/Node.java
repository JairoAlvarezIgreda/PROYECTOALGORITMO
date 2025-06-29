package com.udemy.backend.api.shared.domain.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Node<T> {
  public T data;
  public Node<T> next;

  public Node(T dato, Integer index) {
    this.data = dato;
    this.next = null;
  }
}
