package com.udemy.backend.api.qualification.core.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.qualification.core.adapter.out.repository.QualificationRepository;
import com.udemy.backend.api.qualification.core.application.port.DeleteQualificationPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class DeleteQualificationUseCase implements DeleteQualificationPort {
  private final QualificationRepository qualificationRepository;

  @Override
  public void deleteById(Long id) {
    qualificationRepository.deleteById(id);
  }
}
