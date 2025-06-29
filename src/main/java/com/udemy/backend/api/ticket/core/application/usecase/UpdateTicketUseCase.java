package com.udemy.backend.api.ticket.core.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.ticket.core.adapter.out.repository.TicketRepository;
import com.udemy.backend.api.ticket.core.application.port.FindTicketPort;
import com.udemy.backend.api.ticket.core.application.port.UpdateTicketPort;
import com.udemy.backend.api.ticket.core.domain.model.Ticket;
import com.udemy.backend.api.ticket.core.domain.model.enums.TicketStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class UpdateTicketUseCase implements UpdateTicketPort {
  private final TicketRepository ticketRepository;
  private final FindTicketPort findTicketPort;

  @Override
  public Ticket changeStatus(Long id, TicketStatus status) {
    Ticket ticket = findTicketPort.getById(id).orElseThrow(() -> new RuntimeException("El ticket no existe"));

    ticket.setStatus(status);

    return ticketRepository.update(ticket);
  }
}
