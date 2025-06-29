package com.udemy.backend.api.payment.core.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.payment.core.adapter.out.repository.PaymentRepository;
import com.udemy.backend.api.payment.core.application.port.DeletePaymentPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class DeletePaymentUseCase implements DeletePaymentPort {
  private final PaymentRepository paymentRepository;

  @Override
  public void deleteById(Long id) {
    paymentRepository.deleteById(id);
  }

}
