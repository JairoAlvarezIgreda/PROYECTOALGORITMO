package com.udemy.backend.api.shared.domain.operator;

import java.util.function.Function;

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

  public int size() {
    Node<T> tmp = head;
    int size = 0;
    while (tmp != null) {
      size++;
      tmp = tmp.getNext();
    }
    return size;
  }

  public int getPosition(T data) {
    Node<T> tmp = head;
    int position = 0;

    while (tmp != null) {
      if (tmp.getData().equals(data))
        return position;
      tmp = tmp.getNext();
      position++;
    }

    return -1;
  }

  public void forEach(Function<T, T> func) {
    Node<T> tmp = head;
    while (tmp != null) {
      func.apply(tmp.getData());
      tmp = tmp.getNext();
    }
  }

  public ListE<T> map(Function<T, T> func) {
    ListE<T> newList = new ListE<T>();
    Node<T> tmp = head;

    while (tmp != null) {
      newList.add(func.apply(tmp.getData()));
      tmp = tmp.getNext();
    }

    return newList;
  }

  // Imprime la lista
  void printList() {
    Node<T> tmp = head;
    while (tmp != null) {
      System.out.print(tmp.getData().toString() + ":" + tmp.index.toString() + " -> ");
      tmp = tmp.getNext();
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
}