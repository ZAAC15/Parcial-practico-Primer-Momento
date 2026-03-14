package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
Clase que representa la entidad Reserva.
Esta clase se conecta con la tabla reservas de la base de datos
usando JPA.
*/
@Entity
@Table(name="reservas")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombre;
    private String fecha;
    private String espacio;
    private int duracion;
    
    public Reserva() {}

    /*
    constructor que permite crear una reserva
    con todos los datos
    */
    public Reserva(String nombre, String fecha, String espacio, int duracion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.espacio = espacio;
        this.duracion = duracion;
    }

    // getters y setters para acceder y modificar los datos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEspacio() {
        return espacio;
    }

    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

}