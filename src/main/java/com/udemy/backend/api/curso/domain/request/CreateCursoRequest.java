package com.udemy.backend.api.curso.domain.request;

import lombok.Builder;
import lombok.Getter;

/**
 * * Constructor de los parámetros que se van a requerir para crear un curso.
 */
@Getter // Componente que crea las funcionalidades para obtener parámetros de la clase.
@Builder // Componente que crea las funcionalidades para construir un nuevo objeto de
         // forma directa.
public final class CreateCursoRequest {
  private String name; // En este caso solo se requiere el nombre del curso para poder crear uno nuevo.
}
