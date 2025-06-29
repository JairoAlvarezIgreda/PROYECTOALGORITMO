package com.udemy.backend.api.response.core.domain.request;

import lombok.Getter;

@Getter
public final class CreateResponseRequest {
  private Long ticketId;
  private Long respondedById;
  private String message;
  private String status;
}
