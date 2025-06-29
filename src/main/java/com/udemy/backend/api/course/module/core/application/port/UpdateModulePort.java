package com.udemy.backend.api.course.module.core.application.port;

import com.udemy.backend.api.course.module.core.domain.model.Module;

public interface UpdateModulePort {
  Module changeTitle(Long id, String title);

  Module changeDescription(Long id, String description);

  Module changeOrder(Long id, Integer order);
}
