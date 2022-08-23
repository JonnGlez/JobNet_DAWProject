
package servlets;

import DAO.DbConnection;
import DAO.UserInfoDAO;
import DAO.UsuarioDAO;
import DAO.VacanteDAO;
import domain.UserInfo;
import domain.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class usuariosServlet extends HttpServlet {

  

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               String action = request.getParameter("action");
       if (action.equals("lista")){
           this.verListaUsuarios(request, response);
       }if (action.equals("ver")){
           this.verInfoUsuario(request, response);
       }
       if (action.equals("eliminar")){
           this.eliminarUsuarioVacantes(request, response);
       }
    }

      protected void verListaUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DbConnection conn = new DbConnection();
        UsuarioDAO uDAO = new UsuarioDAO(conn);
        List<Usuario> listaTodosUsuarios = uDAO.todasUsuarios();
        conn.disconnect();
        //Compartimos la lista para poder acceder desde la vista
        request.setAttribute("usuarios", listaTodosUsuarios);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/usuariosAdmin.jsp");
        rd.forward(request, response);
    }
      
     protected void verInfoUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
     int idUsuario = Integer.parseInt(request.getParameter("idUsu"));
    DbConnection conn = new DbConnection();
    UsuarioDAO uDAO = new UsuarioDAO(conn);
    UserInfo u = uDAO.enseñarUserInfo(idUsuario);
    conn.disconnect();
    
    //Compartimos la variable msg, para acceder con expression language
    request.setAttribute("usuinfo", u);
    RequestDispatcher rd;
    
    //Enviamos respuesta, desde detalle.jsp
    rd = request.getRequestDispatcher("/detalleUsuarios.jsp");
    rd.forward(request, response);
    
    }

    private void eliminarUsuarioVacantes(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        // Recibimos el id de la vacante que vamos a eliminar
        int idUsu = Integer.parseInt(request.getParameter("id"));
        DbConnection conn = new DbConnection();
        VacanteDAO vacanteDao = new VacanteDAO(conn);
        UsuarioDAO usuDAO = new UsuarioDAO(conn);
        int respuesta = vacanteDao.eliminarVacanteUsuario(idUsu);
        int usuario = usuDAO.eliminarUsuario(idUsu);
        String msg = "";
        if (usuario == 1) { // Fue afectado un registro, esto significa que si se borro
            msg = "La vacante fue eliminada correctamente.";
        } else {
            msg = "Ocurrio un error. La vacante no fue eliminada." + respuesta + usuario+idUsu;
        }
        conn.disconnect();
        request.setAttribute("message", msg);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/mensaje.jsp");
        rd.forward(request, response);
    }
    
}
