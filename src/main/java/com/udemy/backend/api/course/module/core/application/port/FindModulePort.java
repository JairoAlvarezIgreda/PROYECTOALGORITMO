package com.udemy.backend.api.course.module.core.application.port;

import java.util.Optional;

import com.udemy.backend.api.course.module.core.domain.model.Module;
import com.udemy.backend.api.shared.domain.operator.ListE;

public interface FindModulePort {
  ListE<Module> getAll();

  ListE<Module> getAllByCourseId(Long id);

  Optional<Module> getById(Long id);
}
