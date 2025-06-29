package com.udemy.backend.api.clazz.core.adapter.out.repository.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.udemy.backend.api.clazz.core.adapter.out.repository.ClazzRepository;
import com.udemy.backend.api.clazz.core.domain.model.Clazz;
import com.udemy.backend.api.shared.application.repository.GlobalBasicRepository;

@Primary
@Repository
public class ImplClazzRepository extends GlobalBasicRepository<Clazz, Long> implements ClazzRepository {
  public ImplClazzRepository() {
    super(Clazz::getId);
  }
}
