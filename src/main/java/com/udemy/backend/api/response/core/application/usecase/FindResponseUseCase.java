package com.udemy.backend.api.response.core.application.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.response.core.adapter.out.repository.ResponseRepository;
import com.udemy.backend.api.response.core.application.port.FindResponsePort;
import com.udemy.backend.api.response.core.domain.model.Response;
import com.udemy.backend.api.shared.domain.operator.ListE;
import com.udemy.backend.api.ticket.core.application.port.FindTicketPort;
import com.udemy.backend.api.ticket.core.domain.model.Ticket;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class FindResponseUseCase implements FindResponsePort {
  private final ResponseRepository responseRepository;
  private final FindTicketPort findTicketPort;

  @Override
  public ListE<Response> getAll() {
    return responseRepository.findAll();
  }

  @Override
  public Optional<Response> getById(Long id) {
    return responseRepository.findById(id);
  }

  @Override
  public Optional<Response> getByTicketId(Long id) {
    Ticket ticket = findTicketPort.getById(id).orElseThrow(() -> new RuntimeException("El ticket no existe"));

    return responseRepository.findBy(Response::getTicket, ticket);
  }
}
