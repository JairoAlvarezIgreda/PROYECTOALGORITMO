package com.udemy.backend.api.inscription.core.adapter.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.backend.api.inscription.core.application.port.CreateInscriptionPort;
import com.udemy.backend.api.inscription.core.application.port.FindInscriptionPort;
import com.udemy.backend.api.inscription.core.domain.model.Inscription;
import com.udemy.backend.api.inscription.core.domain.request.CreateInscriptionRequest;
import com.udemy.backend.api.shared.domain.operator.ListE;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inscription")
@RequiredArgsConstructor
public class InscriptionController {
  private final CreateInscriptionPort createInscriptionPort;
  private final FindInscriptionPort findInscriptionPort;

  @PostMapping
  public ResponseEntity<Inscription> create(@RequestBody CreateInscriptionRequest request) {
    return ResponseEntity.ok(createInscriptionPort.create(request));
  }

  @GetMapping("/courses")
  public ResponseEntity<ListE<Inscription>> create(@RequestParam Long id) {
    return ResponseEntity.ok(findInscriptionPort.getAllByUserId(id));
  }
}
