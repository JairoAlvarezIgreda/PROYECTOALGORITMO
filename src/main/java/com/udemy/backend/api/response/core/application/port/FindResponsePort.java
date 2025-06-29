package com.udemy.backend.api.response.core.application.port;

import java.util.Optional;

import com.udemy.backend.api.response.core.domain.model.Response;
import com.udemy.backend.api.shared.domain.operator.ListE;

public interface FindResponsePort {
  ListE<Response> getAll();

  Optional<Response> getById(Long id);

  Optional<Response> getByTicketId(Long id);
}
