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
      while (actual.siguiente != null) {
        actual = actual.siguiente;
      }
      actual.siguiente = nuevoNode;
    }
  }

  Integer size() {
    Node<T> actual = cabeza;
    Integer size = 0;
    while (actual != null) {
      size++;
      actual = actual.siguiente;
    }
    return size;
  }

  // Imprime la lista
  void imprimir() {
    Node<T> actual = cabeza;
    while (actual != null) {
      System.out.print(actual.dato + ":" + actual.index.toString() + " -> ");
      actual = actual.siguiente;
    }
    System.out.println("null");
  }

  public T buscar(T dato) {
    Node<T> actual = cabeza;
    while (actual != null) {
      if (actual.dato == dato)
        return actual.dato;
      actual = actual.siguiente;
    }
    return null;
  }

  public void eliminar(T dato) {
    if (cabeza == null)
      return;

    if (cabeza.dato.equals(dato)) {
      cabeza = cabeza.siguiente;
      actualizarIndicesDesde(cabeza, 0);
      return;
    }

    Node<T> actual = cabeza;
    while (actual.siguiente != null && !actual.siguiente.dato.equals(dato)) {
      actual = actual.siguiente;
    }

    if (actual.siguiente != null) {
      actual.siguiente = actual.siguiente.siguiente;
      actualizarIndicesDesde(actual.siguiente, actual.index + 1);
    }
  }

  private void actualizarIndicesDesde(Node<T> node, int indiceInicial) {
    Node<T> actual = node;
    int indice = indiceInicial;
    while (actual != null) {
      actual.index = indice++;
      actual = actual.siguiente;
    }
  }

  void eliminarPares() {
    Node<T> actual = cabeza;

    while (actual.siguiente != null) {
      if (actual.index % 2 == 0 || actual.index == 0) {
        eliminar(actual.dato);
      }
      actual = actual.siguiente;
    }
  }

  @Override
  public String toString() {
    return "aa";
  }
}