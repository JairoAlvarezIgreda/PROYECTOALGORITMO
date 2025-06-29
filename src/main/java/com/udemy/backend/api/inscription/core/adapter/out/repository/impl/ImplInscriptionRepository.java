package com.udemy.backend.api.inscription.core.adapter.out.repository.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.udemy.backend.api.inscription.core.adapter.out.repository.InscriptionRepository;
import com.udemy.backend.api.inscription.core.domain.model.Inscription;
import com.udemy.backend.api.shared.application.repository.GlobalBasicRepository;

@Primary
@Repository
public class ImplInscriptionRepository extends GlobalBasicRepository<Inscription, Long>
    implements InscriptionRepository {
  public ImplInscriptionRepository() {
    super(Inscription::getId);
  }
}
