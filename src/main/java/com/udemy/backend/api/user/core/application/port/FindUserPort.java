package com.udemy.backend.api.user.core.application.port;

import java.util.Optional;

import com.udemy.backend.api.shared.domain.operator.ListE;
import com.udemy.backend.api.user.core.domain.model.User;
import com.udemy.backend.api.user.core.domain.request.LoginUserRequest;

public interface FindUserPort {
  ListE<User> getAll();

  Optional<User> getById(Long id);

  User login(LoginUserRequest request);
}
