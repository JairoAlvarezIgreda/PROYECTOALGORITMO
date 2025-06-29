package com.udemy.backend.api.qualification.core.adapter.out.repository.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.udemy.backend.api.qualification.core.adapter.out.repository.QualificationRepository;
import com.udemy.backend.api.qualification.core.domain.model.Qualification;
import com.udemy.backend.api.shared.application.repository.GlobalBasicRepository;

@Primary
@Repository
public class ImplQualificationRepository extends GlobalBasicRepository<Qualification, Long>
    implements QualificationRepository {
  public ImplQualificationRepository() {
    super(Qualification::getId);
  }
}
