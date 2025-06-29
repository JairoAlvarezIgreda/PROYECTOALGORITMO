package com.udemy.backend.api.inscription.core.application.port;

import java.util.Optional;

import com.udemy.backend.api.inscription.core.domain.model.Inscription;
import com.udemy.backend.api.shared.domain.operator.ListE;

public interface FindInscriptionPort {
  ListE<Inscription> getAll();

  ListE<Inscription> getAllByUserId(Long id);

  Optional<Inscription> getById(Long id);
}
