package com.udemy.backend.api.payment.core.application.port;

import java.util.Optional;

import com.udemy.backend.api.payment.core.domain.model.Payment;
import com.udemy.backend.api.shared.domain.operator.ListE;

public interface FindPaymentPort {
  ListE<Payment> getAll();

  ListE<Payment> getAllByUserId(Long id);

  Optional<Payment> getById(Long id);
}
