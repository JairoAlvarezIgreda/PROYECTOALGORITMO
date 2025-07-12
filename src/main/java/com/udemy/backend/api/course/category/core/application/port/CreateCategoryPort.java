package com.udemy.backend.api.course.category.core.application.port;

import com.udemy.backend.api.course.category.core.domain.model.Category;
import com.udemy.backend.api.course.category.core.domain.request.CreateCategoryRequest;

public interface CreateCategoryPort {
  Category create(CreateCategoryRequest request);
}
