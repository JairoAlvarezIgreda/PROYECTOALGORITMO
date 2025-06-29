package com.udemy.backend.api.response.core.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.response.core.adapter.out.repository.ResponseRepository;
import com.udemy.backend.api.response.core.application.port.FindResponsePort;
import com.udemy.backend.api.response.core.application.port.UpdateResponsePort;
import com.udemy.backend.api.response.core.domain.model.Response;
import com.udemy.backend.api.user.core.application.port.FindUserPort;
import com.udemy.backend.api.user.core.domain.model.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class UpdateResponseUseCase implements UpdateResponsePort {
  private final ResponseRepository responseRepository;
  private final FindResponsePort findResponsePort;
  private final FindUserPort findUserPort;

  @Override
  public Response changeMessage(Long id, String message) {
    Response response = findResponsePort.getById(id).orElseThrow(() -> new RuntimeException("La respuesta no existe"));

    response.setMessage(message);

    return responseRepository.update(response);
  }

  @Override
  public Response changeRespondedBy(Long id, Long userId) {
    Response response = findResponsePort.getById(id).orElseThrow(() -> new RuntimeException("La respuesta no existe"));

    User user = findUserPort.getById(userId).orElseThrow(() -> new RuntimeException("El usuario no existe"));

    response.setRespondedBy(user);

    return responseRepository.update(response);
  }
}
