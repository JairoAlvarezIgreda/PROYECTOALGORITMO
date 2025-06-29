package com.udemy.backend.api.qualification.core.application.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.qualification.core.adapter.out.repository.QualificationRepository;
import com.udemy.backend.api.qualification.core.application.port.FindQualificationPort;
import com.udemy.backend.api.qualification.core.domain.model.Qualification;
import com.udemy.backend.api.shared.domain.operator.ListE;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class FindQualificationUseCase implements FindQualificationPort {
  private final QualificationRepository qualificationRepository;

  @Override
  public ListE<Qualification> getAll() {
    return qualificationRepository.findAll();
  }

  @Override
  public Optional<Qualification> getById(Long id) {
    return qualificationRepository.findById(id);
  }

  @Override
  public Optional<Qualification> getByUserIdAndCourseId(Long userId, Long courseId) {
    // TODO Auto-generated method stub
    return Optional.empty();
  }
}
