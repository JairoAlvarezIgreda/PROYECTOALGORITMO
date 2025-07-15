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
        CreateCursoRequest.builder().name("Curso de Java desde cero").littleDescription("Inicia tu camino en Java")
            .description("Aprende Java paso a paso").tags("java,programación").price(49.99).categoryId(1L)
            .imagePath("/course/Java-desde-Cero.PNG").build(),

        CreateCursoRequest.builder().name("Java Intermedio").littleDescription("Sigue avanzando")
            .description("Manejo de colecciones, excepciones y más").tags("java,intermedio").price(59.99).categoryId(1L)
            .imagePath("/course/Java-Intermedio.PNG")
            .build(),

        CreateCursoRequest.builder().name("Spring Boot desde cero").littleDescription("Aprende Spring")
            .description("Crea APIs REST con Spring Boot").tags("spring,backend").price(69.99).categoryId(2L)
            .imagePath("/course/Spring-Boot.PNG").build(),

        CreateCursoRequest.builder().name("Curso de HTML y CSS").littleDescription("Diseña tu web")
            .description("Crea páginas web atractivas con HTML y CSS").tags("html,css,frontend").price(29.99)
            .categoryId(3L).imagePath("/course/HTML-y-CSS.PNG").build(),

        CreateCursoRequest.builder().name("JavaScript Básico").littleDescription("Tu primer script")
            .description("Fundamentos de JavaScript desde cero").tags("javascript,frontend").price(39.99).categoryId(3L)
            .imagePath("/course/Javascript.PNG")
            .build(),

        CreateCursoRequest.builder().name("React para principiantes").littleDescription("Apps con React")
            .description("Aprende React desde cero").tags("react,frontend").price(59.99).categoryId(3L)
            .imagePath("/course/React.PNG").build(),

        CreateCursoRequest.builder().name("Curso de Node.js").littleDescription("Backend con JS")
            .description("Construye servidores con Node.js").tags("nodejs,backend").price(49.99).categoryId(4L)
            .imagePath("/course/Node.js.PNG").build(),

        CreateCursoRequest.builder().name("Python para Data Science").littleDescription("Datos con Python")
            .description("Manejo de pandas, NumPy, matplotlib").tags("python,data").price(69.99).categoryId(5L)
            .imagePath("/course/Python-Data-Science.PNG").build(),

        CreateCursoRequest.builder().name("Machine Learning con Python").littleDescription("ML fácil")
            .description("Modelos predictivos con scikit-learn").tags("ml,python").price(89.99).categoryId(5L)
            .imagePath("/course/Machine-Learning.PNG").build(),

        CreateCursoRequest.builder().name("Curso de SQL").littleDescription("Base de datos fácil")
            .description("Consultas básicas y avanzadas en SQL").tags("sql,base de datos").price(34.99).categoryId(6L)
            .imagePath("/course/SQL.PNG")
            .build(),

        CreateCursoRequest.builder().name("MongoDB desde cero").littleDescription("NoSQL fácil")
            .description("Aprende MongoDB con ejemplos prácticos").tags("mongodb,nosql").price(39.99).categoryId(6L)
            .imagePath("/course/MongoDB.PNG")
            .build(),

        CreateCursoRequest.builder().name("Curso de Git y GitHub").littleDescription("Control de versiones")
            .description("Flujo Git, ramas, merges, GitHub Pages").tags("git,github").price(19.99).categoryId(7L)
            .imagePath("/course/Git-y-GitHub.PNG")
            .build(),

        CreateCursoRequest.builder().name("Curso de Kotlin").littleDescription("Android moderno")
            .description("Sintaxis moderna y funcional en Kotlin").tags("kotlin,android").price(44.99).categoryId(1L)
            .imagePath("/course/Kotlin.PNG")
            .build(),

        CreateCursoRequest.builder().name("Android Studio desde cero").littleDescription("Apps móviles")
            .description("Crea tu primera app con Android Studio").tags("android,kotlin").price(59.99).categoryId(1L)
            .imagePath("/course/Android-Studio.PNG")
            .build(),

        CreateCursoRequest.builder().name("Curso de Flutter").littleDescription("Apps móviles con Dart")
            .description("Desarrolla apps nativas con Flutter").tags("flutter,dart").price(64.99).categoryId(1L)
            .imagePath("/course/Flutter.PNG")
            .build(),

        CreateCursoRequest.builder().name("Curso de Unity 2D").littleDescription("Juegos en 2D")
            .description("Desarrolla videojuegos con Unity").tags("unity,juegos").price(74.99).categoryId(8L)
            .imagePath("/course/Unity-2D.PNG").build(),

        CreateCursoRequest.builder().name("Curso de Unreal Engine").littleDescription("Juegos 3D")
            .description("Motor gráfico profesional para videojuegos").tags("unreal,juegos").price(89.99).categoryId(8L)
            .imagePath("/course/Unreal-Engine.PNG")
            .build(),

        CreateCursoRequest.builder().name("Curso de C++").littleDescription("Fundamentos de C++")
            .description("Programación estructurada y orientada a objetos").tags("c++,programación").price(49.99)
            .categoryId(1L).imagePath("/course/C-Plus-Plus.PNG").build(),

        CreateCursoRequest.builder().name("Algoritmos y estructuras de datos")
            .littleDescription("Resolviendo problemas").description("Listas, pilas, colas, árboles, grafos")
            .tags("algoritmos,estructuras").price(59.99).categoryId(1L).imagePath("/course/Alg&EstructuraDatos.PNG")
            .build(),

        CreateCursoRequest.builder().name("Curso de C#").littleDescription("Programación con .NET")
            .description("Crea aplicaciones con C# y .NET").tags("csharp,dotnet").price(59.99).categoryId(1L)
            .imagePath("/course/C-Sharp.PNG").build(),

        CreateCursoRequest.builder().name("Curso de PHP").littleDescription("Backend clásico")
            .description("Desarrolla sitios web con PHP").tags("php,backend").price(34.99).categoryId(4L)
            .imagePath("/course/PHP.PNG").build(),

        CreateCursoRequest.builder().name("Laravel desde cero").littleDescription("Framework de PHP")
            .description("Aprende Laravel paso a paso").tags("laravel,php").price(49.99).categoryId(4L)
            .imagePath("/course/Laravel.PNG").build(),

        CreateCursoRequest.builder().name("Curso de Ruby on Rails").littleDescription("Backend rápido")
            .description("Desarrollo ágil con Ruby y Rails").tags("ruby,rails").price(59.99).categoryId(4L)
            .imagePath("/course/Ruby-on-Rails.PNG").build(),

        CreateCursoRequest.builder().name("Diseño UX/UI").littleDescription("Diseña con propósito")
            .description("Principios de diseño enfocado al usuario").tags("ux,ui").price(44.99).categoryId(9L)
            .imagePath("/course/Diseño-UX_UI.PNG").build(),

        CreateCursoRequest.builder().name("Curso de Figma").littleDescription("Diseña prototipos")
            .description("Diseño moderno y colaborativo con Figma").tags("figma,diseño").price(34.99).categoryId(9L)
            .imagePath("/course/Figma.PNG")
            .build(),

        CreateCursoRequest.builder().name("Blender 3D desde cero").littleDescription("Modelado y animación")
            .description("Aprende a crear modelos y renders").tags("blender,3d").price(54.99).categoryId(8L)
            .imagePath("/course/Blender-3D.PNG").build(),

        CreateCursoRequest.builder().name("Curso de Excel Profesional").littleDescription("Tablas y fórmulas")
            .description("Dominio avanzado de Excel").tags("excel,ofimática").price(29.99).categoryId(10L)
            .imagePath("/course/Excel-Profesional.PNG").build(),

        CreateCursoRequest.builder().name("Power BI desde cero").littleDescription("Visualiza tus datos")
            .description("Dashboards, gráficos, reportes").tags("powerbi,dashboard").price(39.99).categoryId(10L)
            .imagePath("/course/Power-BI.PNG")
            .build(),

        CreateCursoRequest.builder().name("Curso de Finanzas Personales").littleDescription("Administra tu dinero")
            .description("Presupuesto, ahorro, inversión").tags("finanzas,ahorro").price(24.99).categoryId(11L)
            .imagePath("/course/Finanzas-Personales.PNG").build(),

        CreateCursoRequest.builder().name("Curso de Inglés A1").littleDescription("Inglés básico")
            .description("Gramática y vocabulario esencial").tags("inglés,idiomas").price(39.99).categoryId(12L)
            .imagePath("/course/Inglés-A1.PNG")
            .build(),

        CreateCursoRequest.builder().name("Inglés para negocios").littleDescription("Comunicación profesional")
            .description("Inglés aplicado al entorno laboral").tags("inglés,business").price(49.99).categoryId(12L)
            .imagePath("/course/Inglés-para-Negocios.PNG")
            .build(),

        CreateCursoRequest.builder().name("Francés básico").littleDescription("Inicia en francés")
            .description("Lo esencial del idioma francés").tags("francés,idiomas").price(39.99).categoryId(12L)
            .imagePath("/course/Francés.PNG").build(),

        CreateCursoRequest.builder().name("Curso de fotografía").littleDescription("Captura como un pro")
            .description("Técnicas, encuadres, edición básica").tags("fotografía,cámara").price(44.99).categoryId(13L)
            .imagePath("/course/Fotografía.PNG")
            .build(),

        CreateCursoRequest.builder().name("Curso de edición con Photoshop").littleDescription("Edita imágenes pro")
            .description("Aprende a usar Adobe Photoshop").tags("photoshop,diseño").price(49.99).categoryId(13L)
            .imagePath("/course/EdiciónPhotoshop.PNG")
            .build(),

        CreateCursoRequest.builder().name("Curso de Illustrator").littleDescription("Diseño vectorial")
            .description("Crea logotipos y vectores").tags("illustrator,diseño").price(49.99).categoryId(13L)
            .imagePath("/course/Illustrator.PNG").build(),

        CreateCursoRequest.builder().name("Curso de Copywriting").littleDescription("Escribe para vender")
            .description("Técnicas de redacción persuasiva").tags("copywriting,marketing").price(39.99).categoryId(14L)
            .imagePath("/course/CopyWriting.PNG")
            .build(),

        CreateCursoRequest.builder().name("Curso de SEO").littleDescription("Posiciónate en Google")
            .description("Técnicas para mejorar tu visibilidad").tags("seo,marketing").price(39.99).categoryId(14L)
            .imagePath("/course/SEO.PNG")
            .build(),

        CreateCursoRequest.builder().name("Curso de Marketing Digital").littleDescription("Estrategias online")
            .description("Publicidad, redes, email marketing").tags("marketing,redes").price(59.99).categoryId(14L)
            .imagePath("/course/Marketing-Digital.PNG")
            .build(),

        CreateCursoRequest.builder().name("Curso de Trading Básico").littleDescription("Invierte con criterio")
            .description("Análisis técnico y gestión de riesgo").tags("trading,inversión").price(69.99).categoryId(11L)
            .imagePath("/course/Trading-Básico.PNG")
            .build(),

        CreateCursoRequest.builder().name("Curso de Arduino").littleDescription("Electrónica práctica")
            .description("Construye proyectos con Arduino").tags("arduino,hardware").price(59.99).categoryId(15L)
            .imagePath("/course/Arduino.PNG")
            .build(),

        CreateCursoRequest.builder().name("Robótica educativa").littleDescription("Ciencia y tecnología")
            .description("Aprende lógica y robótica desde joven").tags("robótica,educación").price(49.99)
            .categoryId(15L).imagePath("/course/Robótica-Educativa.PNG").build(),

        CreateCursoRequest.builder().name("Curso de ética profesional").littleDescription("Valores y conducta")
            .description("Principios éticos en el trabajo").tags("ética,valores").price(29.99).categoryId(16L)
            .imagePath("/course/Ética-Profesional.PNG").build(),

        CreateCursoRequest.builder().name("Matemáticas para programadores").littleDescription("Matemática aplicada")
            .description("Lógica, álgebra, estructuras").tags("matemática,lógica").price(39.99).categoryId(1L)
            .imagePath("/course/Matemática-Programadores.PNG").build(),

        CreateCursoRequest.builder().name("Fundamentos de la computación").littleDescription("Ciencia básica")
            .description("Aprende cómo funcionan las computadoras").tags("computación,fundamentos").price(29.99)
            .categoryId(1L).imagePath("/course/Fundamentos-Computación.PNG").build(),

        CreateCursoRequest.builder().name("Curso de seguridad informática").littleDescription("Ciberseguridad esencial")
            .description("Protege tus sistemas y redes").tags("seguridad,hacking").price(69.99).categoryId(17L)
            .imagePath("/course/Seguridad-Informática.PNG").build(),

        CreateCursoRequest.builder().name("Curso de ética hacker").littleDescription("White hat hacking")
            .description("Seguridad ofensiva responsable").tags("hacking ético,ciberseguridad").price(74.99)
            .categoryId(17L).imagePath("/course/Ética-Hacker.PNG").build(),

        CreateCursoRequest.builder().name("Curso de Docker").littleDescription("Contenedores para devs")
            .description("Docker desde cero con ejemplos reales").tags("docker,devops").price(49.99).categoryId(18L)
            .imagePath("/course/Docker.PNG")
            .build(),

        CreateCursoRequest.builder().name("DevOps con Kubernetes").littleDescription("Orquesta tus servicios")
            .description("CI/CD con Kubernetes y Docker").tags("kubernetes,devops").price(79.99).categoryId(18L)
            .imagePath("/course/DevOps-con-Kubernetes.PNG")
            .build());

    for (CreateCursoRequest course : courses) {
      createCursoPort.create(course);
    }
  }
}
