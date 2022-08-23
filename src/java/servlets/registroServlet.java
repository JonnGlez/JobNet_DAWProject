
package servlets;

import DAO.DbConnection;
import DAO.UsuarioDAO;
import domain.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joni
 */
public class registroServlet extends HttpServlet {

  


   
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //Recibir parámetros
        String userParam = request.getParameter("user");
        String passParam = request.getParameter("pass");
        String perfilParam = request.getParameter("perfil");
       

        Usuario u = new Usuario(0);

        
        
       u.setUser(userParam);
       u.setPerfil(perfilParam);
       u.setPassword(passParam);
      

        
        //Procesar datos para guardar en la BD
        DbConnection conn = new DbConnection();
        UsuarioDAO uDAO = new UsuarioDAO(conn);
        boolean status = uDAO.insertarUsuario(u);
        
        //Mensaje para el usuario
        String msg="";
        if (status){
         msg="Usuario se registro correctamente correctamente";
        }else{
        msg="Ocurrió un error y el usuario no se registro correctamente" + u;
        }
        conn.disconnect();
        RequestDispatcher rd;
        //Mensaje que vamos a enviar al usuario
        request.setAttribute("message", msg);
        //Enviamos respuesta y renderizamos la vista mensaje.jsp
        rd = request.getRequestDispatcher("/mensajeLogin.jsp");
        rd.forward(request, response);
        
    }

}
