package com.udemy.backend.api.user.core.adapter.out.repository.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.udemy.backend.api.shared.application.repository.GlobalBasicRepository;
import com.udemy.backend.api.user.core.adapter.out.repository.UserRepository;
import com.udemy.backend.api.user.core.domain.model.User;

@Primary
@Repository
public class ImplUserRepository extends GlobalBasicRepository<User, Long> implements UserRepository {
  public ImplUserRepository() {
    super(User::getId);
  }
}
