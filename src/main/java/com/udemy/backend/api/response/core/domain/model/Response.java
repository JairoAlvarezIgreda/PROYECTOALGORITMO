package com.udemy.backend.api.response.core.domain.model;

import java.time.LocalDateTime;

import com.udemy.backend.api.ticket.core.domain.model.Ticket;
import com.udemy.backend.api.user.core.domain.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Response {

  private Long id;
  private Ticket ticket;
  private User respondedBy;
  private String message;
  private LocalDateTime respondedAt;
}
