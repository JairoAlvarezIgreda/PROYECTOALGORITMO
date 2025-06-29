package com.udemy.backend.api.comment.core.domain.model;

import java.time.LocalDateTime;

import com.udemy.backend.api.clazz.core.domain.model.Clazz;
import com.udemy.backend.api.course.core.domain.model.Course;
import com.udemy.backend.api.user.core.domain.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Comment {
  private Long id;
  private User user;
  private Course course;
  private Clazz clazz;
  private String content;
  private LocalDateTime createdAt;
}
