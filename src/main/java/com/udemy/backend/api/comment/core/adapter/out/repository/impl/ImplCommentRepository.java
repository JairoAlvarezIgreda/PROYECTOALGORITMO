package com.udemy.backend.api.comment.core.adapter.out.repository.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.udemy.backend.api.comment.core.domain.model.Comment;
import com.udemy.backend.api.shared.application.repository.GlobalBasicRepository;

@Primary
@Repository
public class ImplCommentRepository extends GlobalBasicRepository<Comment, Long> {
  public ImplCommentRepository() {
    super(Comment::getId);
  }
}
