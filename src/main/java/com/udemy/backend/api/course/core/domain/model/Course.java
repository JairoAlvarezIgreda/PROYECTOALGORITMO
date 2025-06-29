package com.udemy.backend.api.course.core.domain.model;

import java.time.LocalDateTime;
import java.util.Locale.Category;

import lombok.Builder;
import lombok.Getter;

// Toda clase que comience con @ se le llama componente.
@Builder // Crea funcionalidades para construir un nuevo objeto de forma directa.
@Getter // Crea funcionalidades para obtener datos de la clase.
public class Course {

  private Long id; // En este caso el id es de tipo Long, osea un valor numérico.
  private String name;
  private String description;
  private LocalDateTime createdAt;
  private Category category;
}
