package com.udemy.backend.api.payment.core.application.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.course.core.application.port.in.FindCoursePort;
import com.udemy.backend.api.course.core.domain.model.Course;
import com.udemy.backend.api.payment.core.adapter.out.repository.PaymentRepository;
import com.udemy.backend.api.payment.core.application.port.CreatePaymentPort;
import com.udemy.backend.api.payment.core.domain.model.Payment;
import com.udemy.backend.api.payment.core.domain.model.enums.PaymentMethod;
import com.udemy.backend.api.payment.core.domain.model.enums.PaymentStatus;
import com.udemy.backend.api.payment.core.domain.request.CreatePaymentRequest;
import com.udemy.backend.api.user.core.application.port.FindUserPort;
import com.udemy.backend.api.user.core.domain.model.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class CreatePaymentUseCase implements CreatePaymentPort {
  private final PaymentRepository paymentRepository;
  private final FindUserPort findUserPort;
  private final FindCoursePort findCoursePort;

  @Override
  public Payment create(CreatePaymentRequest request) {
    User user = findUserPort.getById(request.getUserId())
        .orElseThrow(() -> new RuntimeException("El usuario no existe"));

    Course course = findCoursePort.getById(request.getCourseId())
        .orElseThrow(() -> new RuntimeException("El curso no existe"));

    Payment payment = Payment
        .builder()
        .user(user)
        .course(course)
        .method(PaymentMethod.valueOf(request.getMethod()))
        .amount(request.getAmount())
        .createdAt(LocalDateTime.now())
        .status(PaymentStatus.PENDING)
        .build();

    return paymentRepository.save(payment);
  }

}
