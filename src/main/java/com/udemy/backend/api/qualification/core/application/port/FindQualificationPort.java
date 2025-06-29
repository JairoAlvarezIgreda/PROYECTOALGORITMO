package com.udemy.backend.api.qualification.core.application.port;

import java.util.Optional;

import com.udemy.backend.api.qualification.core.domain.model.Qualification;
import com.udemy.backend.api.shared.domain.operator.ListE;

public interface FindQualificationPort {
  ListE<Qualification> getAll();

  Optional<Qualification> getById(Long id);

  Optional<Qualification> getByUserIdAndCourseId(Long userId, Long courseId);
}
