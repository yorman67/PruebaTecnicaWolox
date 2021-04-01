#language:es
#Proyecto:prueba tecnica Wolox
#Elaborado por:Yorman Paul Martinez Acevedo

Característica: Validar endpoint de registros
  Yo como analista de automatizacion
  Quiero realizar la mayor cantidad de pruebas al endpoint de registros
  Para tener la mayor cobertura en pruebas posible

  Escenario: Crear usuario exitoso
    Dado que el Analista establece la url base
    Cuando envia los datos correctos
    Entonces se valida la respuesta del servicio


  Escenario: Validar ingreso de valores numericos
    Dado que el Analista establece la url base
    Cuando ingrese los datos firstName y lastName con valores numericos
    Entonces  No se deberia crear el usuario


  Esquema del escenario:  Valadacion <nombreEscenario>
    Dado que el Analista establece la url base
    Cuando ingresa los datos no validos
      | email     | <email>     |
      | password  | <password>  |
      | firstName | <firstName> |
      | lastName  | <lastName>  |
    Entonces se valida que la respuesta contenga el "<error>"

    Ejemplos:
      | nombreEscenario                    | email                  | password   | firstName | lastName | error                                                                           |
      | correo con dominio diferente       | prueba@gmail.com       | Prueba123* | prueba1   | prueba1  | The email must be @wolox.com.ar                                                 |
      | correo sin direccion sin direccion | @wolox.com.ar          | Prueba123  | prueba2   | prueba2  | Invalid email                                                                   |
      | coreo condominio incompleto        | prueba@wolox.com       | Prueba123  | prueba3   | prueba3  | The email must be @wolox.com.ar                                                 |
      | clave menor a 8 caracteres         | prueba001@wolox.com.ar | Prueba2    | prueba4   | prueba4  | Password must be at least 8 characters                                          |
      | usuario ya existe                  | prueba@wolox.com.ar    | Prueba2q   | prueba5   | prueba5  | Unable to create new user. The resource you are trying to create already exists |


