package com.udemy.backend.api.inscription.core.application.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.course.core.application.port.in.FindCoursePort;
import com.udemy.backend.api.course.core.domain.model.Course;
import com.udemy.backend.api.inscription.core.adapter.out.repository.InscriptionRepository;
import com.udemy.backend.api.inscription.core.application.port.CreateInscriptionPort;
import com.udemy.backend.api.inscription.core.domain.model.Inscription;
import com.udemy.backend.api.inscription.core.domain.request.CreateInscriptionRequest;
import com.udemy.backend.api.user.core.application.port.FindUserPort;
import com.udemy.backend.api.user.core.domain.model.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class CreateInscriptionUseCase implements CreateInscriptionPort {
  private final InscriptionRepository inscriptionRepository;
  private final FindUserPort findUserPort;
  private final FindCoursePort findCoursePort;

  @Override
  public Inscription create(CreateInscriptionRequest request) {
    User user = findUserPort.getById(request.getUserId())
        .orElseThrow(() -> new RuntimeException("El usuario no existe"));

    Course course = findCoursePort.getById(request.getCourseId())
        .orElseThrow(() -> new RuntimeException("El curso no existe"));

    Inscription inscription = Inscription
        .builder()
        .student(user)
        .course(course)
        .inscriptionDate(LocalDateTime.now())
        .build();

    return inscriptionRepository.save(inscription);
  }
}
