package com.udemy.backend.api.clazz.core.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Clazz {

  private Long id;
  private Module module;
  private String title;
  private String videoUrl;
  private Long duration;
  private Integer order;
}
