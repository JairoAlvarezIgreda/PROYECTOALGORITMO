package com.udemy.backend.api.curso.module.core.domain.model;

import com.udemy.backend.api.curso.core.domain.model.Course;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Module {

  private Long id;
  private Course course;
  private String title;
  private String description;
  private Integer order;
}
