package com.udemy.backend.api.ticket.core.adapter.out.repository.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.udemy.backend.api.shared.application.repository.GlobalBasicRepository;
import com.udemy.backend.api.ticket.core.adapter.out.repository.TicketRepository;
import com.udemy.backend.api.ticket.core.domain.model.Ticket;

@Primary
@Repository
public class ImplTicketRepository extends GlobalBasicRepository<Ticket, Long> implements TicketRepository {
  public ImplTicketRepository() {
    super(Ticket::getId);
  }
}
