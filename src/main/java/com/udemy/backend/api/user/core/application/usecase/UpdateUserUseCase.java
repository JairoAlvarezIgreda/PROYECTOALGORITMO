package com.udemy.backend.api.user.core.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.user.core.adapter.out.repository.UserRepository;
import com.udemy.backend.api.user.core.application.port.FindUserPort;
import com.udemy.backend.api.user.core.application.port.UpdateUserPort;
import com.udemy.backend.api.user.core.domain.model.User;
import com.udemy.backend.api.user.core.domain.model.enums.UserRole;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class UpdateUserUseCase implements UpdateUserPort {
  private final UserRepository userRepository;
  private final FindUserPort findUserPort;

  @Override
  public User changeName(Long id, String name) {
    User user = findUserPort.getById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    user.setName(name);

    return userRepository.update(user);
  }

  @Override
  public User changeEmail(Long id, String email) {
    User user = findUserPort.getById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    user.setEmail(email);

    return userRepository.update(user);
  }

  @Override
  public User changePassword(Long id, String password) {
    User user = findUserPort.getById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    user.setPassword(password);

    return userRepository.update(user);
  }

  @Override
  public User changeRole(Long id, String role) {
    User user = findUserPort.getById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    user.setRole(UserRole.valueOf(role));

    return userRepository.update(user);
  }
}
