
package domain;

/**
 *
 * @author Joni
 */
public class UserInfo {
    
    private int id;
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    private String status ="activo";
    private Usuario idUsuario;

    public UserInfo(int id, String nombre, String email, String direccion, String telefono, Usuario idUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idUsuario = idUsuario;
    }

    
    
    
    public UserInfo(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", direccion=" + direccion + ", telefono=" + telefono + ", status=" + status + ", idUsuario=" + idUsuario + '}';
    }
    
    
}
