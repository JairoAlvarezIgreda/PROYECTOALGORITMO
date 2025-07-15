package com.udemy.backend.api.comment.core.application.port.in;

import com.udemy.backend.api.comment.core.domain.model.Comment;
import com.udemy.backend.api.comment.core.domain.request.CreateCommentRequest;

public interface CreateCommentPort {
  Comment create(CreateCommentRequest request);
}
