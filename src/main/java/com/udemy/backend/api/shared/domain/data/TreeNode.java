package com.udemy.backend.api.shared.domain.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode<T> {
  public T data;
  public TreeNode<T> left, right;

  public TreeNode(T data) {
    this.data = data;
  }
}
