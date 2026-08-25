# Día 1 — Setup y arquitectura

* [ ] Crea el proyecto en Spring Initializr con:

    * Spring Web
    * Spring Validation
    * Spring Boot DevTools
    * Lombok (opcional, pero ahorra boilerplate)
    * Thymeleaf
* [ ] Define la estructura de paquetes:

    * `controller`
    * `service`
    * `repository`
    * `model`
    * `exception`
    * `dto`
* [ ] Investiga la diferencia entre las tres capas:

    * **Controller**
    * **Service**
    * **Repository**
* [ ] Entiende por qué no deberías meter lógica de negocio directamente en el Controller.
* [ ] Crea un endpoint de prueba `/health` que devuelva `"OK"`.

**Objetivo del día:** proyecto arrancando en `localhost:8080` con `/health` funcionando.

---

# Día 2 — Modelo de datos

* [ ] Crea la clase `Operative` con los campos:

    * `id`
    * `name`
    * `codename`
    * `regenerationLevel`
    * `status`
    * `recruitmentDate`
* [ ] Crea el enum `OperativeStatus`:

    * `ACTIVE`
    * `ROGUE`
    * `CAPTURED`
* [ ] Añade Bean Validation:

    * `@NotBlank`
    * `@NotNull`
    * `@Min` / `@Max` para el nivel de regeneración
    * `@Past` o similar para la fecha
* [ ] Investiga la diferencia entre:

    * `@NotNull`
    * `@NotBlank`
    * `@NotEmpty`
* [ ] Asegúrate de que la clase modelo compila correctamente.

**Objetivo del día:** modelo completo y compilando, sin lógica de negocio todavía.

---

# Día 3 — Repositorio en memoria

* [ ] Crea `OperativeRepository`.
* [ ] Puedes implementarlo como:

    * una interfaz + implementación, o
    * directamente como una clase que utilice `Map<Long, Operative>`.
* [ ] Genera IDs autoincrementales sin base de datos utilizando `AtomicLong`.
* [ ] Implementa los métodos básicos:

    * guardar
    * buscar por ID
    * listar todos
    * eliminar
    * actualizar
* [ ] Investiga por qué `ConcurrentHashMap` es más seguro que un `HashMap` normal cuando existe concurrencia.
* [ ] Inserta algunos datos de ejemplo al arrancar mediante un `CommandLineRunner`, o crea un test rápido.

**Objetivo del día:** repositorio funcional y capaz de almacenar datos en memoria.

---

# Día 4 — Capa de servicio

* [ ] Crea `OperativeService`.
* [ ] Implementa la lógica de negocio para:

    * crear
    * listar
    * filtrar por estado
    * actualizar
    * eliminar
* [ ] Decide qué ocurre cuando no se encuentra un operativo.
* [ ] Crea una excepción que puedas utilizar posteriormente en el Día 6.
* [ ] Investiga por qué el Service no debería depender directamente de objetos HTTP como `HttpServletRequest`.
* [ ] Mantén la lógica de negocio desacoplada del transporte.
* [ ] Prueba el servicio mediante tests unitarios simples o prints temporales.

**Objetivo del día:** servicio completo y funcional.

---

# Día 5 — Controlador REST

* [ ] Crea `OperativeController`.
* [ ] Implementa los 6 endpoints definidos en tu tabla.
* [ ] Repasa las siguientes anotaciones:

    * `@RestController`
    * `@RequestMapping`
    * `@PostMapping`
    * `@GetMapping`
    * `@PutMapping`
    * `@DeleteMapping`
    * `@PathVariable`
    * `@RequestParam`
    * `@RequestBody`
* [ ] Implementa el filtrado por status:

    * `GET /operatives?status=ACTIVE`
* [ ] Investiga cómo utilizar un parámetro opcional con:

    * `@RequestParam(required = false)`
* [ ] Prueba todos los endpoints utilizando `curl` o Postman.
* [ ] Comprueba que los códigos HTTP sean correctos, especialmente `200` y `201`.

**Objetivo del día:** API REST funcional y accesible mediante HTTP.

---

# Día 6 — Validación y manejo de errores

* [ ] Añade `@Valid` al `@RequestBody` de los métodos `POST` y `PUT`.
* [ ] Crea una excepción personalizada:

    * `OperativeNotFoundException`
* [ ] Crea un `@ControllerAdvice`.
* [ ] Añade `@ExceptionHandler` para gestionar:

    * `MethodArgumentNotValidException`
    * `OperativeNotFoundException`
* [ ] Diseña una respuesta de error consistente con el formato del README:

    * `timestamp`
    * `status`
    * `error`
    * `message`
* [ ] Prueba un `POST` con datos inválidos.
* [ ] Comprueba que devuelve `400 Bad Request`.
* [ ] Prueba un `GET` con un ID inexistente.
* [ ] Comprueba que devuelve `404 Not Found`.
* [ ] Verifica que ambos casos utilizan el formato de error definido.

**Objetivo del día:** validación y manejo de errores centralizado y consistente.

---

# Día 7 — Pruebas, pulido y documentación

* [ ] Prueba manualmente todos los endpoints con Postman.
* [ ] Exporta la colección a:

    * `/postman`
* [ ] Revisa los códigos HTTP de cada respuesta.
* [ ] Comprueba especialmente:

    * `POST` → `201 Created`
    * `POST` → `Location` header
    * `GET` → `200 OK`
    * `PUT` → código correspondiente
    * `DELETE` → `204 No Content` o `200 OK`
    * errores de validación → `400 Bad Request`
    * recurso inexistente → `404 Not Found`
* [ ] Opcionalmente, añade una vista Thymeleaf para mostrar el listado en HTML además del JSON.
* [ ] Revisa el README y asegúrate de que coincide con la implementación real.
* [ ] Limpia código innecesario y revisa nombres de clases y métodos.
* [ ] Sube el proyecto a GitHub.
* [ ] Comprueba que el README explica:

    * cómo arrancar el proyecto
    * endpoints disponibles
    * ejemplos de peticiones
    * respuestas
    * códigos HTTP
    * cómo ejecutar los tests
* [ ] Incluye la colección de Postman en el repositorio.

**Objetivo del día:** proyecto terminado, documentado, probado y subido a GitHub.
