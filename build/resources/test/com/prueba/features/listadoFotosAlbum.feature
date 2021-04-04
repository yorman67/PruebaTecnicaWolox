#language:es
#Proyecto:prueba tecnica Wolox
#Elaborado por:Yorman Paul Martinez Acevedo

Característica: Validar endpoint de fotos por almbum
  Yo como analista de automatizacion
  Quiero realizar la mayor cantidad de pruebas al endpoint de fotos por almbum
  Para tener la mayor cobertura en pruebas posible

  Esquema del escenario: consultar fotos de los correctmante con <nombreEscenario>
    Dado que el Analista establece la url base
    Y consulta el token con credenciales
      | email    | <email>    |
      | password | <password> |
    Cuando se consultan la fotos del almbum
    Entonces el servicio debe retornar un codigo valido
    Ejemplos:
      | nombreEscenario       | email                | password           |
      | usuario administrador | admin@wolox.com.ar   | candidatoWolox2020 |
      | usuario regular       | regular@wolox.com.ar | candidatoWolox2020 |

  Esquema del escenario: consultar fotos de un album que no existe con <nombreEscenario>
    Dado que el Analista establece la url base
    Y consulta el token con credenciales
      | email    | <email>    |
      | password | <password> |
    Cuando se consultan la fotos del almbum con id no existente
    Entonces el servicio debe retornar un codigo invalido
    Ejemplos:
      | nombreEscenario       | email                | password           |
      | usuario administrador | admin@wolox.com.ar   | candidatoWolox2020 |
      | usuario regular       | regular@wolox.com.ar | candidatoWolox2020 |


  Esquema del escenario: validar el esquema de la respuesta del servicio
    Dado que el Analista establece la url base
    Y consulta el token con credenciales
      | email    | <email>    |
      | password | <password> |
    Cuando se consultan la fotos del almbum
    Entonces valido el esquema del response con el esquema "<esquema>"

    Ejemplos:
      | nombreEscenario       | email                | password           | esquema                 |
      | usuario administrador | admin@wolox.com.ar   | candidatoWolox2020 | fotosAlbumesSchema.json |
      | usuario regular       | regular@wolox.com.ar | candidatoWolox2020 | fotosAlbumesSchema.json |

  Escenario: Validar token incorrecto
    Dado que el Analista establece la url base
    Y el token no sea valiado
    Cuando se consultan la fotos del almbum
    Entonces se valida que la respuesta contenga el "Invalid token" y el 401

  Escenario: valdiar squema de error
    Dado que el Analista establece la url base
    Y el token no sea valiado
    Cuando se consultan la fotos del almbum
    Entonces valido el esquema del response con el esquema "errorSchema.json"