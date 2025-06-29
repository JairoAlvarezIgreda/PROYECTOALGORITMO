package com.udemy.backend.api.payment.core.application.port;

import com.udemy.backend.api.payment.core.domain.model.Payment;
import com.udemy.backend.api.payment.core.domain.model.enums.PaymentStatus;

public interface UpdatePaymentPort {
  Payment changeMethod(Long id, String method);

  Payment changeAmount(Long id, Double amount);

  Payment changeStatus(Long id, PaymentStatus status);
}
