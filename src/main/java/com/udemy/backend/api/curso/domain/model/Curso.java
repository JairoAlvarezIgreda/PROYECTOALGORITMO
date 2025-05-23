package com.udemy.backend.api.curso.domain.model;

import lombok.Builder;
import lombok.Getter;

// Toda clase que comience con @ se le llama componente.
@Builder // Crea funcionalidades para construir un nuevo objeto de forma directa.
@Getter // Crea funcionalidades para obtener datos de la clase.
public class Curso {

  private Long id; // En este caso el id es de tipo Long, osea un valor numérico.

  private String name;
}
