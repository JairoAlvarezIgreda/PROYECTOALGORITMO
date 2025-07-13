package com.udemy.backend.api.course.module.core.application.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.course.core.application.port.in.FindCoursePort;
import com.udemy.backend.api.course.core.domain.model.Course;
import com.udemy.backend.api.course.module.core.adapter.out.repository.ModuleRepository;
import com.udemy.backend.api.course.module.core.application.port.FindModulePort;
import com.udemy.backend.api.course.module.core.domain.model.Module;
import com.udemy.backend.api.shared.domain.operator.ListE;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class FindModuleUseCase implements FindModulePort {
  private final ModuleRepository moduleRepository;
  private final FindCoursePort findCoursePort;

  @Override
  public ListE<Module> getAll() {
    return moduleRepository.findAll();
  }

  @Override
  public ListE<Module> getAllByCourseId(Long id) {
    Course course = findCoursePort.getById(id).orElseThrow(() -> new RuntimeException("El curso no existe"));
    log.info("Buscanding " + id);
    return moduleRepository.findAllBy(Module::getCourse, course);
  }

  @Override
  public Optional<Module> getById(Long id) {
    return moduleRepository.findById(id);
  }
}
