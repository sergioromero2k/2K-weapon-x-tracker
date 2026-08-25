
## Endpoint
---
* Es una dirección concreta de tu API a la que puedes hacer una petición HTTP para realizar una acción o recibir información.
Por ejemplo, si tu aplicación corre en: ``http://localhost:8080`` y creas: `GET /health` tu endpoint completo sería: `http://localhost:8080/health` cunando haces una petición: `curl http://localhost:8080/health`.
Spring recibe esta petición y puede responder: ``OK``.

| Método   | Ruta            | Significado                   |
| -------- | --------------- | ----------------------------- |
| `GET`    | `/health`       | Comprobar que la API funciona |
| `GET`    | `/operatives`   | Obtener operativos            |
| `POST`   | `/operatives`   | Crear un operativo            |
| `GET`    | `/operatives/1` | Obtener el operativo con ID 1 |
| `PUT`    | `/operatives/1` | Actualizar el operativo 1     |
| `DELETE` | `/operatives/1` | Eliminar el operativo 1       |

* Las 3 capas sirven para separar responsabilidades. La idea principal es que cada parte del programa tenga un trabajo concreto. En spring. ``@Controller``, `@Service`, `@Repository` son estereotipos que representan precisamente las capas de representación, servicio y persistencia.

### ``Controller - recibe las peticiones HTTP`` es la puerta de entrada de tu API.
Se encarga de:
* Recibir peticiones HTTP.
* Leer parámetros, ``PathVariable``, `RequestBody`, etc.
* Llamar al Service.
* Devolver una petición HTTP.
```java
@RestController
@RequestMapping("/operatives")
public class OperativeController {

  @GetMapping
  public List<Operative> getAll() {
    return operativeService.findAll();
  }
} 
```
Si alguien hace: ``GET /operatives``. El controller recibe la petición y llama al Service.

### ``Service`` contiene la lógica de negocio es donde colocar las decisiones y reglas de tu aplicación.
* El controller **no debería decidir** si un operativo puede crearse o no.
El controller simplemente dice: ``"Me han pedido crear un operativo."`` y el Service decide: `"¿Este operativo cumple las reglas de negocio?"`.
`@Service` es un estereotipo de Spring destinado específicamente a la capa de servicio.


```java
@Service
public class OperativeService {

  public Operative create(Operative operative) {
    if (operative.getRegenerationLevel() < 1) {
      throw new IllegalArgumentException("Nivel inválido");
    }

    return operativeRepository.save(operative);
  }
}
```





