package com.compensar.coworking1;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.Reserva;
import persistencia.ReservaJpaController;

/*
Servlet encargado de mostrar la lista de reservas.
Obtiene las reservas de la base de datos usando JPA
y las envia a la pagina listaReservas.jsp para mostrarlas.
*/
@WebServlet(name = "ListaReservasServlet", urlPatterns = {"/ListaReservasServlet"})
public class ListaReservasServlet extends HttpServlet {

    // fabrica de conexiones para trabajar con JPA
    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {

        // se crea la conexion con la unidad de persistencia definida en persistence.xml
        emf = Persistence.createEntityManagerFactory("coworkingPU");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // se crea el controlador para trabajar con la entidad Reserva
        ReservaJpaController controlador = new ReservaJpaController(emf);

        // se obtienen todas las reservas guardadas en la base de datos
        List<Reserva> listaReservas = controlador.findReservaEntities();

        /*
        se envia la lista al JSP usando request.setAttribute
        para que la pagina listaReservas.jsp pueda mostrar los datos
        */
        request.setAttribute("listaReservas", listaReservas);

        // se redirige a la pagina JSP donde se mostrara la tabla de reservas
        request.getRequestDispatcher("listaReservas.jsp").forward(request, response);
    }

    @Override
    public void destroy() {

        // se cierra la conexion cuando el servlet deja de usarse
        if (emf != null) {
            emf.close();
        }
    }
}