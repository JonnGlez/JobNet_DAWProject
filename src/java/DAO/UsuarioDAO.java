
package DAO;

import domain.UserInfo;
import domain.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import util.Utility;

/**
 *
 * @author Joni
 */
public class UsuarioDAO {
    DbConnection conn;

    public UsuarioDAO(DbConnection conn) {
        this.conn = conn;
    }
    
    public Usuario userLogin(String user, String pass){
        try{
            String sql = "Select * from usuario where user=? and password = md5(?) limit 1";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, user);
             ps.setString(2, pass);
             ResultSet rs = ps.executeQuery();
             Usuario u = new Usuario(0);
             while(rs.next()){
             u.setId(rs.getInt("id"));
             u.setUser(rs.getString("user"));
             u.setPerfil(rs.getString("perfil"));
             u.setPassword(rs.getString("password"));
           u.setCodRecuperacion(rs.getString("codigoRecuperacion"));
             }
             return u;
        }catch(SQLException e){
            System.out.println("Error con el login: " +e.getMessage());
            return null;
        }
    
    }
    
    public boolean insertarUsuario(Usuario u) {
         String codRecuperacion = Utility.randomAlphaNumeric(8);
        
        try {
            String sql = "insert into usuario values(?,?,?,md5(?),?)";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, u.getId());
            ps.setString(2, u.getUser());
            ps.setString(3, u.getPerfil());
            ps.setString(4, u.getPassword());
            ps.setString(5, codRecuperacion);
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            return false;
        }
    }

    public Usuario RecuperarUsuario(int idUsuario) {
         try{
             String sql = "select * from usuario where id=? limit 1";
         
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            Usuario u = new Usuario(0);
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setUser("user");
                u.setPassword("pass");
                u.setPerfil("perfil");
                u.setCodRecuperacion(rs.getString("codigoRecuperacion"));
             }
            return u;
        } catch (SQLException e) {
            System.out.println("Error al recuperar la vacante por id: " + e.getMessage());
            return null;
    }
}
    
    public List<Usuario> todasUsuarios() {
        try {
            String sql = "select * from usuario order by id desc";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            List<Usuario> listaUsuarios = new LinkedList<>();
            Usuario u;
            UsuarioDAO usuDAO = new UsuarioDAO(conn);
            while (rs.next()) {
                u= new Usuario(rs.getInt("id"));
                u.setUser(rs.getString("user"));
                u.setPassword(rs.getString("password"));
                u.setPerfil(rs.getString("perfil"));
                 u.setCodRecuperacion(rs.getString("codigoRecuperacion"));
                 listaUsuarios.add(u);
            }
            return listaUsuarios;
        } catch (SQLException e) {
            System.out.println("Error a la hora de recuperar todas las  vacantes: " + e.getMessage());
            return null;
        }

    }
    
    public UserInfo enseñarUserInfo(int idUsuario){
         try {
           String sql = "SELECT * FROM userinfo WHERE idUsuario=?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            UserInfoDAO uDAO = new UserInfoDAO(conn);
            UserInfo u = new UserInfo(0);
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setDireccion(rs.getString("direccion"));
                u.setTelefono(rs.getString("telefono"));
                u.setStatus(rs.getString("status"));
                
            }
            return u;
        } catch (SQLException e) {
            System.out.println("Error al recuperar la vacante por id: " + e.getMessage());
            return null;
    }
}
    
     public int eliminarUsuario(int idUsuario) {
          try {
            String sql = "delete from usuario where id=?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, idUsuario);
            int rows = ps.executeUpdate();
            return rows;
        } catch (SQLException e) {
            System.out.println("Error al eliminar la vacante: " + e.getMessage());
            return 0;
        }
    }
     
     public Usuario recuperarContraseña(String codRecuperacion) {
         try{
             String sql = "select * from usuario where codigoRecuperacion=? limit 1";
         
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, codRecuperacion);
            ResultSet rs = ps.executeQuery();
            Usuario u = new Usuario(0);
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setUser("user");
                u.setPassword("pass");
                u.setPerfil("perfil");
                u.setCodRecuperacion(rs.getString("codigoRecuperacion"));
             }
            return u;
        } catch (SQLException e) {
            System.out.println("Error al recuperar la vacante por id: " + e.getMessage());
            return null;
    }
}
     
     public boolean modificarUsuario(Usuario u){
        try {
            String sql = "update usuario set user=?, password=md5(?) where codigoRecuperacion=?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, u.getUser());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getCodRecuperacion());
            
           ps.executeUpdate();
           return true;
        }catch(SQLException ex) {
            return false;
        }
}
}