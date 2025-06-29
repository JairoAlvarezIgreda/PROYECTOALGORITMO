package com.udemy.backend.api.course.module.core.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.course.module.core.adapter.out.repository.ModuleRepository;
import com.udemy.backend.api.course.module.core.application.port.FindModulePort;
import com.udemy.backend.api.course.module.core.application.port.UpdateModulePort;
import com.udemy.backend.api.course.module.core.domain.model.Module;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class UpdateModuleUseCase implements UpdateModulePort {
  private final ModuleRepository moduleRepository;
  private final FindModulePort findModulePort;

  @Override
  public Module changeDescription(Long id, String description) {
    Module module = findModulePort.getById(id).orElseThrow(() -> new RuntimeException("El modulo no existe"));

    module.setDescription(description);

    return moduleRepository.update(module);
  }

  @Override
  public Module changeOrder(Long id, Integer order) {
    Module module = findModulePort.getById(id).orElseThrow(() -> new RuntimeException("El modulo no existe"));

    module.setOrder(order);

    return moduleRepository.update(module);
  }

  @Override
  public Module changeTitle(Long id, String title) {
    Module module = findModulePort.getById(id).orElseThrow(() -> new RuntimeException("El modulo no existe"));

    module.setTitle(title);

    return moduleRepository.update(module);
  }
}
