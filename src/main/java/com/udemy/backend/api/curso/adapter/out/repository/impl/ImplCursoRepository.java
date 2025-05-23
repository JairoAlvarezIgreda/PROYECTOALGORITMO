package com.udemy.backend.api.curso.adapter.out.repository.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.udemy.backend.api.curso.adapter.out.repository.CursoRepository;
import com.udemy.backend.api.curso.domain.model.Curso;
import com.udemy.backend.api.shared.application.repository.GlobalBasicRepository;

@Primary
@Repository
public class ImplCursoRepository extends GlobalBasicRepository<Curso, Long> implements CursoRepository {
}
