package com.udemy.backend.api.course.category.core.adapter.out.repository.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.udemy.backend.api.course.category.core.adapter.out.repository.CategoryRepository;
import com.udemy.backend.api.course.category.core.domain.model.Category;
import com.udemy.backend.api.shared.application.repository.GlobalBasicRepository;

@Primary
@Repository
public class ImplCategoryRepository extends GlobalBasicRepository<Category, Long> implements CategoryRepository {
  public ImplCategoryRepository() {
    super(Category::getId);
  }
}
