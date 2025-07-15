package com.udemy.backend.api.inscription.core.domain.model;

import java.time.LocalDateTime;

import com.udemy.backend.api.course.core.domain.model.Course;
import com.udemy.backend.api.user.core.domain.model.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Inscription {
  private Long id;
  private User student;
  private Course course;
  private LocalDateTime inscriptionDate;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Inscription inscription = (Inscription) o;
    return id != null && id.equals(inscription.id);
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
