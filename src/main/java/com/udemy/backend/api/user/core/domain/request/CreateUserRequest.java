package com.udemy.backend.api.user.core.domain.request;

import lombok.Getter;

@Getter
public final class CreateUserRequest {
  private String name;
  private String email;
  private String password;
  private String role;
}
