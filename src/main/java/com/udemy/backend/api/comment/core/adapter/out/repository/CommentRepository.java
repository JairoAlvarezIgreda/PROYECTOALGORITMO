package com.udemy.backend.api.comment.core.adapter.out.repository;

import com.udemy.backend.api.comment.core.domain.model.Comment;
import com.udemy.backend.api.shared.domain.repository.BasicRepository;

public interface CommentRepository extends BasicRepository<Comment, Long> {
}
