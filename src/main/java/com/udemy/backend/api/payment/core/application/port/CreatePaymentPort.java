package com.udemy.backend.api.payment.core.application.port;

import com.udemy.backend.api.payment.core.domain.model.Payment;
import com.udemy.backend.api.payment.core.domain.request.CreatePaymentRequest;

public interface CreatePaymentPort {
  Payment create(CreatePaymentRequest request);
}
