package com.udemy.backend.api.qualification.core.domain.request;

import lombok.Getter;

@Getter
public final class CreateQualificationRequest {
  private Long studentId;
  private Long courseId;
  private Integer score;
  private String comment;
}
