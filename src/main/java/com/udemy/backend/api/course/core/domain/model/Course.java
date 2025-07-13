package com.udemy.backend.api.course.core.domain.model;

import java.time.LocalDateTime;

import com.udemy.backend.api.course.category.core.domain.model.Category;

import lombok.Builder;
import lombok.Getter;

// Toda clase que comience con @ se le llama componente.
@Builder // Crea funcionalidades para construir un nuevo objeto de forma directa.
@Getter // Crea funcionalidades para obtener datos de la clase.
public class Course {

  private Long id; // En este caso el id es de tipo Long, osea un valor numérico.
  private String name;
  private String littleDescription;
  private String description;
  private String tags;
  private Double price;
  private LocalDateTime createdAt;
  private Category category;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Course course = (Course) o;
    return id != null && id.equals(course.id);
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
