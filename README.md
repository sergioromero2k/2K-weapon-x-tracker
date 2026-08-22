# Weapon-X Tracker

**REST API de gestión de operativos construida con Spring Boot**

Una API REST completa para gestionar "operativos" de un programa secreto (piensa en ellos como empleados/agentes), con operaciones CRUD, filtrado, validación de datos y manejo centralizado de errores.

---

## Descripción

Weapon-X Tracker simula el backend de un sistema de gestión de personal: alta, baja, modificación y consulta de operativos, cada uno con su alias, nivel de capacidad, estado operativo y fecha de reclutamiento. El proyecto está pensado como ejercicio de consolidación de Spring Boot a nivel profesional, aplicando buenas prácticas de diseño de APIs REST.

## Funcionalidades

- **CRUD completo** de operativos: crear, listar, consultar por ID, actualizar y eliminar
- **Filtrado por estado**: `GET /operatives?status=ACTIVE`
- **Validación de entrada** con las anotaciones estándar de Spring (`@Valid`, `@NotNull`, `@NotBlank`, etc.)
- **Manejo centralizado de errores** mediante `@ControllerAdvice` / `@ExceptionHandler`
- **Respuestas JSON consistentes** con los códigos HTTP correctos (`200`, `201`, `400`, `404`)
- **Persistencia en memoria** (sin base de datos todavía — se añadirá en una siguiente iteración del proyecto)


## Tecnologías
- Java 17+
- Spring Boot (Spring Web, Spring Data — sin base de datos aún, almacenamiento en memoria)
- Thymeleaf (vista HTML generada en servidor)
- Maven

## Modelo de datos

### `Operative`

| Campo | Tipo | Descripción |
|---|---|---|
| `id` | `Long` | Identificador único (autogenerado) |
| `name` | `String` | Nombre real del operativo |
| `codename` | `String` | Alias / código clave |
| `regenerationLevel` | `int` | Nivel de regeneración/capacidad |
| `status` | `Enum` | `ACTIVE`, `ROGUE`, `CAPTURED` |
| `recruitmentDate` | `LocalDate` | Fecha de reclutamiento |

## Tecnologías

- **Java** + **Spring Boot**
- **Spring Web** (`@RestController`, `@RequestBody`, `@PathVariable`, `@RequestParam`)
- **Spring Validation** (`@Valid` y anotaciones de Bean Validation)
- **Postman** para pruebas manuales de los endpoints

## Endpoints

| Método | Endpoint | Descripción |
|---|---|---|
| `POST` | `/operatives` | Crea un nuevo operativo |
| `GET` | `/operatives` | Lista todos los operativos |
| `GET` | `/operatives?status=ACTIVE` | Filtra operativos por estado |
| `GET` | `/operatives/{id}` | Obtiene un operativo por ID |
| `PUT` | `/operatives/{id}` | Actualiza un operativo existente |
| `DELETE` | `/operatives/{id}` | Elimina un operativo |

### Ejemplo de request (`POST /operatives`)

```json
{
  "name": "James Howlett",
  "codename": "Logan",
  "regenerationLevel": 9,
  "status": "ACTIVE",
  "recruitmentDate": "1974-05-12"
}
```

### Ejemplo de respuesta de error (`404`)

```json
{
  "timestamp": "2026-08-22T10:15:30",
  "status": 404,
  "error": "Not Found",
  "message": "Operative with id 42 not found"
}
```

## Cómo ejecutar el proyecto

```bash
# Clonar el repositorio
git clone https://github.com/tu-usuario/weapon-x-tracker.git
cd weapon-x-tracker

# Ejecutar con Maven
./mvnw spring-boot:run
```

La API quedará disponible en `http://localhost:8080`.

## Pruebas

El proyecto se probó manualmente con Postman. Puedes importar la colección incluida en `/postman` (si aplica) o probar los endpoints directamente con `curl`:

```bash
curl -X GET http://localhost:8080/operatives
```

## Próximos pasos

Este es el primer proyecto de una serie orientada a construir un backend cada vez más completo. Las siguientes iteraciones incluirán persistencia real en base de datos, autenticación y otras capas de infraestructura.

## Licencia

Este proyecto tiene fines educativos y de portafolio.