package com.udemy.backend.api.payment.core.domain.request;

import lombok.Getter;

@Getter
public class CreatePaymentRequest {
  private Long userId;
  private Long courseId;
  private String method;
  private Double amount;
}
