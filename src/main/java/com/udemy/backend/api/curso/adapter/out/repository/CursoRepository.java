package com.udemy.backend.api.curso.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.backend.api.curso.domain.model.Curso;

/**
 * * Se implementa una interfaz para obtener los datos de la base de datos
 * * extendiendo las funcionalidades que da Jpa, pasando como primer parámetro
 * * clase o la entidad definida y como segundo parámetro el tipo del
 * * identificado.
 */
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
