package com.udemy.backend.api.ticket.core.domain.model;

import java.time.LocalDateTime;

import com.udemy.backend.api.ticket.core.domain.model.enums.TicketStatus;
import com.udemy.backend.api.user.core.domain.model.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Ticket {

  private Long id;
  private User user;
  private String subject;
  private String message;
  private TicketStatus status;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
