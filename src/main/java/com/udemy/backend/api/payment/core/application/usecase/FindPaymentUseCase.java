package com.udemy.backend.api.payment.core.application.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.payment.core.adapter.out.repository.PaymentRepository;
import com.udemy.backend.api.payment.core.application.port.FindPaymentPort;
import com.udemy.backend.api.payment.core.domain.model.Payment;
import com.udemy.backend.api.shared.domain.operator.ListE;
import com.udemy.backend.api.user.core.application.port.FindUserPort;
import com.udemy.backend.api.user.core.domain.model.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class FindPaymentUseCase implements FindPaymentPort {
  private final PaymentRepository paymentRepository;
  private final FindUserPort findUserPort;

  @Override
  public ListE<Payment> getAll() {
    return paymentRepository.findAll();
  }

  @Override
  public ListE<Payment> getAllByUserId(Long id) {
    User user = findUserPort.getById(id).orElseThrow(() -> new RuntimeException("El usuario no existe"));
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Optional<Payment> getById(Long id) {
    return paymentRepository.findById(id);
  }
}
