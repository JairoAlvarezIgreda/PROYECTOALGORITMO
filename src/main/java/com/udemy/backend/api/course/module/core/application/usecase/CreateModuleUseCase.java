package com.udemy.backend.api.course.module.core.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.course.core.application.port.in.FindCoursePort;
import com.udemy.backend.api.course.core.domain.model.Course;
import com.udemy.backend.api.course.module.core.adapter.out.repository.ModuleRepository;
import com.udemy.backend.api.course.module.core.application.port.CreateModulePort;
import com.udemy.backend.api.course.module.core.domain.model.Module;
import com.udemy.backend.api.course.module.core.domain.request.CreateModuleRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class CreateModuleUseCase implements CreateModulePort {
  private final ModuleRepository moduleRepository;
  private final FindCoursePort findCoursePort;

  @Override
  public Module create(CreateModuleRequest request) {
    Course course = findCoursePort.getById(request.getCourseId())
        .orElseThrow(() -> new RuntimeException("El curso no existe"));

    Module module = Module
        .builder()
        .course(course)
        .title(request.getTitle())
        .description(request.getDescription())
        .order(request.getOrder())
        .build();

    return moduleRepository.save(module);
  }
}
