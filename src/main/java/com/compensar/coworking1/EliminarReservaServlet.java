package com.compensar.coworking1;

import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import persistencia.ReservaJpaController;

/*
Servlet encargado de eliminar una reserva.
Recibe el id de la reserva desde la pagina de lista de reservas
y la elimina de la base de datos usando JPA.
*/
@WebServlet(name = "EliminarReservaServlet", urlPatterns = {"/EliminarReservaServlet"})
public class EliminarReservaServlet extends HttpServlet {

    // conexion a la unidad de persistencia configurada en persistence.xml
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("coworkingPU");

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        /*
        se obtiene el id de la reserva que se quiere eliminar.
        este id viene desde el enlace del boton eliminar en la tabla
        */
        int id = Integer.parseInt(request.getParameter("id"));

        // se crea el controlador JPA para manejar la entidad Reserva
        ReservaJpaController controlador = new ReservaJpaController(emf);

        try {

            // se elimina la reserva usando su id
            controlador.destroy(id);

        } catch (Exception e) {

            // en caso de error se imprime en consola
            e.printStackTrace();
        }

        /*
        despues de eliminar la reserva se redirige nuevamente
        a la lista de reservas para ver los cambios
        */
        response.sendRedirect("ListaReservasServlet");
    }
}