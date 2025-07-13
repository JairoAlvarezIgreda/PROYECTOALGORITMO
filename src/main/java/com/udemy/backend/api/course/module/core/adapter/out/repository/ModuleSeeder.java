package com.udemy.backend.api.course.module.core.adapter.out.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.udemy.backend.api.course.module.core.application.port.CreateModulePort;
import com.udemy.backend.api.course.module.core.domain.request.CreateModuleRequest;

import jakarta.annotation.PostConstruct;

@DependsOn("course_seeder")
@Component("module_seeder")
public class ModuleSeeder {
  @Autowired
  private CreateModulePort createModulePort;

  @PostConstruct
  public void seedModules() {
    List<CreateModuleRequest> modules = List.of(
        CreateModuleRequest.builder().courseId(1L).title("Técnicas avanzadas 1")
            .description("Desarrollo de una solución real.").order(1).duration(30L).build(),
        CreateModuleRequest.builder().courseId(1L).title("Práctica guiada 2")
            .description("Ejemplos prácticos paso a paso.").order(2).duration(53L).build(),
        CreateModuleRequest.builder().courseId(1L).title("Técnicas avanzadas 3")
            .description("Simula situaciones reales.").order(3).duration(52L).build(),
        CreateModuleRequest.builder().courseId(2L).title("Introducción 1").description("Simula situaciones reales.")
            .order(1).duration(41L).build(),
        CreateModuleRequest.builder().courseId(2L).title("Herramientas y recursos 2")
            .description("Aplicación de conocimientos previos.").order(2).duration(45L).build(),
        CreateModuleRequest.builder().courseId(2L).title("Conceptos clave 3")
            .description("Desarrollo de una solución real.").order(3).duration(54L).build(),
        CreateModuleRequest.builder().courseId(2L).title("Introducción 4")
            .description("Aplicación de conocimientos previos.").order(4).duration(54L).build(),
        CreateModuleRequest.builder().courseId(2L).title("Herramientas y recursos 5")
            .description("Explora herramientas del entorno.").order(5).duration(38L).build(),
        CreateModuleRequest.builder().courseId(3L).title("Práctica guiada 1")
            .description("Actividad para reforzar el tema.").order(1).duration(44L).build(),
        CreateModuleRequest.builder().courseId(3L).title("Fundamentos 2")
            .description("Actividad para reforzar el tema.").order(2).duration(48L).build(),
        CreateModuleRequest.builder().courseId(4L).title("Teoría aplicada 1")
            .description("Ejemplos prácticos paso a paso.").order(1).duration(44L).build(),
        CreateModuleRequest.builder().courseId(4L).title("Introducción 2").description("Simula situaciones reales.")
            .order(2).duration(22L).build(),
        CreateModuleRequest.builder().courseId(4L).title("Conceptos clave 3")
            .description("Aprende los aspectos esenciales.").order(3).duration(39L).build(),
        CreateModuleRequest.builder().courseId(4L).title("Teoría aplicada 4")
            .description("Ejemplos prácticos paso a paso.").order(4).duration(51L).build(),
        CreateModuleRequest.builder().courseId(4L).title("Proyecto final 5")
            .description("Ejemplos prácticos paso a paso.").order(5).duration(39L).build(),
        CreateModuleRequest.builder().courseId(5L).title("Resumen y repaso 1").description("Simula situaciones reales.")
            .order(1).duration(50L).build(),
        CreateModuleRequest.builder().courseId(5L).title("Fundamentos 2")
            .description("Aprende los aspectos esenciales.").order(2).duration(22L).build(),
        CreateModuleRequest.builder().courseId(5L).title("Fundamentos 3")
            .description("Desarrollo de una solución real.").order(3).duration(32L).build(),
        CreateModuleRequest.builder().courseId(5L).title("Práctica guiada 4")
            .description("Conceptos teóricos con ejemplos.").order(4).duration(51L).build(),
        CreateModuleRequest.builder().courseId(5L).title("Casos reales 5")
            .description("Conceptos teóricos con ejemplos.").order(5).duration(40L).build(),
        CreateModuleRequest.builder().courseId(6L).title("Fundamentos 1")
            .description("Desarrollo de una solución real.").order(1).duration(50L).build(),
        CreateModuleRequest.builder().courseId(6L).title("Teoría aplicada 2")
            .description("Ejemplos prácticos paso a paso.").order(2).duration(40L).build(),
        CreateModuleRequest.builder().courseId(7L).title("Conceptos clave 1").description("Simula situaciones reales.")
            .order(1).duration(58L).build(),
        CreateModuleRequest.builder().courseId(7L).title("Técnicas avanzadas 2")
            .description("Simula situaciones reales.").order(2).duration(30L).build(),
        CreateModuleRequest.builder().courseId(7L).title("Proyecto final 3")
            .description("Ejemplos prácticos paso a paso.").order(3).duration(51L).build(),
        CreateModuleRequest.builder().courseId(8L).title("Resumen y repaso 1")
            .description("Explora herramientas del entorno.").order(1).duration(22L).build(),
        CreateModuleRequest.builder().courseId(8L).title("Teoría aplicada 2").description("Evaluación del módulo.")
            .order(2).duration(20L).build(),
        CreateModuleRequest.builder().courseId(9L).title("Introducción 1")
            .description("Aprende los aspectos esenciales.").order(1).duration(21L).build(),
        CreateModuleRequest.builder().courseId(9L).title("Técnicas avanzadas 2")
            .description("Explora herramientas del entorno.").order(2).duration(32L).build(),
        CreateModuleRequest.builder().courseId(9L).title("Conceptos clave 3")
            .description("Desarrollo de una solución real.").order(3).duration(39L).build(),
        CreateModuleRequest.builder().courseId(10L).title("Resumen y repaso 1")
            .description("Ejemplos prácticos paso a paso.").order(1).duration(40L).build(),
        CreateModuleRequest.builder().courseId(10L).title("Fundamentos 2").description("Evaluación del módulo.")
            .order(2).duration(36L).build(),
        CreateModuleRequest.builder().courseId(10L).title("Herramientas y recursos 3")
            .description("Ejemplos prácticos paso a paso.").order(3).duration(37L).build(),
        CreateModuleRequest.builder().courseId(10L).title("Casos reales 4")
            .description("Aplicación de conocimientos previos.").order(4).duration(26L).build(),
        CreateModuleRequest.builder().courseId(11L).title("Conceptos clave 1")
            .description("Ejemplos prácticos paso a paso.").order(1).duration(43L).build(),
        CreateModuleRequest.builder().courseId(11L).title("Teoría aplicada 2")
            .description("Explora herramientas del entorno.").order(2).duration(27L).build(),
        CreateModuleRequest.builder().courseId(11L).title("Técnicas avanzadas 3")
            .description("Explora herramientas del entorno.").order(3).duration(48L).build(),
        CreateModuleRequest.builder().courseId(11L).title("Casos reales 4")
            .description("Desarrollo de una solución real.").order(4).duration(50L).build(),
        CreateModuleRequest.builder().courseId(12L).title("Técnicas avanzadas 1")
            .description("Desarrollo de una solución real.").order(1).duration(21L).build(),
        CreateModuleRequest.builder().courseId(12L).title("Proyecto final 2")
            .description("Explora herramientas del entorno.").order(2).duration(20L).build(),
        CreateModuleRequest.builder().courseId(13L).title("Casos reales 1")
            .description("Actividad para reforzar el tema.").order(1).duration(43L).build(),
        CreateModuleRequest.builder().courseId(13L).title("Técnicas avanzadas 2")
            .description("Explora herramientas del entorno.").order(2).duration(44L).build(),
        CreateModuleRequest.builder().courseId(13L).title("Teoría aplicada 3")
            .description("Explora herramientas del entorno.").order(3).duration(30L).build(),
        CreateModuleRequest.builder().courseId(14L).title("Casos reales 1")
            .description("Actividad para reforzar el tema.").order(1).duration(53L).build(),
        CreateModuleRequest.builder().courseId(14L).title("Resumen y repaso 2")
            .description("Aprende los aspectos esenciales.").order(2).duration(31L).build(),
        CreateModuleRequest.builder().courseId(14L).title("Resumen y repaso 3")
            .description("Conceptos teóricos con ejemplos.").order(3).duration(29L).build(),
        CreateModuleRequest.builder().courseId(14L).title("Proyecto final 4")
            .description("Aprende los aspectos esenciales.").order(4).duration(21L).build(),
        CreateModuleRequest.builder().courseId(15L).title("Introducción 1")
            .description("Repasa y consolida lo aprendido.").order(1).duration(42L).build(),
        CreateModuleRequest.builder().courseId(15L).title("Proyecto final 2")
            .description("Desarrollo de una solución real.").order(2).duration(34L).build(),
        CreateModuleRequest.builder().courseId(16L).title("Resumen y repaso 1")
            .description("Explora herramientas del entorno.").order(1).duration(54L).build(),
        CreateModuleRequest.builder().courseId(16L).title("Técnicas avanzadas 2")
            .description("Actividad para reforzar el tema.").order(2).duration(60L).build(),
        CreateModuleRequest.builder().courseId(17L).title("Técnicas avanzadas 1")
            .description("Desarrollo de una solución real.").order(1).duration(44L).build(),
        CreateModuleRequest.builder().courseId(17L).title("Técnicas avanzadas 2")
            .description("Repasa y consolida lo aprendido.").order(2).duration(28L).build(),
        CreateModuleRequest.builder().courseId(17L).title("Práctica guiada 3").description("Simula situaciones reales.")
            .order(3).duration(49L).build(),
        CreateModuleRequest.builder().courseId(17L).title("Práctica guiada 4")
            .description("Conceptos teóricos con ejemplos.").order(4).duration(45L).build(),
        CreateModuleRequest.builder().courseId(18L).title("Introducción 1").description("Simula situaciones reales.")
            .order(1).duration(52L).build(),
        CreateModuleRequest.builder().courseId(18L).title("Introducción 2").description("Evaluación del módulo.")
            .order(2).duration(21L).build(),
        CreateModuleRequest.builder().courseId(18L).title("Fundamentos 3")
            .description("Aprende los aspectos esenciales.").order(3).duration(59L).build(),
        CreateModuleRequest.builder().courseId(18L).title("Práctica guiada 4")
            .description("Repasa y consolida lo aprendido.").order(4).duration(32L).build(),
        CreateModuleRequest.builder().courseId(19L).title("Conceptos clave 1")
            .description("Ejemplos prácticos paso a paso.").order(1).duration(22L).build(),
        CreateModuleRequest.builder().courseId(19L).title("Teoría aplicada 2")
            .description("Conceptos teóricos con ejemplos.").order(2).duration(23L).build(),
        CreateModuleRequest.builder().courseId(19L).title("Práctica guiada 3")
            .description("Conceptos teóricos con ejemplos.").order(3).duration(40L).build(),
        CreateModuleRequest.builder().courseId(19L).title("Técnicas avanzadas 4")
            .description("Simula situaciones reales.").order(4).duration(33L).build(),
        CreateModuleRequest.builder().courseId(19L).title("Fundamentos 5")
            .description("Aprende los aspectos esenciales.").order(5).duration(25L).build(),
        CreateModuleRequest.builder().courseId(20L).title("Resumen y repaso 1")
            .description("Desarrollo de una solución real.").order(1).duration(29L).build(),
        CreateModuleRequest.builder().courseId(20L).title("Técnicas avanzadas 2")
            .description("Aprende los aspectos esenciales.").order(2).duration(27L).build(),
        CreateModuleRequest.builder().courseId(20L).title("Teoría aplicada 3")
            .description("Repasa y consolida lo aprendido.").order(3).duration(20L).build(),
        CreateModuleRequest.builder().courseId(20L).title("Práctica guiada 4")
            .description("Conceptos teóricos con ejemplos.").order(4).duration(45L).build(),
        CreateModuleRequest.builder().courseId(21L).title("Resumen y repaso 1")
            .description("Aplicación de conocimientos previos.").order(1).duration(34L).build(),
        CreateModuleRequest.builder().courseId(21L).title("Resumen y repaso 2")
            .description("Repasa y consolida lo aprendido.").order(2).duration(24L).build(),
        CreateModuleRequest.builder().courseId(22L).title("Fundamentos 1").description("Evaluación del módulo.")
            .order(1).duration(50L).build(),
        CreateModuleRequest.builder().courseId(22L).title("Técnicas avanzadas 2")
            .description("Desarrollo de una solución real.").order(2).duration(22L).build(),
        CreateModuleRequest.builder().courseId(22L).title("Técnicas avanzadas 3")
            .description("Aplicación de conocimientos previos.").order(3).duration(33L).build(),
        CreateModuleRequest.builder().courseId(22L).title("Técnicas avanzadas 4")
            .description("Aplicación de conocimientos previos.").order(4).duration(47L).build(),
        CreateModuleRequest.builder().courseId(23L).title("Casos reales 1")
            .description("Aplicación de conocimientos previos.").order(1).duration(53L).build(),
        CreateModuleRequest.builder().courseId(23L).title("Técnicas avanzadas 2")
            .description("Actividad para reforzar el tema.").order(2).duration(59L).build(),
        CreateModuleRequest.builder().courseId(24L).title("Conceptos clave 1")
            .description("Aplicación de conocimientos previos.").order(1).duration(30L).build(),
        CreateModuleRequest.builder().courseId(24L).title("Introducción 2")
            .description("Desarrollo de una solución real.").order(2).duration(26L).build(),
        CreateModuleRequest.builder().courseId(24L).title("Proyecto final 3")
            .description("Conceptos teóricos con ejemplos.").order(3).duration(53L).build(),
        CreateModuleRequest.builder().courseId(24L).title("Herramientas y recursos 4")
            .description("Aprende los aspectos esenciales.").order(4).duration(50L).build(),
        CreateModuleRequest.builder().courseId(24L).title("Conceptos clave 5").description("Evaluación del módulo.")
            .order(5).duration(35L).build(),
        CreateModuleRequest.builder().courseId(25L).title("Fundamentos 1")
            .description("Repasa y consolida lo aprendido.").order(1).duration(32L).build(),
        CreateModuleRequest.builder().courseId(25L).title("Introducción 2")
            .description("Ejemplos prácticos paso a paso.").order(2).duration(41L).build(),
        CreateModuleRequest.builder().courseId(25L).title("Teoría aplicada 3")
            .description("Desarrollo de una solución real.").order(3).duration(25L).build(),
        CreateModuleRequest.builder().courseId(25L).title("Introducción 4")
            .description("Aprende los aspectos esenciales.").order(4).duration(27L).build(),
        CreateModuleRequest.builder().courseId(25L).title("Introducción 5")
            .description("Conceptos teóricos con ejemplos.").order(5).duration(21L).build(),
        CreateModuleRequest.builder().courseId(26L).title("Proyecto final 1")
            .description("Conceptos teóricos con ejemplos.").order(1).duration(57L).build(),
        CreateModuleRequest.builder().courseId(26L).title("Práctica guiada 2")
            .description("Repasa y consolida lo aprendido.").order(2).duration(50L).build(),
        CreateModuleRequest.builder().courseId(26L).title("Práctica guiada 3")
            .description("Explora herramientas del entorno.").order(3).duration(24L).build(),
        CreateModuleRequest.builder().courseId(27L).title("Técnicas avanzadas 1").description("Evaluación del módulo.")
            .order(1).duration(30L).build(),
        CreateModuleRequest.builder().courseId(27L).title("Conceptos clave 2")
            .description("Repasa y consolida lo aprendido.").order(2).duration(32L).build(),
        CreateModuleRequest.builder().courseId(27L).title("Introducción 3")
            .description("Conceptos teóricos con ejemplos.").order(3).duration(27L).build(),
        CreateModuleRequest.builder().courseId(27L).title("Proyecto final 4").description("Simula situaciones reales.")
            .order(4).duration(51L).build(),
        CreateModuleRequest.builder().courseId(27L).title("Introducción 5")
            .description("Conceptos teóricos con ejemplos.").order(5).duration(53L).build(),
        CreateModuleRequest.builder().courseId(28L).title("Fundamentos 1").description("Simula situaciones reales.")
            .order(1).duration(26L).build(),
        CreateModuleRequest.builder().courseId(28L).title("Resumen y repaso 2").description("Evaluación del módulo.")
            .order(2).duration(38L).build(),
        CreateModuleRequest.builder().courseId(29L).title("Herramientas y recursos 1")
            .description("Evaluación del módulo.").order(1).duration(38L).build(),
        CreateModuleRequest.builder().courseId(29L).title("Casos reales 2").description("Simula situaciones reales.")
            .order(2).duration(37L).build(),
        CreateModuleRequest.builder().courseId(30L).title("Proyecto final 1")
            .description("Actividad para reforzar el tema.").order(1).duration(41L).build(),
        CreateModuleRequest.builder().courseId(30L).title("Resumen y repaso 2")
            .description("Aprende los aspectos esenciales.").order(2).duration(42L).build(),
        CreateModuleRequest.builder().courseId(30L).title("Conceptos clave 3")
            .description("Actividad para reforzar el tema.").order(3).duration(57L).build(),
        CreateModuleRequest.builder().courseId(31L).title("Herramientas y recursos 1")
            .description("Conceptos teóricos con ejemplos.").order(1).duration(21L).build(),
        CreateModuleRequest.builder().courseId(31L).title("Proyecto final 2").description("Evaluación del módulo.")
            .order(2).duration(40L).build(),
        CreateModuleRequest.builder().courseId(31L).title("Resumen y repaso 3")
            .description("Aplicación de conocimientos previos.").order(3).duration(24L).build(),
        CreateModuleRequest.builder().courseId(32L).title("Práctica guiada 1")
            .description("Desarrollo de una solución real.").order(1).duration(30L).build(),
        CreateModuleRequest.builder().courseId(32L).title("Herramientas y recursos 2")
            .description("Repasa y consolida lo aprendido.").order(2).duration(31L).build(),
        CreateModuleRequest.builder().courseId(32L).title("Proyecto final 3")
            .description("Aplicación de conocimientos previos.").order(3).duration(32L).build(),
        CreateModuleRequest.builder().courseId(32L).title("Introducción 4")
            .description("Aplicación de conocimientos previos.").order(4).duration(60L).build(),
        CreateModuleRequest.builder().courseId(32L).title("Proyecto final 5").description("Evaluación del módulo.")
            .order(5).duration(28L).build(),
        CreateModuleRequest.builder().courseId(33L).title("Proyecto final 1")
            .description("Actividad para reforzar el tema.").order(1).duration(25L).build(),
        CreateModuleRequest.builder().courseId(33L).title("Herramientas y recursos 2")
            .description("Conceptos teóricos con ejemplos.").order(2).duration(35L).build(),
        CreateModuleRequest.builder().courseId(34L).title("Técnicas avanzadas 1")
            .description("Desarrollo de una solución real.").order(1).duration(41L).build(),
        CreateModuleRequest.builder().courseId(34L).title("Conceptos clave 2")
            .description("Actividad para reforzar el tema.").order(2).duration(46L).build(),
        CreateModuleRequest.builder().courseId(34L).title("Teoría aplicada 3")
            .description("Explora herramientas del entorno.").order(3).duration(40L).build(),
        CreateModuleRequest.builder().courseId(34L).title("Práctica guiada 4").description("Evaluación del módulo.")
            .order(4).duration(21L).build(),
        CreateModuleRequest.builder().courseId(35L).title("Fundamentos 1").description("Evaluación del módulo.")
            .order(1).duration(25L).build(),
        CreateModuleRequest.builder().courseId(35L).title("Introducción 2")
            .description("Aplicación de conocimientos previos.").order(2).duration(23L).build(),
        CreateModuleRequest.builder().courseId(36L).title("Técnicas avanzadas 1").description("Evaluación del módulo.")
            .order(1).duration(51L).build(),
        CreateModuleRequest.builder().courseId(36L).title("Técnicas avanzadas 2")
            .description("Desarrollo de una solución real.").order(2).duration(50L).build(),
        CreateModuleRequest.builder().courseId(36L).title("Técnicas avanzadas 3")
            .description("Simula situaciones reales.").order(3).duration(50L).build(),
        CreateModuleRequest.builder().courseId(37L).title("Herramientas y recursos 1")
            .description("Ejemplos prácticos paso a paso.").order(1).duration(27L).build(),
        CreateModuleRequest.builder().courseId(37L).title("Casos reales 2")
            .description("Explora herramientas del entorno.").order(2).duration(29L).build(),
        CreateModuleRequest.builder().courseId(37L).title("Práctica guiada 3")
            .description("Conceptos teóricos con ejemplos.").order(3).duration(59L).build(),
        CreateModuleRequest.builder().courseId(38L).title("Fundamentos 1")
            .description("Ejemplos prácticos paso a paso.").order(1).duration(20L).build(),
        CreateModuleRequest.builder().courseId(38L).title("Proyecto final 2")
            .description("Aprende los aspectos esenciales.").order(2).duration(23L).build(),
        CreateModuleRequest.builder().courseId(39L).title("Técnicas avanzadas 1")
            .description("Explora herramientas del entorno.").order(1).duration(47L).build(),
        CreateModuleRequest.builder().courseId(39L).title("Fundamentos 2")
            .description("Desarrollo de una solución real.").order(2).duration(24L).build(),
        CreateModuleRequest.builder().courseId(39L).title("Práctica guiada 3")
            .description("Desarrollo de una solución real.").order(3).duration(57L).build(),
        CreateModuleRequest.builder().courseId(39L).title("Teoría aplicada 4")
            .description("Aprende los aspectos esenciales.").order(4).duration(54L).build(),
        CreateModuleRequest.builder().courseId(39L).title("Práctica guiada 5").description("Evaluación del módulo.")
            .order(5).duration(41L).build(),
        CreateModuleRequest.builder().courseId(40L).title("Práctica guiada 1")
            .description("Conceptos teóricos con ejemplos.").order(1).duration(20L).build(),
        CreateModuleRequest.builder().courseId(40L).title("Resumen y repaso 2")
            .description("Aprende los aspectos esenciales.").order(2).duration(57L).build(),
        CreateModuleRequest.builder().courseId(41L).title("Herramientas y recursos 1")
            .description("Explora herramientas del entorno.").order(1).duration(55L).build(),
        CreateModuleRequest.builder().courseId(41L).title("Herramientas y recursos 2")
            .description("Actividad para reforzar el tema.").order(2).duration(45L).build(),
        CreateModuleRequest.builder().courseId(41L).title("Herramientas y recursos 3")
            .description("Conceptos teóricos con ejemplos.").order(3).duration(31L).build(),
        CreateModuleRequest.builder().courseId(42L).title("Teoría aplicada 1")
            .description("Explora herramientas del entorno.").order(1).duration(57L).build(),
        CreateModuleRequest.builder().courseId(42L).title("Introducción 2")
            .description("Actividad para reforzar el tema.").order(2).duration(20L).build(),
        CreateModuleRequest.builder().courseId(42L).title("Técnicas avanzadas 3")
            .description("Repasa y consolida lo aprendido.").order(3).duration(56L).build(),
        CreateModuleRequest.builder().courseId(42L).title("Introducción 4")
            .description("Repasa y consolida lo aprendido.").order(4).duration(57L).build(),
        CreateModuleRequest.builder().courseId(42L).title("Práctica guiada 5")
            .description("Explora herramientas del entorno.").order(5).duration(54L).build(),
        CreateModuleRequest.builder().courseId(43L).title("Técnicas avanzadas 1").description("Evaluación del módulo.")
            .order(1).duration(29L).build(),
        CreateModuleRequest.builder().courseId(43L).title("Casos reales 2").description("Evaluación del módulo.")
            .order(2).duration(31L).build(),
        CreateModuleRequest.builder().courseId(43L).title("Teoría aplicada 3")
            .description("Conceptos teóricos con ejemplos.").order(3).duration(20L).build(),
        CreateModuleRequest.builder().courseId(43L).title("Teoría aplicada 4")
            .description("Desarrollo de una solución real.").order(4).duration(39L).build(),
        CreateModuleRequest.builder().courseId(43L).title("Introducción 5").description("Simula situaciones reales.")
            .order(5).duration(34L).build(),
        CreateModuleRequest.builder().courseId(44L).title("Casos reales 1")
            .description("Actividad para reforzar el tema.").order(1).duration(59L).build(),
        CreateModuleRequest.builder().courseId(44L).title("Práctica guiada 2")
            .description("Actividad para reforzar el tema.").order(2).duration(39L).build(),
        CreateModuleRequest.builder().courseId(45L).title("Casos reales 1")
            .description("Repasa y consolida lo aprendido.").order(1).duration(31L).build(),
        CreateModuleRequest.builder().courseId(45L).title("Proyecto final 2").description("Evaluación del módulo.")
            .order(2).duration(27L).build(),
        CreateModuleRequest.builder().courseId(45L).title("Herramientas y recursos 3")
            .description("Simula situaciones reales.").order(3).duration(52L).build(),
        CreateModuleRequest.builder().courseId(45L).title("Práctica guiada 4")
            .description("Conceptos teóricos con ejemplos.").order(4).duration(49L).build(),
        CreateModuleRequest.builder().courseId(46L).title("Proyecto final 1")
            .description("Conceptos teóricos con ejemplos.").order(1).duration(51L).build(),
        CreateModuleRequest.builder().courseId(46L).title("Resumen y repaso 2")
            .description("Explora herramientas del entorno.").order(2).duration(35L).build(),
        CreateModuleRequest.builder().courseId(46L).title("Casos reales 3")
            .description("Explora herramientas del entorno.").order(3).duration(31L).build(),
        CreateModuleRequest.builder().courseId(46L).title("Resumen y repaso 4")
            .description("Simula situaciones reales.").order(4).duration(22L).build(),
        CreateModuleRequest.builder().courseId(47L).title("Fundamentos 1")
            .description("Aplicación de conocimientos previos.").order(1).duration(42L).build(),
        CreateModuleRequest.builder().courseId(47L).title("Resumen y repaso 2")
            .description("Repasa y consolida lo aprendido.").order(2).duration(47L).build(),
        CreateModuleRequest.builder().courseId(47L).title("Proyecto final 3").description("Simula situaciones reales.")
            .order(3).duration(49L).build(),
        CreateModuleRequest.builder().courseId(48L).title("Conceptos clave 1")
            .description("Aprende los aspectos esenciales.").order(1).duration(35L).build(),
        CreateModuleRequest.builder().courseId(48L).title("Casos reales 2")
            .description("Explora herramientas del entorno.").order(2).duration(37L).build(),
        CreateModuleRequest.builder().courseId(48L).title("Proyecto final 3")
            .description("Ejemplos prácticos paso a paso.").order(3).duration(30L).build(),
        CreateModuleRequest.builder().courseId(48L).title("Técnicas avanzadas 4")
            .description("Ejemplos prácticos paso a paso.").order(4).duration(30L).build());

    modules.forEach(module -> createModulePort.create(module));
  }
}
