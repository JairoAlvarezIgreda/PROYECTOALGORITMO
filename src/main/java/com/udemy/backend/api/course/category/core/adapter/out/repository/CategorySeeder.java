package com.udemy.backend.api.course.category.core.adapter.out.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.udemy.backend.api.course.category.core.application.port.CreateCategoryPort;
import com.udemy.backend.api.course.category.core.domain.request.CreateCategoryRequest;

import jakarta.annotation.PostConstruct;

@DependsOn("course_seeder")
@Component("category_seeder")
public class CategorySeeder {
  @Autowired
  private CreateCategoryPort createCategoryPort;

  @PostConstruct
  public void seedCategories() {
    List<CreateCategoryRequest> categories = List.of(
        CreateCategoryRequest.builder().name("Tecnología").build(),
        CreateCategoryRequest.builder().name("Inteligencia Artificial").build(),
        CreateCategoryRequest.builder().name("Psicología").build(),
        CreateCategoryRequest.builder().name("Negocios").build(),
        CreateCategoryRequest.builder().name("Arte y Diseño").build());

    categories.forEach(category -> createCategoryPort.create(category));
  }
}
