package com.udemy.backend.api.user.core.application.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.shared.domain.operator.ListE;
import com.udemy.backend.api.user.core.adapter.out.repository.UserRepository;
import com.udemy.backend.api.user.core.application.port.FindUserPort;
import com.udemy.backend.api.user.core.domain.model.User;

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
}
