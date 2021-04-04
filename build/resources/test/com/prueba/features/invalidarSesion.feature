#language:es
#Proyecto:prueba tecnica Wolox
#Elaborado por:Yorman Paul Martinez Acevedo

Característica: Validar endpoint de invalidar sesion
  Yo como analista de automatizacion
  Quiero realizar la mayor cantidad de pruebas al endpoint de compra de invalidar sesion
  Para tener la mayor cobertura en pruebas posible

  Esquema del escenario: invalidar otros usuarios como <nombreEscenario>
    Dado que el Analista establece la url base
    Y consulta el token con credenciales
      | email    | <email>    |
      | password | <password> |
    Cuando se invalida el usuario
    Entonces se valida que la respuesta contenga el "<error>" y el <codigo>
    Ejemplos:
      | nombreEscenario       |  | email                | password           | error | codigo |
      | usuario administrador |  | admin@wolox.com.ar   | candidatoWolox2020 |       | 200    |
      | usuario regular       |  | regular@wolox.com.ar | candidatoWolox2020 |       | 422    |