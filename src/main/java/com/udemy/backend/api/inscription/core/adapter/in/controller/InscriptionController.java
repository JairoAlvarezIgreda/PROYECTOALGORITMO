package com.udemy.backend.api.inscription.core.adapter.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.backend.api.inscription.core.application.port.CreateInscriptionPort;
import com.udemy.backend.api.inscription.core.domain.model.Inscription;
import com.udemy.backend.api.inscription.core.domain.request.CreateInscriptionRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inscription")
@RequiredArgsConstructor
public class InscriptionController {
  private final CreateInscriptionPort createInscriptionPort;

  @PostMapping
  public ResponseEntity<Inscription> create(@RequestBody CreateInscriptionRequest request) {
    return ResponseEntity.ok(createInscriptionPort.create(request));
  }
}
