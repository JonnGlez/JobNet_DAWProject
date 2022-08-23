
package domain;

import java.util.Date;

/**
 *
 * @author Joni
 */
public class Vacante {
    
    private int id;
    private Date fechaPublicacion;
    private String nombre;
    private String descripcion;
    private String detalle;
    private String ciudad;
    private String estudios;
    private String experiencia;
    private String jornada;
    private String salario;
    private Usuario idUsuario;

    public Vacante() {
         this.fechaPublicacion = new Date();
    }

    
    
    public Vacante(int id) {
        this.fechaPublicacion = new Date();
        this.id = id;
    }

    public Vacante(int id, Date fechaPublicacion, String nombre, String descripcion, String detalle, String ciudad, String estudios, String experiencia, String jornada, String salario, Usuario idUsuario) {
        this.id = id;
        this.fechaPublicacion = fechaPublicacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.ciudad = ciudad;
        this.estudios = estudios;
        this.experiencia = experiencia;
        this.jornada = jornada;
        this.salario = salario;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Vacante{" + "id=" + id + ", fechaPublicacion=" + fechaPublicacion + ", nombre=" + nombre + ", descripcion=" + descripcion + ", detalle=" + detalle + ", ciudad=" + ciudad + ", estudios=" + estudios + ", experiencia=" + experiencia + ", jornada=" + jornada + ", salario=" + salario + ", idUsuario=" + idUsuario + '}';
    }

    
    
   
   
    
     
}
