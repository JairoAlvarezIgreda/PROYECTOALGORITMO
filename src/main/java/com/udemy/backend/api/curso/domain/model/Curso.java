package com.udemy.backend.api.curso.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

// Toda clase que comience con @ se le llama componente.
@Entity // Define que una clase se identifique como una tabla o entidad en la base de
        // datos.
@Builder // Crea funcionalidades para construir un nuevo objeto de forma directa.
@Getter // Crea funcionalidades para obtener datos de la clase.
public class Curso {

  @Id // Componente que clasifica el identificador único de la tabla.
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Define la estrategia que usará para generar un id
                                                      // (auto_increment).
  private Long id; // En este caso el id es de tipo Long, osea un valor numérico.

  @Column(nullable = false) // Componente que define mejor la columna, en este caso no queremos que el
                            // nombre del curso sea nulo.
  private String name;
}
