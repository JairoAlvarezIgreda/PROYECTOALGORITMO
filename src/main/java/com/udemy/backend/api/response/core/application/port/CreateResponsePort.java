package com.udemy.backend.api.response.core.application.port;

import com.udemy.backend.api.response.core.domain.model.Response;
import com.udemy.backend.api.response.core.domain.request.CreateResponseRequest;

public interface CreateResponsePort {
  Response create(CreateResponseRequest request);
}
