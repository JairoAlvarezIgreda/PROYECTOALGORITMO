Gracias por compartir los resultados del benchmark. Aquí tienes un análisis
claro del rendimiento entre ambas versiones de Quarkus: la _JAR (JVM)_ y la
_nativa (binaria con GraalVM/Mandrel)_.

---

### 📊 _Comparación de Rendimiento_

| Métrica            | JAR (JVM)   | Nativo (Binario) | Comentario                                           |
| ------------------ | ----------- | ---------------- | ---------------------------------------------------- |
| ⁠ rps_median ⁠     | _5135_      | 3447             | JVM supera al binario en throughput promedio         |
| ⁠ rps_p99 ⁠        | _5007_      | 3333             | JVM más consistente incluso en percentil 99          |
| ⁠ latency_median ⁠ | _3050 ms_   | 4627 ms          | JVM tiene menor latencia promedio                    |
| ⁠ latency_p99 ⁠    | _55,080 ms_ | _57,042 ms_      | Muy parecidos, pero JVM sigue siendo un poco mejor   |
| ⁠ memory_median ⁠  | 194 MB      | _89 MB_          | Binario usa menos de la _mitad de RAM_               |
| ⁠ memory_p99 ⁠     | 197 MB      | _154 MB_         | Binario mantiene ventaja también en picos de memoria |
| ⁠ errors ⁠         | 0           | 0                | Ambos estables                                       |

---

### 🧠 _Interpretación_

#### 🔥 JVM (JAR)

•⁠ ⁠*Ventajas*:

- Mayor _throughput (RPS)_.
- Menor _latencia promedio_.
- _Más maduro_ para ejecución continua (JIT optimiza en tiempo real). •⁠
  ⁠*Desventajas*:

- Mayor consumo de memoria.
- Arranque más lento (no medido aquí, pero típico de la JVM).

#### ❄️ Nativo (Binario)

•⁠ ⁠*Ventajas*:

- Mucho _menor consumo de memoria_.
- Ideal para entornos _serverless_ o _contenedores efímeros_ (ej. Kubernetes).
- Arranque ultrarrápido (no lo mediste, pero suele ser 10-100x más rápido). •⁠
  ⁠*Desventajas*:

- _Peor throughput y latencia_, porque no tiene JIT (compilación en tiempo de
  ejecución).
- Compilación nativa es _más lenta_ y compleja.

---

### 💡 Recomendación

Dependerá de tu caso:

| Caso de uso                                          | Recomendación      |
| ---------------------------------------------------- | ------------------ |
| Alta concurrencia, servicio expuesto 24/7            | _JVM (JAR)_        |
| Bajo consumo, arranque rápido, serverless            | _Binario (nativo)_ |
| Microservicios en Kubernetes con escalado automático | _Binario (nativo)_ |
| Entornos de alta carga como API Gateway              | _JVM (JAR)_        |

---

### 🧰 Mejora posible para el binario

Si te interesa mejorar el rendimiento del nativo:

•⁠ ⁠Usa _⁠ -Dquarkus.native.enable-fallback-images=false ⁠_. •⁠ ⁠Asegúrate de
_afinar el GC_ (Garbage Collector) usando ⁠ --gc=serial ⁠ o ⁠ --gc=G1 ⁠ si
Mandrel lo permite. •⁠ ⁠Usa el _flag de vectorización (⁠ --enable-monitoring ⁠,
⁠ --enable-all-security-services ⁠)_ si aplicable. •⁠ ⁠Agrega
⁠ quarkus.native.additional-build-args=--initialize-at-run-time=<your packages> ⁠
para reducir carga estática.

¿Quieres que te ayude a afinar el ⁠ application.properties ⁠ o los
⁠ build-args ⁠ para un perfil más agresivo o balanceado?
