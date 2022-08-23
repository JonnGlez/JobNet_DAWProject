
package domain;

/**
 *
 * @author Joni
 */
public class Usuario {
    
    private int id;
    private String user;
    private String perfil;
    private String password;
    private String codRecuperacion;
    
    public Usuario(int id, String user, String perfil, String password, String codRecuperacion) {
        this.id = id;
        this.user = user;
        this.perfil = perfil;
        this.password = password;
        this.codRecuperacion = codRecuperacion;
    }

    public Usuario() {
    }
    
    
     

    public Usuario(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCodRecuperacion() {
        return codRecuperacion;
    }

    public void setCodRecuperacion(String codRecuperacion) {
        this.codRecuperacion = codRecuperacion;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", user=" + user + ", perfil=" + perfil + ", password=" + password + ", codRecuperacion=" + codRecuperacion + '}';
    }

   
   
    
    
}
