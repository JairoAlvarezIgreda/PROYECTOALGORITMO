package com.udemy.backend.api.course.category.core.adapter.out.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.udemy.backend.api.course.category.core.application.port.CreateCategoryPort;
import com.udemy.backend.api.course.category.core.domain.request.CreateCategoryRequest;

import jakarta.annotation.PostConstruct;

@Component("category_seeder")
public class CategorySeeder {
  @Autowired
  private CreateCategoryPort createCategoryPort;

  @PostConstruct
  public void seedCategories() {
    List<CreateCategoryRequest> categories = List.of(
        CreateCategoryRequest.builder().name("Programación").build(),
        CreateCategoryRequest.builder().name("Desarrollo Web").build(),
        CreateCategoryRequest.builder().name("Frontend").build(),
        CreateCategoryRequest.builder().name("Backend").build(),
        CreateCategoryRequest.builder().name("Data Science y Machine Learning").build(),
        CreateCategoryRequest.builder().name("Bases de Datos").build(),
        CreateCategoryRequest.builder().name("Control de Versiones").build(),
        CreateCategoryRequest.builder().name("Videojuegos").build(),
        CreateCategoryRequest.builder().name("Diseño UX/UI").build(),
        CreateCategoryRequest.builder().name("Ofimática y Herramientas").build(),
        CreateCategoryRequest.builder().name("Finanzas e Inversión").build(),
        CreateCategoryRequest.builder().name("Idiomas").build(),
        CreateCategoryRequest.builder().name("Fotografía y Edición").build(),
        CreateCategoryRequest.builder().name("Marketing Digital").build(),
        CreateCategoryRequest.builder().name("Robótica y Electrónica").build(),
        CreateCategoryRequest.builder().name("Ética y Sociedad").build(),
        CreateCategoryRequest.builder().name("Ciberseguridad").build(),
        CreateCategoryRequest.builder().name("DevOps y Cloud").build());

    categories.forEach(category -> createCategoryPort.create(category));
  }
}
