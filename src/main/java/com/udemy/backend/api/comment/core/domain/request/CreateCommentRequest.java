package com.udemy.backend.api.comment.core.domain.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public final class CreateCommentRequest {
  private Long userId;
  private Long courseId;
  private String content;
}
