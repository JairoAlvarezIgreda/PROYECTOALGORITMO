package com.udemy.backend.api.payment.core.domain.model;

import java.time.LocalDateTime;

import com.udemy.backend.api.course.core.domain.model.Course;
import com.udemy.backend.api.payment.core.domain.model.enums.PaymentMethod;
import com.udemy.backend.api.payment.core.domain.model.enums.PaymentStatus;
import com.udemy.backend.api.user.core.domain.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Payment {

  private Long id;
  private User user;
  private Course course;
  private PaymentMethod method;
  private Double amount;
  private LocalDateTime createdAt;
  private PaymentStatus status;
}
