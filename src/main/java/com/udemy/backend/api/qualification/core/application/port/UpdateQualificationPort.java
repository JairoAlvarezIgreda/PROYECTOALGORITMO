package com.udemy.backend.api.qualification.core.application.port;

import com.udemy.backend.api.qualification.core.domain.model.Qualification;

public interface UpdateQualificationPort {
  Qualification changeScore(Long id, Integer score);

  Qualification changeComment(Long id, String comment);
}
