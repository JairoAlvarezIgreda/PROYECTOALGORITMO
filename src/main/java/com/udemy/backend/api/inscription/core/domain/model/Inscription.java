package com.udemy.backend.api.inscription.core.domain.model;

import java.time.LocalDateTime;

import com.udemy.backend.api.course.core.domain.model.Course;
import com.udemy.backend.api.user.core.domain.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Inscription {

  private Long id;
  private User student;
  private Course course;
  private LocalDateTime inscriptionDate;
}
