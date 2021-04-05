## PruebaTecnicaWolox" 
Este proyecto es la solucion de la prueba tecnica propuesta por la empresa Wolox

## Comenzando
Estas instrucciones te permitirán clonar el proyecto y realizar la configuracion adecuada para que tengas el proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.

### Pre-Requisitos
Como pre-requisitos deberas tener intalados las siguientes herramientas:
  1. Git
  2. Java
  3. Gradle 6.8.3
  4. Intellij o el IDE que prefeiras
  5. Tener instalado el plugin de cucumber en el IDE

## Instalacion
  1. Abre una ventana de comandos
  2. Ejecuta el comando java -version
  3. Ejecuta el comando gradle -version
  4. Verifica las versiones
  
  ![image](https://user-images.githubusercontent.com/79065617/113531447-6c4fdd00-958e-11eb-90d6-e5c80d955b06.png)
  
  5. Clona el respositorio
    Git:
       - git clone https://github.com/yorman67/PruebaTecnicaWolox.git
       - cd PruebaTecnicaWolox
  6. Espera que todas las dependencias necesarias se descarguen

## Ejecucion de pruebas
  En la carpeta  runners encontraras el runner de cada uno de los flujos de las pruebas solicitadas en el reto, ademas de encontrar un runner llamado "IntegralRunner" que    ejecutara todos los runner
  
  ![image](https://user-images.githubusercontent.com/79065617/113532919-344a9900-9592-11eb-897a-657a599751b4.png)

   ### Ejecucion con JUnit
      si quieres ejecutar las pruebas con JUnit sigue estos pasos
    
![2021-04-04_22h09_36](https://user-images.githubusercontent.com/79065617/113533213-fbf78a80-9592-11eb-9c74-eacd6b506fc5.png)
![2021-04-04_22h10_42](https://user-images.githubusercontent.com/79065617/113533216-fe59e480-9592-11eb-88fd-0a65c274bf66.png)

   ### Ejecucion con Gradle
      Podras ejecutar las pruebas con gradle para generar los resporte de serenity solo ejecutando el siguiente comando
        
      - gradle clean test aggregate --info -DPrueba="Nombre de la prueba"
    
    los nombres de los features son los siguientes :
      1. Registro
      2. Login
      3. ListaUsuarios
      4. ListaAlbumes
      5. FotosAlbum
      6. AlbumesComprados
      7. ComprarAlbum
      8. InvalidaSesion
      9. Integral
      
 ### Evidencia
 Esta es una imagen del reporte que se encuentra en la carpeta target, como se puede observar algunos escenarios fallaron, ya que segun los criterios de aceptación deberia hacer algo, y el servicio hace algo ditinto
 
 ![image](https://user-images.githubusercontent.com/79065617/113537660-f1db8900-959e-11eb-8c8e-a213817c7c57.png)

  
      
 ### Construido con 
  Este proyecto fue construido con:
  
    * serenity rest assured
    * gradle
    * java
    * cucumber
    
 ### Mejoras/sugerencias
  1. En el endpoint de registro de nuevos ususarios no se deberian permitir caracteres especiales como tildes,, ya que esto puede traer problemas en futuros desarrollos
  2. En el endpoint de resgistro se deberia de poner como criterio de aceptacion validar la cantidad de caracteres maximos y minimos
  3. En el endpoint de listar usuarios, al manejar la paginación si ingreso una pagina que mayor a las que hay deberia decirme que la pagina no existe
  4. Se deberia crear un servici opara crear almbumes
  5. En el servicio de consultar las fotos de los albumes, si el almbum que ingreso no exites deberia sacarme un eror, a hoy no retorna un vecto vacio
  6. En el servcio de listar los albumes comprados, pasa igual al anterior, si ingreso un id que no exite deberia informarme un error  

### Autores
  - Yorman Paúl Martínez Acevedo
  
  
      
     


      


