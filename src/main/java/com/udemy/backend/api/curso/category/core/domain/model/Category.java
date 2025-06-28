package com.udemy.backend.api.curso.category.core.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Category {

  private Long id;
  private String name;
}
