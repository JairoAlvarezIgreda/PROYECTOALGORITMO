package com.udemy.backend.api.ticket.core.application.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.shared.domain.operator.ListE;
import com.udemy.backend.api.ticket.core.adapter.out.repository.TicketRepository;
import com.udemy.backend.api.ticket.core.application.port.FindTicketPort;
import com.udemy.backend.api.ticket.core.domain.model.Ticket;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class FindTicketUseCase implements FindTicketPort {
  private final TicketRepository ticketRepository;

  @Override
  public ListE<Ticket> getAll() {
    return ticketRepository.findAll();
  }

  @Override
  public Optional<Ticket> getById(Long id) {
    return ticketRepository.findById(id);
  }
}
