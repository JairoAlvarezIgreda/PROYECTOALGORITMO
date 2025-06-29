package com.udemy.backend.api.ticket.core.application.port;

import java.util.Optional;

import com.udemy.backend.api.shared.domain.operator.ListE;
import com.udemy.backend.api.ticket.core.domain.model.Ticket;

public interface FindTicketPort {
  ListE<Ticket> getAll();

  Optional<Ticket> getById(Long id);
}
