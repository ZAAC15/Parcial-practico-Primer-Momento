package com.compensar.coworking1;

import java.time.LocalDate;
import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import logica.Reserva;
import persistencia.ReservaJpaController;

/*
Servlet encargado de recibir los datos del formulario
de reserva y guardarlos en la base de datos.
Tambien realiza algunas validaciones antes de registrar la reserva.
*/
@WebServlet(name = "ReservaServlet", urlPatterns = {"/ReservaServlet"})
public class ReservaServlet extends HttpServlet {

    // conexion con la unidad de persistencia configurada en persistence.xml
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("coworkingPU");

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
        se obtienen los datos enviados desde el formulario
        que esta en index.jsp
        */
        String nombre = request.getParameter("nombre");
        String fecha = request.getParameter("fecha");
        String espacio = request.getParameter("espacio");
        String duracionStr = request.getParameter("duracion");

        // se convierte la fecha enviada a un objeto LocalDate
        LocalDate fechaReserva = LocalDate.parse(fecha);

        // se obtiene la fecha actual del sistema
        LocalDate hoy = LocalDate.now();

        /*
        validacion para evitar que el usuario reserve
        fechas anteriores al dia actual
        */
        if (fechaReserva.isBefore(hoy)) {

            // se envia un mensaje de error al index.jsp
            request.setAttribute("errorFecha", "No se pueden reservar fechas anteriores al dia actual.");

            request.getRequestDispatcher("index.jsp").forward(request, response);

            return;
        }

        /*
        validacion para verificar que todos los campos
        del formulario tengan datos
        */
        if (nombre == null || nombre.isEmpty()
                || fecha == null || fecha.isEmpty()
                || espacio == null || espacio.isEmpty()
                || duracionStr == null || duracionStr.isEmpty()) {

            // si falta algun dato se redirige a una pagina de error
            response.sendRedirect("error.html");
            return;
        }

        // se convierte la duracion de texto a numero entero
        int duracion = Integer.parseInt(duracionStr);

        /*
        se crea un objeto Reserva con los datos ingresados
        por el usuario
        */
        Reserva reserva = new Reserva();
        reserva.setNombre(nombre);
        reserva.setFecha(fecha);
        reserva.setEspacio(espacio);
        reserva.setDuracion(duracion);

        // se usa el controlador JPA para guardar la reserva en la base de datos
        ReservaJpaController controlador = new ReservaJpaController(emf);
        controlador.create(reserva);

        // despues de guardar la reserva se redirige a la pagina de confirmacion
        response.sendRedirect("confirmacionReserva.jsp");
    }
}