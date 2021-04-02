#language:es
#Proyecto:prueba tecnica Wolox
#Elaborado por:Yorman Paul Martinez Acevedo

Característica: Validar endpoint del login
  Yo como analista de automatizacion
  Quiero realizar la mayor cantidad de pruebas al endpoint de login
  Para tener la mayor cobertura en pruebas posible

  Esquema del escenario: : Consumir login con credenciales <nombreEscenario> correctmante
    Dado que el Analista establece la url base
    Cuando ingresa las credenciales
      | email | <email> |
      | password  | <password>   |
    Entonces el servicio debe retornar un codigo valido

    Ejemplos:
      | nombreEscenario | email                | password           |
      | administrador   | admin@wolox.com.ar   | candidatoWolox2020 |
      | regular         | regular@wolox.com.ar | candidatoWolox2020 |

