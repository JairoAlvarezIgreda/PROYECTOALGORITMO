package com.udemy.backend.api.shared.domain.operator;

import java.util.Optional;
import java.util.function.Function;

public class BinarySearchTree<T> {
  private static class TreeNode<T> {
    T data;
    TreeNode<T> left, right;

    TreeNode(T data) {
      this.data = data;
    }
  }

  private TreeNode<T> root;
  private final Function<T, Comparable<?>> keyExtractor;

  public BinarySearchTree(Function<T, Comparable<?>> keyExtractor) {
    this.keyExtractor = keyExtractor;
  }

  public void insert(T data) {
    if (data == null) {
      throw new IllegalArgumentException("No se puede insertar un valor nulo");
    }

    Comparable<?> key = keyExtractor.apply(data);
    if (key == null) {
      throw new IllegalArgumentException("El campo clave usado en el comparador no puede ser null: " + data);
    }

    root = insertRecursive(root, data);
  }

  private TreeNode<T> insertRecursive(TreeNode<T> node, T data) {
    if (node == null) {
      return new TreeNode<>(data);
    }

    Comparable<Object> dataKey = (Comparable<Object>) keyExtractor.apply(data);
    Object nodeKey = keyExtractor.apply(node.data);

    int cmp = dataKey.compareTo(nodeKey);

    if (cmp < 0) {
      node.left = insertRecursive(node.left, data);
    } else if (cmp > 0) {
      node.right = insertRecursive(node.right, data);
    } else {
      node.data = data; // Reemplaza si es igual
    }

    return node;
  }

  public Optional<T> search(T target) {
    TreeNode<T> current = root;
    Comparable<Object> targetKey = (Comparable<Object>) keyExtractor.apply(target);

    while (current != null) {
      Object currentKey = keyExtractor.apply(current.data);
      int cmp = targetKey.compareTo(currentKey);

      if (cmp == 0) {
        return Optional.of(current.data);
      }

      current = (cmp < 0) ? current.left : current.right;
    }

    return Optional.empty();
  }

  public void delete(T target) {
    root = deleteRecursive(root, target);
  }

  private TreeNode<T> deleteRecursive(TreeNode<T> node, T target) {
    if (node == null) {
      return null;
    }

    Comparable<Object> targetKey = (Comparable<Object>) keyExtractor.apply(target);
    Object nodeKey = keyExtractor.apply(node.data);

    int cmp = targetKey.compareTo(nodeKey);

    if (cmp < 0) {
      node.left = deleteRecursive(node.left, target);
    } else if (cmp > 0) {
      node.right = deleteRecursive(node.right, target);
    } else {
      if (node.left == null)
        return node.right;
      if (node.right == null)
        return node.left;

      TreeNode<T> minNode = findMin(node.right);
      node.data = minNode.data;
      node.right = deleteRecursive(node.right, minNode.data);
    }

    return node;
  }

  private TreeNode<T> findMin(TreeNode<T> node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
}
