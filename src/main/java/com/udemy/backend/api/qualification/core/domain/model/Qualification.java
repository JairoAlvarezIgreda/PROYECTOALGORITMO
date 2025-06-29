package com.udemy.backend.api.qualification.core.domain.model;

import java.time.LocalDateTime;

import com.udemy.backend.api.curso.core.domain.model.Course;
import com.udemy.backend.api.user.core.domain.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Qualification {
  private Long id;
  private User student;
  private Course course;
  private Integer score;
  private String comment;
  private LocalDateTime createdAt;
}
