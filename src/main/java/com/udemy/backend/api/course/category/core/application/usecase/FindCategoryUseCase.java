package com.udemy.backend.api.course.category.core.application.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.course.category.core.adapter.out.repository.CategoryRepository;
import com.udemy.backend.api.course.category.core.application.port.FindCategoryPort;
import com.udemy.backend.api.course.category.core.domain.model.Category;
import com.udemy.backend.api.shared.domain.operator.ListE;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class FindCategoryUseCase implements FindCategoryPort {
  private final CategoryRepository categoryRepository;

  @Override
  public ListE<Category> getAll() {
    return categoryRepository.findAll();
  }

  @Override
  public Optional<Category> getById(Long id) {
    return categoryRepository.findById(id);
  }

  @Override
  public Optional<Category> getByName(String name) {
    return categoryRepository.findBy(Category::getName, name);
  }
}
