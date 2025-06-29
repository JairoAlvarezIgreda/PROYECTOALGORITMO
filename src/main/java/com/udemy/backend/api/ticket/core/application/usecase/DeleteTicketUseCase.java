package com.udemy.backend.api.ticket.core.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.ticket.core.adapter.out.repository.TicketRepository;
import com.udemy.backend.api.ticket.core.application.port.DeleteTickerPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class DeleteTicketUseCase implements DeleteTickerPort {
  private final TicketRepository ticketRepository;

  @Override
  public void deleteById(Long id) {
    ticketRepository.deleteById(id);
  }
}
