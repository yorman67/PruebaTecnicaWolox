#language:es
#Proyecto:prueba tecnica Wolox
#Elaborado por:Yorman Paul Martinez Acevedo

Característica: Validar endpoint de compra de albumes
  Yo como analista de automatizacion
  Quiero realizar la mayor cantidad de pruebas al endpoint de compra de albumes
  Para tener la mayor cobertura en pruebas posible


  Esquema del escenario: realizar compra de un album
    Dado que el Analista establece la url base
    Y consulta el token con credenciales
      | email    | <email>    |
      | password | <password> |
    Cuando se realiza la compra del album "<album>"
    Entonces valdiar la funcionalidad
    Ejemplos:
      | email | password | album |
      | admin@wolox.com.ar   | candidatoWolox2020 | 95    |
      | regular@wolox.com.ar | candidatoWolox2020 | 96    |

  Esquema del escenario: realizar compra de un album que no existe
    Dado que el Analista establece la url base
    Y consulta el token con credenciales
      | email    | <email>    |
      | password | <password> |
    Cuando se realiza la compra del album "<album>"
    Entonces se valida que la respuesta contenga el "<error>" y el <codigo>
    Ejemplos:
      | email                | password           | album | error           | codigo |
      | admin@wolox.com.ar   | candidatoWolox2020 | 101   | not_found_error | 404    |
      | regular@wolox.com.ar | candidatoWolox2020 | 102   | not_found_error | 404    |
