package com.udemy.backend.api.course.module.core.adapter.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.backend.api.course.module.core.application.port.FindModulePort;
import com.udemy.backend.api.course.module.core.domain.model.Module;
import com.udemy.backend.api.shared.domain.operator.ListE;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/module")
@RequiredArgsConstructor
public class ModuleController {
  private final FindModulePort findModulePort;

  @GetMapping("/course/{id}/list")
  public ResponseEntity<ListE<Module>> list(@PathVariable Long id) {
    return ResponseEntity.ok(findModulePort.getAllByCourseId(id));
  }
}
