package com.udemy.backend.api.user.core.application.port;

import com.udemy.backend.api.user.core.domain.model.User;
import com.udemy.backend.api.user.core.domain.request.CreateUserRequest;

public interface CreateUserPort {
  User create(CreateUserRequest request);
}
