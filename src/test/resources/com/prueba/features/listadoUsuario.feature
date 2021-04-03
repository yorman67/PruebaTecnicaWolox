#language:es
#Proyecto:prueba tecnica Wolox
#Elaborado por:Yorman Paul Martinez Acevedo

Característica: Validar endpoint de listado de usuarios
  Yo como analista de automatizacion
  Quiero realizar la mayor cantidad de pruebas al endpoint de listado de usurios
  Para tener la mayor cobertura en pruebas posible

  Esquema del escenario: consultar lista de usuarios como <nombreEscenario> correctmante
    Dado que el Analista establece la url base
    Cuando se consulta la lista con las credenciales
      | email    | <email>    |
      | password | <password> |
    Entonces el servicio debe retornar un codigo valido
    Ejemplos:
      | nombreEscenario | email | password |
     # | usuario administrador | admin@wolox.com.ar   | candidatoWolox2020 |
     # | usuario regular | regular@wolox.com.ar | candidatoWolox2020 |

   Esquema del escenario: validar el esquema de la respuesta del servicio
     Dado que el Analista establece la url base
     Cuando se consulta la lista con las credenciales
       | email    | <email>    |
       | password | <password> |
     Entonces valido el esquema del response con el esquema "<esquema>"

     Ejemplos:
       | nombreEscenario | email | password | esquema |
     #  | usuario administrador | admin@wolox.com.ar   | candidatoWolox2020 | listadoUsuarioSchema.json |
     #  | usuario regular | regular@wolox.com.ar | candidatoWolox2020 | listadoUsuarioSchema.json |


  Esquema del escenario: validar response segun credenciales
    Dado que el Analista establece la url base
    Cuando se consulta la lista con las credenciales
      | email    | <email>    |
      | password | <password> |
    Entonces se valida que el response sea correcto
    Ejemplos:
      | nombreEscenario       | email                | password           |
      | usuario administrador | admin@wolox.com.ar   | candidatoWolox2020 |
      | usuario regular       | regular@wolox.com.ar | candidatoWolox2020 |

