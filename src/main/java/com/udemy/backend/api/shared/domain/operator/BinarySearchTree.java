package com.udemy.backend.api.shared.domain.operator;

import java.util.Optional;
import java.util.function.Function;

public class BinarySearchTree<T, K extends Comparable<? super K>> {
  private final Function<T, K> keyExtractor;
  private TreeNode<T> root;

  public BinarySearchTree(Function<T, K> keyExtractor) {
    this.keyExtractor = keyExtractor;
  }

  private static class TreeNode<T> {
    T data;
    TreeNode<T> left, right;

    TreeNode(T data) {
      this.data = data;
    }
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

    K dataKey = keyExtractor.apply(data);
    K nodeKey = keyExtractor.apply(node.data);

    int cmp = dataKey.compareTo(nodeKey);

    if (cmp < 0) {
      node.left = insertRecursive(node.left, data);
    } else if (cmp > 0) {
      node.right = insertRecursive(node.right, data);
    } else {
      node.data = data;
    }

    return node;
  }

  public Optional<T> search(T target) {
    TreeNode<T> current = root;
    K targetKey = keyExtractor.apply(target);

    while (current != null) {
      K currentKey = keyExtractor.apply(current.data);
      int cmp = targetKey.compareTo(currentKey);

      if (cmp == 0) {
        return Optional.of(current.data);
      }

      current = (cmp < 0) ? current.left : current.right;
    }

    return Optional.empty();
  }

  public Optional<T> searchBy(Function<T, K> extractor, K expected) {
    TreeNode<T> current = root;

    while (current != null) {
      K currentKey = extractor.apply(current.data);
      int cmp = expected.compareTo(currentKey);

      if (cmp == 0)
        return Optional.of(current.data);
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

    K targetKey = keyExtractor.apply(target);
    K nodeKey = keyExtractor.apply(node.data);

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
