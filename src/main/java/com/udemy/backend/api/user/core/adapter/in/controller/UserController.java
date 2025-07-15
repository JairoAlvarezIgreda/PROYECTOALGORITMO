package com.udemy.backend.api.user.core.adapter.in.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.backend.api.shared.domain.exception.ErrorException;
import com.udemy.backend.api.user.core.application.port.CreateUserPort;
import com.udemy.backend.api.user.core.application.port.FindUserPort;
import com.udemy.backend.api.user.core.domain.model.User;
import com.udemy.backend.api.user.core.domain.request.CreateUserRequest;
import com.udemy.backend.api.user.core.domain.request.LoginUserRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UserController {
  private final CreateUserPort createUserPort;
  private final FindUserPort findUserPort;

  @PostMapping("/register")
  public ResponseEntity<User> register(@RequestBody CreateUserRequest request) {
    return ResponseEntity.ok(createUserPort.create(request));
  }

  @GetMapping("/id/{id}")
  public ResponseEntity<User> getById(@PathVariable Long id) {
    return ResponseEntity.ok(findUserPort.getById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
  }

  @GetMapping("/count")
  public ResponseEntity<Integer> count() {
    return ResponseEntity.ok(findUserPort.count());
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginUserRequest request) {
    try {
      return ResponseEntity.ok(findUserPort.login(request));
    } catch (ErrorException e) {
      return ResponseEntity
          .status(e.getStatusCode())
          .body(Map.of("message", e.getMessage()));
    }
  }
}
