package com.udemy.backend.api.comment.core.application.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.comment.core.adapter.out.repository.CommentRepository;
import com.udemy.backend.api.comment.core.application.port.in.CreateCommentPort;
import com.udemy.backend.api.comment.core.domain.model.Comment;
import com.udemy.backend.api.comment.core.domain.request.CreateCommentRequest;
import com.udemy.backend.api.course.core.application.port.in.FindCoursePort;
import com.udemy.backend.api.course.core.domain.model.Course;
import com.udemy.backend.api.user.core.application.port.FindUserPort;
import com.udemy.backend.api.user.core.domain.model.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateCommentUseCase implements CreateCommentPort {
  private final CommentRepository commentRepository;
  private final FindCoursePort findCoursePort;
  private final FindUserPort findUserPort;
  private Long idGenerator = 0L;

  @Override
  public Comment create(CreateCommentRequest request) {
    Course course = findCoursePort.getById(request.getCourseId())
        .orElseThrow(() -> new RuntimeException("El curso no existe"));

    User user = findUserPort.getById(request.getUserId())
        .orElseThrow(() -> new RuntimeException("El usuario no existe"));

    idGenerator += 1;

    Comment newComment = Comment
        .builder()
        .id(idGenerator)
        .course(course)
        .user(user)
        .content(request.getContent())
        .createdAt(LocalDateTime.now())
        .build();

    return commentRepository.save(newComment);
  }
}
