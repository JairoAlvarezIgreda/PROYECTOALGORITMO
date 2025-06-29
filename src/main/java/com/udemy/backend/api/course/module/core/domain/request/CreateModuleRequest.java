package com.udemy.backend.api.course.module.core.domain.request;

import lombok.Getter;

@Getter
public final class CreateModuleRequest {
  private Long courseId;
  private String title;
  private String description;
  private Integer order;
}
