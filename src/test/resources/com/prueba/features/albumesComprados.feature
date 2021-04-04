#language:es
#Proyecto:prueba tecnica Wolox
#Elaborado por:Yorman Paul Martinez Acevedo

Característica: Validar endpoint de albumes comprados
  Yo como analista de automatizacion
  Quiero realizar la mayor cantidad de pruebas al endpoint de albumes comprados
  Para tener la mayor cobertura en pruebas posible

  Esquema del escenario: consultar albumes comprados correctmante
    Dado que el Analista establece la url base
    Y consulta el token con credenciales
      | email    | <email>    |
      | password | <password> |
    Cuando se consultan los albumes comprados
    Entonces el servicio debe retornar un codigo valido
    Ejemplos:
      | email                | password           |
      | admin@wolox.com.ar   | candidatoWolox2020 |
      | regular@wolox.com.ar | candidatoWolox2020 |

  Esquema del escenario: validar el esquema con <nombreEscenario>
    Dado que el Analista establece la url base
    Y consulta el token con credenciales
      | email    | <email>    |
      | password | <password> |
    Cuando se consultan los albumes comprados
    Entonces valido el esquema del response con el esquema "<esquema>"

    Ejemplos:
      | nombreEscenario       | email                | password           | esquema            |
      | usuario administrador | admin@wolox.com.ar   | candidatoWolox2020 | compraAlbumes.json |
      | usuario regular       | regular@wolox.com.ar | candidatoWolox2020 | compraAlbumes.json |

  Esquema del escenario: validar response
    Dado que el Analista establece la url base
    Y consulta el token con credenciales
      | email    | <email>    |
      | password | <password> |
    Cuando se consultan los albumes comprados
    Entonces se valida que la respuesta sea correcta

    Ejemplos:
      | nombreEscenario       | email                | password           |
      | usuario administrador | admin@wolox.com.ar   | candidatoWolox2020 |
      | usuario regular       | regular@wolox.com.ar | candidatoWolox2020 |