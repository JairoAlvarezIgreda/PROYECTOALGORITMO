package com.udemy.backend.api.payment.core.adapter.out.repository;

import com.udemy.backend.api.payment.core.domain.model.Payment;
import com.udemy.backend.api.shared.domain.repository.BasicRepository;

public interface PaymentRepository extends BasicRepository<Payment, Long> {
}
