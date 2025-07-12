package com.udemy.backend.api.course.category.core.application.port;

import java.util.Optional;

import com.udemy.backend.api.course.category.core.domain.model.Category;
import com.udemy.backend.api.shared.domain.operator.ListE;

public interface FindCategoryPort {
  ListE<Category> getAll();

  Optional<Category> getById(Long id);

  Optional<Category> getByName(String name);
}
