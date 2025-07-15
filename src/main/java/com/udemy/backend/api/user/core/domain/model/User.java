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
  private String lastName;
  private String email;
  private String password;
  private UserRole role;
  private LocalDateTime createdAt;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    User user = (User) o;
    return id != null && id.equals(user.id);
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
