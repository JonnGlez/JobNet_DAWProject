package DAO;

import domain.UserInfo;
import domain.Usuario;
import domain.Vacante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 *
 * @author Joni
 */
public class VacanteDAO {

    DbConnection conn;

    public VacanteDAO(DbConnection conn) {
        this.conn = conn;
    }

    public boolean insertarVacante(Vacante v) {
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        
        try {
            String sql = "insert into vacantes values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, v.getId());
            ps.setString(2, format.format(v.getFechaPublicacion()));
            ps.setString(3, v.getNombre());
            ps.setString(4, v.getDescripcion());
            ps.setString(5, v.getDetalle());
            ps.setString(6, v.getCiudad());
            ps.setString(7, v.getEstudios());
            ps.setString(8, v.getExperiencia());
            ps.setString(9, v.getJornada());
            ps.setString(10, v.getSalario());
            ps.setInt(11, v.getIdUsuario().getId());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            return false;
        }
    }

    public List<Vacante> ultimasVacantes() {
        try {
            String sql = "select * from vacantes order by id desc limit 3";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Vacante> listaVacantes = new LinkedList<>();
            Vacante v;
            Usuario usu = new Usuario(0);
            while (rs.next()) {
                v = new Vacante(rs.getInt("id"));
                v.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                v.setNombre(rs.getString("nombre"));
                v.setDescripcion(rs.getString("descripcion"));
                v.setDetalle(rs.getString("detalle"));
                v.setCiudad(rs.getString("ciudad"));
                v.setEstudios(rs.getString("estudios"));
                v.setExperiencia(rs.getString("experiencia"));
                v.setJornada(rs.getString("jornada"));
                v.setSalario(rs.getString("salario"));
                v.setIdUsuario(usu);
                listaVacantes.add(v);
            }
            return listaVacantes;
        } catch (SQLException e) {
            System.out.println("Error a la hora de recuperar ultimas vacantes: " + e.getMessage());
            return null;
        }

    }
    
     public Vacante detalleVacante(int idVacante) {
        try {
            String sql = "select * from vacantes where id=? limit 1";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, idVacante);
            ResultSet rs = ps.executeQuery();
            Vacante v = new Vacante(0);
            UsuarioDAO usuDAO = new UsuarioDAO(conn);
            while (rs.next()) {
                v.setId(rs.getInt("id"));
                v.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                v.setNombre(rs.getString("nombre"));
                v.setDescripcion(rs.getString("descripcion"));
                v.setDetalle(rs.getString("detalle"));
                v.setCiudad(rs.getString("ciudad"));
                v.setEstudios(rs.getString("estudios"));
                v.setExperiencia(rs.getString("experiencia"));
                v.setJornada(rs.getString("jornada"));
                v.setSalario(rs.getString("salario"));
               v.setIdUsuario(usuDAO.RecuperarUsuario(rs.getInt("idUsuario")));
            }
            return v;
        } catch (SQLException e) {
            System.out.println("Error al recuperar la vacante por id: " + e.getMessage());
            return null;
        }

    }
    
       public List<Vacante> todasVacantes() {
        try {
            String sql = "select * from vacantes order by id desc";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            List<Vacante> listaVacantes = new LinkedList<>();
            Vacante v;
            UsuarioDAO usuDAO = new UsuarioDAO(conn);
            while (rs.next()) {
                v = new Vacante(rs.getInt("id"));
                v.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                v.setNombre(rs.getString("nombre"));
                v.setDescripcion(rs.getString("descripcion"));
                v.setDetalle(rs.getString("detalle"));
                v.setCiudad(rs.getString("ciudad"));
                v.setEstudios(rs.getString("estudios"));
                v.setExperiencia(rs.getString("experiencia"));
                v.setJornada(rs.getString("jornada"));
                v.setSalario(rs.getString("salario"));
                v.setIdUsuario(usuDAO.RecuperarUsuario(rs.getInt("idUsuario")));
                 listaVacantes.add(v);
            }
            return listaVacantes;
        } catch (SQLException e) {
            System.out.println("Error a la hora de recuperar todas las  vacantes: " + e.getMessage());
            return null;
        }

    }
      public List<Vacante> todasVacantesEmpresa(int idUsu) {
       try {
            String sql = "select * from vacantes where idUsuario=? order by id desc";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, idUsu);
            ResultSet rs = ps.executeQuery();
            List<Vacante> listaVacantes = new LinkedList<>();
            Vacante v;
            UsuarioDAO usuDAO = new UsuarioDAO(conn);
            while (rs.next()) {
                v = new Vacante(rs.getInt("id"));
                v.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                v.setNombre(rs.getString("nombre"));
                v.setDescripcion(rs.getString("descripcion"));
                v.setDetalle(rs.getString("detalle"));
                v.setCiudad(rs.getString("ciudad"));
                v.setEstudios(rs.getString("estudios"));
                v.setExperiencia(rs.getString("experiencia"));
                v.setJornada(rs.getString("jornada"));
                v.setSalario(rs.getString("salario"));
                v.setIdUsuario(usuDAO.RecuperarUsuario(rs.getInt("idUsuario")));
                 listaVacantes.add(v);
            }
            return listaVacantes;
        } catch (SQLException e) {
            System.out.println("Error a la hora de recuperar todas las  vacantes: " + e.getMessage());
            return null;
        }

    } 
       
       
       
       
    public List<Vacante> busquedaVacante(String query) {
        try {
            String sql = "select * from vacantes where (nombre like ? or descripcion like ? or detalle like ? or ciudad like ? or estudios like ? or experiencia like ? or jornada like ? or salario like ?) order by id desc";
            PreparedStatement preparedStatement = conn.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, "%" + query + "%");
            preparedStatement.setString(2, "%" + query + "%");
            preparedStatement.setString(3, "%" + query + "%");
            preparedStatement.setString(4, "%" + query + "%");
            preparedStatement.setString(5, "%" + query + "%");
            preparedStatement.setString(6, "%" + query + "%");
            preparedStatement.setString(7, "%" + query + "%");
            preparedStatement.setString(8, "%" + query + "%");
            ResultSet rs = preparedStatement.executeQuery();
            List<Vacante> listaBusquedaVacantes = new LinkedList<>();
            Vacante v;
            while (rs.next()) {
                v = new Vacante(rs.getInt("id"));
                v.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                v.setNombre(rs.getString("nombre"));
                v.setDescripcion(rs.getString("descripcion"));
                v.setDetalle(rs.getString("detalle"));
                v.setCiudad(rs.getString("ciudad"));
                v.setEstudios(rs.getString("estudios"));
                v.setExperiencia(rs.getString("experiencia"));
                v.setJornada(rs.getString("jornada"));
                v.setSalario(rs.getString("salario"));
                //Añadir el objeto v a la lista
                listaBusquedaVacantes.add(v);
            }
            return listaBusquedaVacantes;
        } catch (SQLException e) {
            System.out.println("Error en la búsqueda de vacantes: " + e.getMessage());
            return null;
        }

    }
    
    public int eliminarVacante(int idVacante) {
        try {
            String sql = "delete from vacantes where id=?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, idVacante);
            int rows = ps.executeUpdate();
            return rows;
        } catch (SQLException e) {
            System.out.println("Error al eliminar la vacante: " + e.getMessage());
            return 0;
        }
    }
    
      public int eliminarVacanteUsuario(int idUsuario) {
        try {
            String sql = "delete from vacantes where idUsuario=?";
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setInt(1, idUsuario);
            int rows = ps.executeUpdate();
            return rows;
        } catch (SQLException e) {
            System.out.println("Error al eliminar la vacante: " + e.getMessage());
            return 0;
        }
    }
}
