package com.udemy.backend.api.course.module.core.domain.model;

import com.udemy.backend.api.course.core.domain.model.Course;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Module {

  private Long id;
  private Course course;
  private String title;
  private String description;
  private Integer order;
}
