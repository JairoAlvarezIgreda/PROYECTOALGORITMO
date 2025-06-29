package com.udemy.backend.api.qualification.core.application.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.course.core.application.port.in.FindCoursePort;
import com.udemy.backend.api.course.core.domain.model.Course;
import com.udemy.backend.api.qualification.core.adapter.out.repository.QualificationRepository;
import com.udemy.backend.api.qualification.core.application.port.CreateQualificationPort;
import com.udemy.backend.api.qualification.core.domain.model.Qualification;
import com.udemy.backend.api.qualification.core.domain.request.CreateQualificationRequest;
import com.udemy.backend.api.user.core.application.port.FindUserPort;
import com.udemy.backend.api.user.core.domain.model.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class CreateQualificationUseCase implements CreateQualificationPort {
  private final QualificationRepository qualificationRepository;
  private final FindUserPort findUserPort;
  private final FindCoursePort findCoursePort;

  @Override
  public Qualification create(CreateQualificationRequest request) {
    User user = findUserPort.getById(request.getStudentId())
        .orElseThrow(() -> new RuntimeException("El usuario no existe"));

    Course course = findCoursePort.getById(request.getCourseId())
        .orElseThrow(() -> new RuntimeException("El curso no existe"));

    Qualification qualification = Qualification
        .builder()
        .student(user)
        .course(course)
        .score(request.getScore())
        .comment(request.getComment())
        .createdAt(LocalDateTime.now())
        .build();

    return qualificationRepository.save(qualification);
  }
}
