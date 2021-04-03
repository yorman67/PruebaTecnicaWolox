#language:es
#Proyecto:prueba tecnica Wolox
#Elaborado por:Yorman Paul Martinez Acevedo

Característica: Validar endpoint del login
  Yo como analista de automatizacion
  Quiero realizar la mayor cantidad de pruebas al endpoint de login
  Para tener la mayor cobertura en pruebas posible


  Esquema del escenario: Consumir login como <nombreEscenario> correctmante
    Dado que el Analista establece la url base
    Cuando ingresa las credenciales
      | email | <email> |
      | password  | <password>   |
    Entonces el servicio debe retornar un codigo valido

    Ejemplos:
      | nombreEscenario       | email                | password           |
      | usuario administrador | admin@wolox.com.ar   | candidatoWolox2020 |
      | usuario regular       | regular@wolox.com.ar | candidatoWolox2020 |

    Esquema del escenario: Validar header response de <nombreEscenario>
      Dado que el Analista establece la url base
      Cuando ingresa las credenciales
        | email | <email> |
        | password  | <password>   |
      Entonces se valida los datos del header

      Ejemplos:
        | nombreEscenario       | email                | password           |
        | usuario administrador | admin@wolox.com.ar   | candidatoWolox2020 |
        | usuario regular       | regular@wolox.com.ar | candidatoWolox2020 |

  Esquema del escenario:validar esquema response <nombreEscenario>
        Dado que el Analista establece la url base
        Cuando ingresa las credenciales
          | email | <email> |
          | password  | <password>   |
       Entonces valido el esquema del response con el esquema "<esquema>"

        Ejemplos:
          | nombreEscenario       | email                | password           | esquema          |
          | usuario administrador | admin@wolox.com.ar   | candidatoWolox2020 | loginSchema.json |
          | usuario regular       | regular@wolox.com.ar | candidatoWolox2020 | loginSchema.json |


  Escenario: usuario no existe
    Dado que el Analista establece la url base
    Cuando ingresa las credenciales
      | email    | assasa@wolox.com.ar |
      | password | 1234pruebas         |
    Entonces se valida que la respuesta contenga el "Unable to authenticate credentials" y el 401


