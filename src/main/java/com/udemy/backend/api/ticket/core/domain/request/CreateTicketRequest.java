package com.udemy.backend.api.ticket.core.domain.request;

import lombok.Getter;

@Getter
public final class CreateTicketRequest {
  private Long userId;
  private String subject;
  private String message;
}
