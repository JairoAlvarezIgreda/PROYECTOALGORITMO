package com.udemy.backend.api.ticket.core.application.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.ticket.core.adapter.out.repository.TicketRepository;
import com.udemy.backend.api.ticket.core.application.port.CreateTicketPort;
import com.udemy.backend.api.ticket.core.domain.model.Ticket;
import com.udemy.backend.api.ticket.core.domain.model.enums.TicketStatus;
import com.udemy.backend.api.ticket.core.domain.request.CreateTicketRequest;
import com.udemy.backend.api.user.core.application.port.FindUserPort;
import com.udemy.backend.api.user.core.domain.model.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class CreateTicketUseCase implements CreateTicketPort {
  private final TicketRepository ticketRepository;
  private final FindUserPort findUserPort;

  @Override
  public Ticket create(CreateTicketRequest request) {
    User user = findUserPort.getById(request.getUserId())
        .orElseThrow(() -> new RuntimeException("El usuario no existe"));

    Ticket newTicket = Ticket
        .builder()
        .user(user)
        .subject(request.getSubject())
        .message(request.getMessage())
        .status(TicketStatus.OPEN)
        .createdAt(LocalDateTime.now())
        .updatedAt(LocalDateTime.now())
        .build();

    return ticketRepository.save(newTicket);
  }
}
