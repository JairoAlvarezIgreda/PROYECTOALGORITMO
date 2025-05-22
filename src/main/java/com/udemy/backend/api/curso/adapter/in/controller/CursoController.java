package com.udemy.backend.api.curso.adapter.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.backend.api.curso.application.port.in.CreateCursoPort;
import com.udemy.backend.api.curso.domain.model.Curso;
import com.udemy.backend.api.curso.domain.request.CreateCursoRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/curso") // Componente de endpoint que define las funciones que va a tener a partir de
                          // /curso.
@RequiredArgsConstructor
public class CursoController {
  private final CreateCursoPort createCursoPort;

  @PostMapping // Componente del método post.
  public ResponseEntity<Curso> create(@RequestBody CreateCursoRequest request) {
    return ResponseEntity.ok(createCursoPort.create(request));
  }
}
