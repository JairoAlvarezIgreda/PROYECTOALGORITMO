package com.udemy.backend.api.qualification.core.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.qualification.core.adapter.out.repository.QualificationRepository;
import com.udemy.backend.api.qualification.core.application.port.FindQualificationPort;
import com.udemy.backend.api.qualification.core.application.port.UpdateQualificationPort;
import com.udemy.backend.api.qualification.core.domain.model.Qualification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class UpdateQualificationUseCase implements UpdateQualificationPort {
  private final QualificationRepository qualificationRepository;
  private final FindQualificationPort findQualificationPort;

  @Override
  public Qualification changeComment(Long id, String comment) {
    Qualification qualification = findQualificationPort.getById(id)
        .orElseThrow(() -> new RuntimeException("La calificación no existe"));

    qualification.setComment(comment);

    return qualificationRepository.update(qualification);
  }

  @Override
  public Qualification changeScore(Long id, Integer score) {
    Qualification qualification = findQualificationPort.getById(id)
        .orElseThrow(() -> new RuntimeException("La calificación no existe"));

    qualification.setScore(score);

    return qualificationRepository.update(qualification);
  }
}
