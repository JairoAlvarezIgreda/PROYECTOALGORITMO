package com.udemy.backend.api.inscription.core.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.inscription.core.adapter.out.repository.InscriptionRepository;
import com.udemy.backend.api.inscription.core.application.port.DeleteInscriptionPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class DeleteInscriptionUseCase implements DeleteInscriptionPort {
  private final InscriptionRepository inscriptionRepository;

  @Override
  public void deleteById(Long id) {
    inscriptionRepository.deleteById(id);
  }
}
