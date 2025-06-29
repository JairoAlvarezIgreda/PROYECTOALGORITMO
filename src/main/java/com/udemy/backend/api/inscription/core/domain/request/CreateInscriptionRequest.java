package com.udemy.backend.api.inscription.core.domain.request;

import lombok.Getter;

@Getter
public final class CreateInscriptionRequest {
  private Long userId;
  private Long courseId;
}
