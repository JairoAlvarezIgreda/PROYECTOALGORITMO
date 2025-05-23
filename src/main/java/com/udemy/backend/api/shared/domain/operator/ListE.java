package com.udemy.backend.api.shared.domain.operator;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.udemy.backend.api.shared.domain.data.Node;
import com.udemy.backend.api.shared.domain.util.ListESerializer;

import lombok.Getter;

@Getter
@JsonSerialize(using = ListESerializer.class)
public class ListE<T> {
  Node<T> cabeza;

  // Agrega un node al final de la lista
  public void insertar(T dato) {
    Node<T> nuevoNode = new Node<T>(dato, size());

    if (cabeza == null) {
      cabeza = nuevoNode;
    } else {
      Node<T> actual = cabeza;
      while (actual.getNext() != null) {
        actual = actual.getNext();
      }
      actual.setNext(nuevoNode);
    }
  }

  Integer size() {
    Node<T> actual = cabeza;
    Integer size = 0;
    while (actual != null) {
      size++;
      actual = actual.getNext();
    }
    return size;
  }

  // Imprime la lista
  void imprimir() {
    Node<T> actual = cabeza;
    while (actual != null) {
      System.out.print(actual.getData() + ":" + actual.index.toString() + " -> ");
      actual = actual.getNext();
    }
    System.out.println("null");
  }

  public T buscar(T data) {
    Node<T> actual = cabeza;
    while (actual != null) {
      if (actual.getData() == data)
        return actual.getData();
      actual = actual.getNext();
    }
    return null;
  }

  public void eliminar(T dato) {
    if (cabeza == null)
      return;

    if (cabeza.getData().equals(dato)) {
      cabeza = cabeza.getNext();
      actualizarIndicesDesde(cabeza, 0);
      return;
    }

    Node<T> actual = cabeza;
    while (actual.getNext() != null && !actual.getNext().getData().equals(dato)) {
      actual = actual.getNext();
    }

    if (actual.getNext() != null) {
      actual.setNext(actual.getNext().getNext());
      actualizarIndicesDesde(actual.getNext(), actual.index + 1);
    }
  }

  private void actualizarIndicesDesde(Node<T> node, int indiceInicial) {
    Node<T> actual = node;
    int indice = indiceInicial;
    while (actual != null) {
      actual.index = indice++;
      actual = actual.getNext();
    }
  }

  void eliminarPares() {
    Node<T> actual = cabeza;

    while (actual.getNext() != null) {
      if (actual.index % 2 == 0 || actual.index == 0) {
        eliminar(actual.getData());
      }
      actual = actual.getNext();
    }
  }

  @Override
  public String toString() {
    return "aa";
  }
}