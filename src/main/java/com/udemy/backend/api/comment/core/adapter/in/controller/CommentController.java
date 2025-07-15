package com.udemy.backend.api.comment.core.adapter.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.backend.api.comment.core.application.port.in.CreateCommentPort;
import com.udemy.backend.api.comment.core.application.port.in.FindCommentPort;
import com.udemy.backend.api.comment.core.domain.model.Comment;
import com.udemy.backend.api.comment.core.domain.request.CreateCommentRequest;
import com.udemy.backend.api.shared.domain.operator.ListE;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
  private final CreateCommentPort createCommentPort;
  private final FindCommentPort findCommentPort;

  @PostMapping // Componente del método post.
  public ResponseEntity<Comment> create(@RequestBody CreateCommentRequest request) {
    return ResponseEntity.ok(createCommentPort.create(request));
  }

  @GetMapping("/search")
  public ResponseEntity<ListE<Comment>> getAllByCourse(@RequestParam(required = false) Long course) {
    ListE<Comment> cursos = findCommentPort.getAllByCourse(course);
    return ResponseEntity.ok(cursos);
  }
}
