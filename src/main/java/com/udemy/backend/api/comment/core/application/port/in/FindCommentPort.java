package com.udemy.backend.api.comment.core.application.port.in;

import com.udemy.backend.api.comment.core.domain.model.Comment;
import com.udemy.backend.api.shared.domain.operator.ListE;

public interface FindCommentPort {
  ListE<Comment> getAllByCourse(Long id);
}
