
package domain;

import java.util.Date;

/**
 *
 * @author Joni
 */
public class Solicitud {
    private int id;
    private Date fecha;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private String archivo;
    private Vacante idVacante;
    private Usuario idUsuario;

    public Solicitud(int id, Date fecha, String nombre, String email, String telefono, String direccion, String archivo, Vacante idVacante, Usuario idUsuario) {
        this.id = id;
        this.fecha = fecha;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.archivo = archivo;
        this.idVacante = idVacante;
        this.idUsuario = idUsuario;
    }

    
    
    
    public Solicitud(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Vacante getIdVacante() {
        return idVacante;
    }

    public void setIdVacante(Vacante idVacante) {
        this.idVacante = idVacante;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "id=" + id + ", fecha=" + fecha + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", direccion=" + direccion + ", archivo=" + archivo + ", idVacante=" + idVacante + ", idUsuario=" + idUsuario + '}';
    }

   
    
}
