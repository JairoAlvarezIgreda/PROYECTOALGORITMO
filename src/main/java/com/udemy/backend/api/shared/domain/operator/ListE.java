package com.udemy.backend.api.shared.domain.operator;

import java.lang.reflect.Field;
import java.util.Optional;
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
  public T add(T data) {
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
    return newNode.getData();
  }

  public <R> T update(T data, Function<T, R> idExtractor) {
    R id = idExtractor.apply(data);

    Node<T> current = head;
    while (current != null) {
      T currentData = current.getData();
      if (idExtractor.apply(currentData).equals(id)) {
        mergeNonNullFields(currentData, data);
        return currentData;
      }
      current = current.getNext();
    }

    throw new RuntimeException("La entidad no existe con ID: " + id);
  }

  public <R> Optional<T> getBy(Function<T, R> idExtractor, R id) {
    Node<T> current = head;

    while (current != null) {
      if (idExtractor.apply(current.getData()).equals(id)) {
        return Optional.of(current.getData());
      }
      current = current.getNext();
    }

    return Optional.empty();
  }

  public <R> void deleteBy(Function<T, R> idExtractor, R id) {
    if (head == null)
      return;

    if (idExtractor.apply(head.getData()).equals(id)) {
      head = head.getNext();
      return;
    }

    Node<T> tmp = head;
    while (tmp.getNext() != null && !idExtractor.apply(tmp.getNext().getData()).equals(id)) {
      tmp = tmp.getNext();
    }

    if (tmp.getNext() == null)
      return;

    tmp.setNext(tmp.getNext().getNext());
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
      System.out.print(tmp.getData().toString() + ":" + " -> ");
      tmp = tmp.getNext();
    }
    System.out.println("null");
  }

  void mergeNonNullFields(T target, T source) {
    try {
      for (Field field : source.getClass().getDeclaredFields()) {
        field.setAccessible(true);
        Object value = field.get(source);
        if (value != null && !"id".equalsIgnoreCase(field.getName())) {
          field.set(target, value);
        }
      }
    } catch (IllegalAccessException e) {
      throw new RuntimeException("Error actualizando campos no nulos", e);
    }
  }

}