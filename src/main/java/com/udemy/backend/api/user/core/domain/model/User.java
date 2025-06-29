package com.udemy.backend.api.user.core.domain.model;

import java.time.LocalDateTime;

import com.udemy.backend.api.user.core.domain.model.enums.UserRole;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {

  private Long id;
  private String name;
  private String email;
  private String password;
  private UserRole role;
  private LocalDateTime createdAt;
}
