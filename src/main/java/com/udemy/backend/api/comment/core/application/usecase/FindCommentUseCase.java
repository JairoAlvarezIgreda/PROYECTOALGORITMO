package com.udemy.backend.api.comment.core.application.usecase;

import org.springframework.stereotype.Service;

import com.udemy.backend.api.comment.core.adapter.out.repository.CommentRepository;
import com.udemy.backend.api.comment.core.application.port.in.FindCommentPort;
import com.udemy.backend.api.comment.core.domain.model.Comment;
import com.udemy.backend.api.course.core.application.port.in.FindCoursePort;
import com.udemy.backend.api.course.core.domain.model.Course;
import com.udemy.backend.api.shared.domain.operator.ListE;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public final class FindCommentUseCase implements FindCommentPort {
  private final CommentRepository commentRepository;
  private final FindCoursePort findCoursePort;

  @Override
  public ListE<Comment> getAllByCourse(Long id) {
    Course course = findCoursePort.getById(id).orElseThrow(() -> new RuntimeException("El curso no existe"));

    return commentRepository.findAllBy(Comment::getCourse, course);
  }
}
