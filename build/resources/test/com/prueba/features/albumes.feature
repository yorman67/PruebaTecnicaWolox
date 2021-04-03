#language:es
#Proyecto:prueba tecnica Wolox
#Elaborado por:Yorman Paul Martinez Acevedo

Característica: Validar endpoint de albumes
  Yo como analista de automatizacion
  Quiero realizar la mayor cantidad de pruebas al endpoint de albumes
  Para tener la mayor cobertura en pruebas posible

  Esquema del escenario: consultar albumes correctmante con <nombreEscenario>
    Dado que el Analista establece la url base
    Y consulta el token con credenciales
      | email    | <email>    |
      | password | <password> |
    Cuando se consultan los albumes
    Entonces el servicio debe retornar un codigo valido
    Ejemplos:
      | nombreEscenario       | email                | password           |
      | usuario administrador | admin@wolox.com.ar   | candidatoWolox2020 |
      | usuario regular       | regular@wolox.com.ar | candidatoWolox2020 |

