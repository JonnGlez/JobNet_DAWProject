
package DAO;


import domain.UserInfo;
import domain.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Joni
 */
public class UserInfoDAO {
    
     DbConnection conn;

    public UserInfoDAO(DbConnection conn) {
        this.conn = conn;
    }
     
    public boolean insertarUserInfo(UserInfo u) {
        
        
        try {
            String sql = "insert into userinfo values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, u.getId());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getDireccion());
            ps.setString(5, u.getTelefono());
            ps.setString(6, u.getStatus());
            ps.setInt(7, u.getIdUsuario().getId());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean modificarUserInfo(UserInfo u){
        
        try {
            String sql = "update userinfo set nombre=?, email=?, direccion=?, telefono=? where idUsuario=?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getDireccion());
            ps.setString(4, u.getTelefono());
             ps.setInt(5, u.getIdUsuario().getId());
           ps.executeUpdate();
           return true;
        }catch(SQLException ex) {
            return false;
        }
        
    }
    
    public UserInfo verificarUserInfo(int idUsuario){
         try {
           String sql = "select * from userinfo where idUsuario=? limit 1";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            UserInfo u = new UserInfo(0);
            Usuario usu = new Usuario(idUsuario);
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setDireccion(rs.getString("direccion"));
                u.setTelefono(rs.getString("telefono"));
                u.setStatus(rs.getString("status"));
               u.setIdUsuario(usu);
            }
            return u;
        } catch (SQLException e) {
            System.out.println("Error al recuperar la vacante por id: " + e.getMessage());
            return null;
    }
}
    
    public UserInfo RecuperarUsuarioInfo(int idUsuario) {
         try{
             String sql = "select * from userinfo where id=?";
         
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            UsuarioDAO uDAO= new UsuarioDAO(conn);
            UserInfo u = new UserInfo(0);
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setDireccion(rs.getString("direccion"));
                u.setTelefono(rs.getString("telefono"));
                u.setStatus(rs.getString("status"));
               u.setIdUsuario(uDAO.RecuperarUsuario(rs.getInt("idUsuario")));
             }
            return u;
        } catch (SQLException e) {
            System.out.println("Error al recuperar la vacante por id: " + e.getMessage());
            return null;
    }
}
}