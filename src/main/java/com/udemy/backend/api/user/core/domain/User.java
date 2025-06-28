package com.udemy.backend.api.user.core.domain;

import java.time.LocalDateTime;

import com.udemy.backend.api.user.core.domain.enums.UserRole;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {

  private Long id;
  private String name;
  private String email;
  private String password;
  private UserRole role;
  private LocalDateTime createdAt;
}
