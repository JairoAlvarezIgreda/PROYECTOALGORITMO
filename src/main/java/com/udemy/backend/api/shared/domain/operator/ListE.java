package com.udemy.backend.api.shared.domain.operator;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.udemy.backend.api.shared.domain.data.Node;
import com.udemy.backend.api.shared.domain.util.ListESerializer;

import lombok.Getter;

@Getter
@JsonSerialize(using = ListESerializer.class)
public class ListE<T> {
  Node<T> head;

  // Agrega un node al final de la lista
  public void add(T data) {
    Node<T> newNode = new Node<T>(data, size());

    if (head == null) {
      head = newNode;
    } else {
      Node<T> tmp = head;
      while (tmp.getNext() != null) {
        tmp = tmp.getNext();
      }
      tmp.setNext(newNode);
    }
  }

  Integer size() {
    Node<T> actual = head;
    Integer size = 0;
    while (actual != null) {
      size++;
      actual = actual.getNext();
    }
    return size;
  }

  // Imprime la lista
  void imprimir() {
    Node<T> actual = head;
    while (actual != null) {
      System.out.print(actual.getData() + ":" + actual.index.toString() + " -> ");
      actual = actual.getNext();
    }
    System.out.println("null");
  }

  public T buscar(T data) {
    Node<T> actual = head;
    while (actual != null) {
      if (actual.getData() == data)
        return actual.getData();
      actual = actual.getNext();
    }
    return null;
  }

  public void delete(T data) {
    if (head == null)
      return;

    if (head.getData().equals(data)) {
      head = head.getNext();
      updateIndex(head, 0);
      return;
    }

    Node<T> tmp = head;
    while (tmp.getNext() != null && !tmp.getNext().getData().equals(data)) {
      tmp = tmp.getNext();
    }

    if (tmp.getNext() == null)
      return;

    tmp.setNext(tmp.getNext().getNext());
    updateIndex(tmp.getNext(), tmp.index + 1);
  }

  private void updateIndex(Node<T> node, int indiceInicial) {
    Node<T> actual = node;
    int indice = indiceInicial;
    while (actual != null) {
      actual.index = indice++;
      actual = actual.getNext();
    }
  }

  void eliminarPares() {
    Node<T> actual = head;

    while (actual.getNext() != null) {
      if (actual.index % 2 == 0 || actual.index == 0) {
        delete(actual.getData());
      }
      actual = actual.getNext();
    }
  }

  @Override
  public String toString() {
    return "aa";
  }
}