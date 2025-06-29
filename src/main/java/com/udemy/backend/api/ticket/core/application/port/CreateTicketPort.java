package com.udemy.backend.api.ticket.core.application.port;

import com.udemy.backend.api.ticket.core.domain.model.Ticket;
import com.udemy.backend.api.ticket.core.domain.request.CreateTicketRequest;

public interface CreateTicketPort {
  Ticket create(CreateTicketRequest request);
}
