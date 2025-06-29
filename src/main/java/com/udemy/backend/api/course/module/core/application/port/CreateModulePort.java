package com.udemy.backend.api.course.module.core.application.port;

import com.udemy.backend.api.course.module.core.domain.model.Module;
import com.udemy.backend.api.course.module.core.domain.request.CreateModuleRequest;

public interface CreateModulePort {
  Module create(CreateModuleRequest request);
}
