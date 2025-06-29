package com.udemy.backend.api.course.module.core.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.course.module.core.adapter.out.repository.ModuleRepository;
import com.udemy.backend.api.course.module.core.application.port.DeleteModulePort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class DeleteModuleUseCase implements DeleteModulePort {
  private final ModuleRepository moduleRepository;

  @Override
  public void deleteById(Long id) {
    moduleRepository.deleteById(id);
  }
}
