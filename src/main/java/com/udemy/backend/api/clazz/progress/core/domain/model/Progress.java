package com.udemy.backend.api.clazz.progress.core.domain.model;

import java.time.LocalDateTime;

import com.udemy.backend.api.clazz.core.domain.model.Clazz;
import com.udemy.backend.api.user.core.domain.model.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Progress {

  private Long id;
  private User student;
  private Clazz clazz;
  private Boolean completed;
  private LocalDateTime completionDate;
}
