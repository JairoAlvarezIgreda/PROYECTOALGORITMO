package com.udemy.backend.api.course.core.adapter.in.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.udemy.backend.api.course.core.application.port.in.CreateCursoPort;
import com.udemy.backend.api.course.core.application.port.in.FindCoursePort;
import com.udemy.backend.api.course.core.domain.model.Course;
import com.udemy.backend.api.course.core.domain.request.CreateCursoRequest;
import com.udemy.backend.api.shared.domain.operator.ListE;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/curso") // Componente de endpoint que define las funciones que va a tener a partir de
                          // /curso.
@RequiredArgsConstructor
public class CursoController {
  private final CreateCursoPort createCursoPort;
  private final FindCoursePort findCursoPort;

  @PostMapping // Componente del método post.
  public ResponseEntity<Course> create(@RequestBody CreateCursoRequest request) {
    return ResponseEntity.ok(createCursoPort.create(request));
  }

  @GetMapping("/list") // Componente del método get.
  public ResponseEntity<ListE<Course>> list() {
    return ResponseEntity.ok(findCursoPort.getAll());
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<Course> getById(@PathVariable Long id) {
    return ResponseEntity.ok(findCursoPort.getById(id).orElseThrow(() -> new RuntimeException("Curso no encontrado")));
  }

  @GetMapping("/name/{name}")
  public ResponseEntity<Course> getByName(@PathVariable String name) {
    return ResponseEntity
        .ok(findCursoPort.getByName(name)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado")));
  }

  @GetMapping("/search")
  public ResponseEntity<ListE<Course>> getAllByName(@RequestParam(required = false) String name,
      @RequestParam(required = false) Long category) {
    ListE<Course> cursos;
    if (category == null)
      cursos = findCursoPort.getAllByName(name);
    else
      cursos = findCursoPort.getAllByCategory(category);
    return ResponseEntity.ok(cursos);
  }

}
