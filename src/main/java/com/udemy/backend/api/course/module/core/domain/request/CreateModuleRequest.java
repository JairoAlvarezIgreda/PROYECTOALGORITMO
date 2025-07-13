package com.udemy.backend.api.course.module.core.domain.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public final class CreateModuleRequest {
  private Long courseId;
  private String title;
  private String description;
  private Integer order;
  private Long duration;
}
