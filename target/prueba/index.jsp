<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservas Coworking</title>

<link rel="stylesheet" href="styles.css">
</head>

<body>
<div class="contenedor">

<h1>Reservar espacio de trabajo</h1>

<!-- 
formulario para registrar una reserva
los datos se envian al servlet ReservaServlet usando metodo POST
-->
<form action="ReservaServlet" method="POST" class="formulario-reserva">

<!-- campo para ingresar el nombre del usuario -->
<label>Nombre</label>
<input type="text" name="nombre" required>

<!-- campo para seleccionar la fecha de la reserva -->
<label>Fecha</label>
<input type="date" name="fecha" required>

<!-- 
si el servlet detecta una fecha incorrecta
envia un mensaje de error que se muestra aqui
-->
<%
String errorFecha = (String) request.getAttribute("errorFecha");
if(errorFecha != null){
%>

<p style="color:red; text-align:center;">
<%= errorFecha %>
</p>

<%
}
%>

<!-- seleccion del tipo de espacio que se quiere reservar -->
<label>Espacio</label>
<select name="espacio" required>
<option value="">Seleccione</option>
<option value="Escritorio">Escritorio</option>
<option value="Sala de reuniones">Sala de reuniones</option>
<option value="Oficina privada">Oficina privada</option>
</select>

<!-- cantidad de horas que durara la reserva -->
<label>Duración (horas)</label>
<input type="number" name="duracion" min="1" max="12" required>

<!-- boton para enviar el formulario -->
<button class="boton-reservar">Guardar reserva</button>

</form>

<!-- boton para ir a la lista donde se muestran todas las reservas -->
<div class="seccion-lista">
<a href="ListaReservasServlet" class="boton-lista">Ver reservas</a>
</div>

</div>

</body>
</html>