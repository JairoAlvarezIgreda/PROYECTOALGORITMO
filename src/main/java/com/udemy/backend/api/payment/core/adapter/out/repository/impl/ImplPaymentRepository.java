package com.udemy.backend.api.payment.core.adapter.out.repository.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.udemy.backend.api.payment.core.adapter.out.repository.PaymentRepository;
import com.udemy.backend.api.payment.core.domain.model.Payment;
import com.udemy.backend.api.shared.application.repository.GlobalBasicRepository;

@Primary
@Repository
public class ImplPaymentRepository extends GlobalBasicRepository<Payment, Long> implements PaymentRepository {
  public ImplPaymentRepository() {
    super(Payment::getId);
  }
}
