package com.udemy.backend.api.response.core.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.response.core.adapter.out.repository.ResponseRepository;
import com.udemy.backend.api.response.core.application.port.DeleteResponsePort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class DeleteResponseUseCase implements DeleteResponsePort {
  private final ResponseRepository responseRepository;

  @Override
  public void deleteById(Long id) {
    responseRepository.deleteById(id);
  }
}
