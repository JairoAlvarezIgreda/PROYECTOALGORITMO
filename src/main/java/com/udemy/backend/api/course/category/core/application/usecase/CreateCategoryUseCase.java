package com.udemy.backend.api.course.category.core.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.course.category.core.adapter.out.repository.CategoryRepository;
import com.udemy.backend.api.course.category.core.application.port.CreateCategoryPort;
import com.udemy.backend.api.course.category.core.domain.model.Category;
import com.udemy.backend.api.course.category.core.domain.request.CreateCategoryRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class CreateCategoryUseCase implements CreateCategoryPort {
  private final CategoryRepository categoryRepository;

  @Override
  public Category create(CreateCategoryRequest request) {
    Category category = Category
        .builder()
        .name(request.getName())
        .build();

    return categoryRepository.save(category);
  }
}
