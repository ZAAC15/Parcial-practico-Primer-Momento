<%@page import="java.util.List"%>
<%@page import="logica.Reserva"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de reservas</title>

<link rel="stylesheet" href="styles.css">
</head>

<body>
<div class="contenedor-lista">

<h1>Reservas registradas</h1>

<!-- tabla donde se muestran todas las reservas -->
<table class="tabla-reservas">

<thead>
<tr>
<!-- encabezados de la tabla -->
<th>Nombre</th>
<th>Fecha</th>
<th>Espacio</th>
<th>Duración</th>
<th>Acción</th>
</tr>
</thead>

<tbody>

<%
/*
El servlet ListaReservasServlet envia la lista de reservas
usando request.setAttribute("listaReservas", listaReservas)

Aqui la recibimos y la guardamos en una lista para recorrerla
*/
List<Reserva> lista = (List<Reserva>) request.getAttribute("listaReservas");

/*
recorremos todas las reservas para mostrarlas en la tabla
*/
for(Reserva r : lista){
%>

<tr>

<!-- datos de cada reserva -->
<td><%= r.getNombre() %></td>
<td><%= r.getFecha() %></td>
<td><%= r.getEspacio() %></td>
<td><%= r.getDuracion() %> horas</td>

<td>
<!-- boton para eliminar la reserva usando su id -->
<a class="boton-eliminar"
href="EliminarReservaServlet?id=<%= r.getId() %>">
Eliminar
</a>
</td>

</tr>

<%
}
%>

</tbody>

</table>

<!-- boton para volver al formulario principal -->
<a href="index.jsp" class="boton-volver">
Volver
</a>

</div>

</body>
</html>