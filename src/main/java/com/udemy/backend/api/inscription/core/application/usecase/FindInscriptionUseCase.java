package com.udemy.backend.api.inscription.core.application.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.inscription.core.adapter.out.repository.InscriptionRepository;
import com.udemy.backend.api.inscription.core.application.port.FindInscriptionPort;
import com.udemy.backend.api.inscription.core.domain.model.Inscription;
import com.udemy.backend.api.shared.domain.operator.ListE;
import com.udemy.backend.api.user.core.application.port.FindUserPort;
import com.udemy.backend.api.user.core.domain.model.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class FindInscriptionUseCase implements FindInscriptionPort {
  private final InscriptionRepository inscriptionRepository;
  private final FindUserPort findUserPort;

  @Override
  public ListE<Inscription> getAll() {
    return inscriptionRepository.findAll();
  }

  @Override
  public ListE<Inscription> getAllByUserId(Long id) {
    User user = findUserPort.getById(id).orElseThrow(() -> new RuntimeException("El usuario no existe"));
    return inscriptionRepository.findAllBy(Inscription::getStudent, user);
  }

  @Override
  public Optional<Inscription> getById(Long id) {
    return inscriptionRepository.findById(id);
  }
}
