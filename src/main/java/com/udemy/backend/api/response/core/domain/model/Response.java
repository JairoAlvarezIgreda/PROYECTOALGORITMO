package com.udemy.backend.api.response.core.domain.model;

import java.time.LocalDateTime;

import com.udemy.backend.api.ticket.core.domain.model.Ticket;
import com.udemy.backend.api.user.core.domain.model.User;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Response {

  private Long id;
  private Ticket ticket;
  private User respondedBy;
  private String message;
  private LocalDateTime respondedAt;
}
