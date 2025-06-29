package com.udemy.backend.api.qualification.core.application.port;

import com.udemy.backend.api.qualification.core.domain.model.Qualification;
import com.udemy.backend.api.qualification.core.domain.request.CreateQualificationRequest;

public interface CreateQualificationPort {
  Qualification create(CreateQualificationRequest request);
}
