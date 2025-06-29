package com.udemy.backend.api.user.core.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.user.core.adapter.out.repository.UserRepository;
import com.udemy.backend.api.user.core.application.port.DeleteUserPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class DeleteUserUseCase implements DeleteUserPort {
  private final UserRepository userRepository;

  @Override
  public void deleteById(Long id) {
    userRepository.deleteById(id);
  }
}
