package com.udemy.backend.api.course.category.core.adapter.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.backend.api.course.category.core.application.port.FindCategoryPort;
import com.udemy.backend.api.course.category.core.domain.model.Category;
import com.udemy.backend.api.shared.domain.operator.ListE;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoryController {
  private final FindCategoryPort findCategoryPort;

  @GetMapping("/list")
  public ResponseEntity<ListE<Category>> list() {
    return ResponseEntity.ok(findCategoryPort.getAll());
  }
}
