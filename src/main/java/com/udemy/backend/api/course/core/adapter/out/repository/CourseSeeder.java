package com.udemy.backend.api.course.core.adapter.out.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.udemy.backend.api.course.core.application.port.in.CreateCursoPort;
import com.udemy.backend.api.course.core.domain.request.CreateCursoRequest;

import jakarta.annotation.PostConstruct;

@DependsOn("category_seeder")
@Component("course_seeder")
public class CourseSeeder {

  @Autowired
  private CreateCursoPort createCursoPort;

  @PostConstruct
  public void seedCourse() {
    List<CreateCursoRequest> courses = List.of(
        CreateCursoRequest.builder()
            .name("Curso de Java desde cero")
            .description("Aprende Java paso a paso")
            .categoryId(1L)
            .build(),
        CreateCursoRequest.builder()
            .name("Introducción a la Inteligencia Artificial")
            .description("Conoce los conceptos básicos de la IA")
            .categoryId(2L)
            .build(),
        CreateCursoRequest.builder()
            .name("Psicología del aprendizaje")
            .description("Explora los fundamentos de la psicología cognitiva")
            .categoryId(3L)
            .build());

    for (CreateCursoRequest course : courses) {
      createCursoPort.create(course);
    }
  }
}
