# Parcial-practico-Primer-Momento
Descripcion del proyecto:

Este proyecto consiste en un sistema web para gestionar reservas de espacios en un coworking.
La aplicacion permite registrar reservas, ver la lista de reservas guardadas y eliminar reservas existentes.

El sistema fue desarrollado usando Java Servlets, JSP y JPA, y se ejecuta en un servidor Apache Tomcat.

Tecnologias utilizadas:

- Java
- Servlets
- JSP
- JPA (Java Persistence API)
- Apache Tomcat
- HTML y CSS

Funcionalidades principales
Registro de reservas:
En la pagina index.jsp se encuentra un formulario donde el usuario puede ingresar los datos de la reserva:

- Nombre del usuario
- Fecha de la reserva
- Espacio de trabajo
- Duracion en horas

Cuando el usuario envía el formulario, los datos son enviados al ReservaServlet, el cual realiza validaciones y guarda la reserva en la base de datos utilizando JPA y el controlador ReservaJpaController.

Tambien se implemento una validacion para evitar que el usuario pueda reservar fechas anteriores al dia actual.

Confirmacion de reserva:
Una vez guardada la reserva, el sistema redirige a la pagina confirmacionReserva.jsp, donde se muestra un mensaje indicando que la reserva fue registrada correctamente.
Desde esta pagina el usuario puede hacer una nueva reserva o ver la lista de reservas.

Lista de reservas:
La lista de reservas se muestra en la pagina listaReservas.jsp.
El servlet ListaReservasServlet se encarga de consultar todas las reservas guardadas en la base de datos y enviarlas al JSP mediante request.setAttribute.
En la pagina JSP se recorre la lista de reservas y se muestran en una tabla.

Eliminacion de reservas:

Cada reserva en la tabla tiene un boton Eliminar.
Este boton envía el id de la reserva al EliminarReservaServlet, el cual utiliza el metodo destroy del ReservaJpaController para eliminar la reserva de la base de datos.
Luego de eliminar la reserva, el sistema vuelve a mostrar la lista actualizada.

Estructura del proyecto:

El proyecto esta organizado en los siguientes paquetes:

- logica → contiene la clase entidad Reserva.
- persistencia → contiene el ReservaJpaController encargado de manejar las operaciones con la base de datos.
- com.compensar.coworking1 → contiene los servlets que manejan las peticiones del sistema.

Las vistas del sistema se encuentran en las paginas JSP dentro del proyecto.

Conclusion:
Con este sistema se puede gestionar de forma sencilla las reservas de espacios en un coworking, permitiendo registrar, visualizar y eliminar reservas mediante una aplicacion web basada en Java.


Instrucciones de despliegue
Requisitos previos:

Para ejecutar este proyecto se necesita tener instalado lo siguiente:

- Java JDK 21
- Apache Tomcat 8.5 o superior
- NetBeans 19
- MySQL (base de datos)
- Maven

Tambien es necesario tener creada la base de datos donde se guardaran las reservas.

Pasos para ejecutar el proyecto:

1. Clonar el repositorio desde GitHub o descargar el proyecto en formato ZIP.
2. Abrir el proyecto en NetBeans.
3. Verificar la configuracion de la base de datos en el archivo persistence.xml.
4. Asegurarse de que el servidor Apache Tomcat este configurado en NetBeans.
5. Ejecutar el proyecto usando la opcion Run Project.
6. El servidor iniciara automaticamente y se podra acceder a la aplicacion desde el navegador.

Acceso a la aplicacion:

Una vez que el proyecto esta ejecutandose, la aplicacion se puede abrir desde la siguiente URL:

http://localhost:8080/coworking1/index.jsp

Desde esta pagina el usuario puede:

- Registrar una nueva reserva
- Ver la lista de reservas registradas
- Eliminar reservas existentes

Funcionalidad del sistema:

El sistema permite gestionar reservas de espacios en un coworking. Las funcionalidades principales son:

- Registrar reservas: el usuario ingresa su nombre, fecha, espacio y duracion.
- Validar fechas: el sistema no permite registrar reservas en fechas anteriores al dia actual.
- Ver reservas: se muestran todas las reservas en una tabla.
- Eliminar reservas: cada reserva tiene un boton para eliminarla.
