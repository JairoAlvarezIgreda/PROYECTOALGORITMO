package com.udemy.backend.api.course.category.core.domain.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public final class CreateCategoryRequest {
  private String name;
}
