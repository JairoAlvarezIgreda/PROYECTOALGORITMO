package com.udemy.backend.api.user.core.application.usecase;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.udemy.backend.api.shared.domain.exception.ErrorException;
import com.udemy.backend.api.shared.domain.operator.ListE;
import com.udemy.backend.api.user.core.adapter.out.repository.UserRepository;
import com.udemy.backend.api.user.core.application.port.FindUserPort;
import com.udemy.backend.api.user.core.domain.model.User;
import com.udemy.backend.api.user.core.domain.request.LoginUserRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class FindUserUseCase implements FindUserPort {
  private final UserRepository userRepository;

  @Override
  public ListE<User> getAll() {
    return userRepository.findAll();
  }

  @Override
  public Optional<User> getById(Long id) {
    return userRepository.findById(id);
  }

  @Override
  public User login(LoginUserRequest request) {
    User user = userRepository.findBy(User::getEmail, request.getEmail())
        .orElseThrow(() -> new ErrorException(HttpStatus.UNAUTHORIZED, "El usuario no existe"));

    if (!user.getPassword().equals(request.getPassword()))
      throw new ErrorException(HttpStatus.UNAUTHORIZED, "Contraseña incorrecta");

    return user;
  }

  @Override
  public Integer count() {
    return userRepository.findAll().size();
  }
}
