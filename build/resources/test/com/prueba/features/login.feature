#language:es
#Proyecto:prueba tecnica Wolox
#Elaborado por:Yorman Paul Martinez Acevedo

Característica: Validar endpoint del login
  Yo como analista de automatizacion
  Quiero realizar la mayor cantidad de pruebas al endpoint de login
  Para tener la mayor cobertura en pruebas posible

  Antecedentes:
    Dado que el Analista establece la url base
    Cuando ingresa las credenciales
      | email | <email> |
      | password  | <password>   |
    Ejemplos:
      | nombreEscenario       | email                | password           |
      | usuario administrador | admin@wolox.com.ar   | candidatoWolox2020 |
      | usuario regular       | regular@wolox.com.ar | candidatoWolox2020 |

  Escenario: :  Consumir login como <nombreEscenario> correctmante
    Entonces el servicio debe retornar un codigo valido



     Escenario: : Validar header response
      Entonces se valida los datos del header



      Escenario:squema
       Entonces valido el esquema del response




