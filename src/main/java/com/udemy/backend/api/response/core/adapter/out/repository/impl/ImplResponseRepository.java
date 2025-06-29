package com.udemy.backend.api.response.core.adapter.out.repository.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.udemy.backend.api.response.core.adapter.out.repository.ResponseRepository;
import com.udemy.backend.api.response.core.domain.model.Response;
import com.udemy.backend.api.shared.application.repository.GlobalBasicRepository;

@Primary
@Repository
public class ImplResponseRepository extends GlobalBasicRepository<Response, Long> implements ResponseRepository {
  public ImplResponseRepository() {
    super(Response::getId);
  }
}
