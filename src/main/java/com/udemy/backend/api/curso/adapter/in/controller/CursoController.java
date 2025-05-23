package com.udemy.backend.api.curso.adapter.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.backend.api.curso.application.port.in.CreateCursoPort;
import com.udemy.backend.api.curso.application.port.in.FindCursoPort;
import com.udemy.backend.api.curso.domain.model.Curso;
import com.udemy.backend.api.curso.domain.request.CreateCursoRequest;
import com.udemy.backend.api.shared.domain.operator.ListE;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/curso") // Componente de endpoint que define las funciones que va a tener a partir de
                          // /curso.
@RequiredArgsConstructor
public class CursoController {
  private final CreateCursoPort createCursoPort;
  private final FindCursoPort findCursoPort;

  @PostMapping // Componente del método post.
  public ResponseEntity<Curso> create(@RequestBody CreateCursoRequest request) {
    return ResponseEntity.ok(createCursoPort.create(request));
  }

  @GetMapping("/list") // Componente del método get.
  public ResponseEntity<ListE<Curso>> list() {
    return ResponseEntity.ok(findCursoPort.getAll());
  }
}
