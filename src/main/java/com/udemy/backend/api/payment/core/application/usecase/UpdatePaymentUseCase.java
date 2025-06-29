package com.udemy.backend.api.payment.core.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.payment.core.adapter.out.repository.PaymentRepository;
import com.udemy.backend.api.payment.core.application.port.FindPaymentPort;
import com.udemy.backend.api.payment.core.application.port.UpdatePaymentPort;
import com.udemy.backend.api.payment.core.domain.model.Payment;
import com.udemy.backend.api.payment.core.domain.model.enums.PaymentMethod;
import com.udemy.backend.api.payment.core.domain.model.enums.PaymentStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class UpdatePaymentUseCase implements UpdatePaymentPort {
  private final PaymentRepository paymentRepository;
  private final FindPaymentPort findPaymentPort;

  @Override
  public Payment changeAmount(Long id, Double amount) {
    Payment payment = findPaymentPort.getById(id).orElseThrow(() -> new RuntimeException("El pago no existe"));

    payment.setAmount(amount);

    return paymentRepository.update(payment);
  }

  @Override
  public Payment changeMethod(Long id, String method) {
    Payment payment = findPaymentPort.getById(id).orElseThrow(() -> new RuntimeException("El pago no existe"));

    payment.setMethod(PaymentMethod.valueOf(method));

    return paymentRepository.update(payment);
  }

  @Override
  public Payment changeStatus(Long id, PaymentStatus status) {
    Payment payment = findPaymentPort.getById(id).orElseThrow(() -> new RuntimeException("El pago no existe"));

    payment.setStatus(status);

    return paymentRepository.update(payment);
  }

}
