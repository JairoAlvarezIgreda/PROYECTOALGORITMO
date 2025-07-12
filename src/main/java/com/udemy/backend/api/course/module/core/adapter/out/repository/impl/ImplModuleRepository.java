package com.udemy.backend.api.course.module.core.adapter.out.repository.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.udemy.backend.api.course.module.core.adapter.out.repository.ModuleRepository;
import com.udemy.backend.api.course.module.core.domain.model.Module;
import com.udemy.backend.api.shared.application.repository.GlobalBasicRepository;

@Primary
@Repository
public class ImplModuleRepository
    extends GlobalBasicRepository<Module, Long> implements ModuleRepository {
  public ImplModuleRepository() {
    super(Module::getId);
  }
}
