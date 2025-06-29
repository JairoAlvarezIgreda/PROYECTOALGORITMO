package com.udemy.backend.api.user.core.application.port;

import com.udemy.backend.api.user.core.domain.model.User;

public interface UpdateUserPort {
  User changeName(Long id, String name);

  User changeEmail(Long id, String email);

  User changePassword(Long id, String password);

  User changeRole(Long id, String role);
}
