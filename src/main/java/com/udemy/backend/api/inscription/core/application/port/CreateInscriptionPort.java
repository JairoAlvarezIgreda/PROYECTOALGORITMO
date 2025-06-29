package com.udemy.backend.api.inscription.core.application.port;

import com.udemy.backend.api.inscription.core.domain.model.Inscription;
import com.udemy.backend.api.inscription.core.domain.request.CreateInscriptionRequest;

public interface CreateInscriptionPort {
  Inscription create(CreateInscriptionRequest request);
}
