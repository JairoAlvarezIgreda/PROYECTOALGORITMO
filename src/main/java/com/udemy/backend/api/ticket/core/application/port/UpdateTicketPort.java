package com.udemy.backend.api.ticket.core.application.port;

import com.udemy.backend.api.ticket.core.domain.model.Ticket;
import com.udemy.backend.api.ticket.core.domain.model.enums.TicketStatus;

public interface UpdateTicketPort {
  Ticket changeStatus(Long id, TicketStatus status);
}
