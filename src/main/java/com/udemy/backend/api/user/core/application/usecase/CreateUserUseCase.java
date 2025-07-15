package com.udemy.backend.api.user.core.application.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.user.core.adapter.out.repository.UserRepository;
import com.udemy.backend.api.user.core.application.port.CreateUserPort;
import com.udemy.backend.api.user.core.domain.model.User;
import com.udemy.backend.api.user.core.domain.model.enums.UserRole;
import com.udemy.backend.api.user.core.domain.request.CreateUserRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class CreateUserUseCase implements CreateUserPort {
  private final UserRepository userRepository;
  private Long idGenerator = 0L;

  @Override
  public User create(CreateUserRequest request) {
    idGenerator++;

    User newUser = User
        .builder()
        .id(idGenerator)
        .name(request.getName())
        .lastName(request.getLastName())
        .email(request.getEmail())
        .password(request.getPassword())
        .role(UserRole.STUDENT)
        .createdAt(LocalDateTime.now())
        .build();

    return userRepository.save(newUser);
  }
}
