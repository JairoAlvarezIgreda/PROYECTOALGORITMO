package com.udemy.backend.api.user.core.domain.request;

import lombok.Getter;

@Getter
public final class LoginUserRequest {
  private String email;
  private String password;
}
