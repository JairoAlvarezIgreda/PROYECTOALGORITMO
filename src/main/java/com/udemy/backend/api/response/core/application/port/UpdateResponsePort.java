package com.udemy.backend.api.response.core.application.port;

import com.udemy.backend.api.response.core.domain.model.Response;

public interface UpdateResponsePort {
  Response changeRespondedBy(Long id, Long userId);

  Response changeMessage(Long id, String message);
}
