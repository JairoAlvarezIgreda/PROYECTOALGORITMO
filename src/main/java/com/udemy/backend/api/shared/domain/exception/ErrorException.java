package com.udemy.backend.api.shared.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ErrorException extends ResponseStatusException {

  public ErrorException(String message) {
    super(HttpStatus.BAD_REQUEST, message);
  }

  public ErrorException(HttpStatus status, String message) {
    super(status, message);
  }

  public ErrorException() {
    super(HttpStatus.BAD_REQUEST, "Ha ocurrido un error inesperado.");
  }
}
