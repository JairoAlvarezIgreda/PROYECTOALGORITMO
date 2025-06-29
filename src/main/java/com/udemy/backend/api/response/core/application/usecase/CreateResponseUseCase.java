package com.udemy.backend.api.response.core.application.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.response.core.adapter.out.repository.ResponseRepository;
import com.udemy.backend.api.response.core.application.port.CreateResponsePort;
import com.udemy.backend.api.response.core.domain.model.Response;
import com.udemy.backend.api.response.core.domain.request.CreateResponseRequest;
import com.udemy.backend.api.ticket.core.application.port.FindTicketPort;
import com.udemy.backend.api.ticket.core.application.port.UpdateTicketPort;
import com.udemy.backend.api.ticket.core.domain.model.Ticket;
import com.udemy.backend.api.ticket.core.domain.model.enums.TicketStatus;
import com.udemy.backend.api.user.core.application.port.FindUserPort;
import com.udemy.backend.api.user.core.domain.model.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class CreateResponseUseCase implements CreateResponsePort {
  private final ResponseRepository responseRepository;
  private final FindTicketPort findTicketPort;
  private final FindUserPort findUserPort;
  private final UpdateTicketPort updateTicketPort;

  @Override
  public Response create(CreateResponseRequest request) {
    Ticket ticket = findTicketPort.getById(request.getTicketId())
        .orElseThrow(() -> new RuntimeException("El ticket no existe"));

    User user = findUserPort.getById(null).orElseThrow(() -> new RuntimeException("El usuario no existe"));

    Response newResponse = Response
        .builder()
        .ticket(ticket)
        .respondedBy(user)
        .message(request.getMessage())
        .respondedAt(LocalDateTime.now())
        .build();

    updateTicketPort.changeStatus(request.getTicketId(), TicketStatus.valueOf(request.getStatus()));

    return responseRepository.save(newResponse);
  }
}
