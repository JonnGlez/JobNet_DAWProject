
package servlets;

import DAO.DbConnection;
import DAO.UserInfoDAO;
import domain.UserInfo;
import domain.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class infoPerfilServlet extends HttpServlet {


     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getParameter("action");
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        String msg = "";
        if (action.equals("ver")){
        if (session.getAttribute("usuario") == null) {
                    request.setAttribute("message", msg);
                    rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                } else {
           this.verInfoUsuario(request, response);
       } 
        }
    }
    
    protected void verInfoUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
     int idUsuario = Integer.parseInt(request.getParameter("id"));
    DbConnection conn = new DbConnection();
    UserInfoDAO uDAO = new UserInfoDAO(conn);
    UserInfo u = uDAO.verificarUserInfo(idUsuario);
    conn.disconnect();
    
    //Compartimos la variable msg, para acceder con expression language
    request.setAttribute("usuinfo", u);
    RequestDispatcher rd;
    
    //Enviamos respuesta, desde detalle.jsp
    rd = request.getRequestDispatcher("/infoUsuario.jsp");
    rd.forward(request, response);
    
    }
  

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
          //Recibir parámetros
        String nombreParam = request.getParameter("nombre");
        String emailParam = request.getParameter("email");
        String direccionParam = request.getParameter("direccion");
        String telefonoParam = request.getParameter("telefono");
        int idUsuarioParam = Integer.parseInt(request.getParameter("idUsuario"));

        UserInfo u = new UserInfo(0);

        Usuario usuario = new Usuario(idUsuarioParam);
       
       u.setNombre(nombreParam);
       u.setEmail(emailParam);
       u.setDireccion(direccionParam);
       u.setTelefono(telefonoParam);
       u.setIdUsuario(usuario);
       
    

        
        //Procesar datos para guardar en la BD
        DbConnection conn = new DbConnection();
        UserInfoDAO uDAO = new UserInfoDAO(conn);
        UserInfo usuInfo = new UserInfo(0);
       usuInfo = uDAO.verificarUserInfo(idUsuarioParam);
       
        
        //Mensaje para el usuario
        
        String msg="";
        if(usuInfo.getIdUsuario()==null){
         boolean status = uDAO.insertarUserInfo(u);
        if (status){
         msg="Información de usuario guardada correctamente";
        }else{
        msg="Ocurrió un error y no se guardó la información del usuario";
        }
        }else{
         msg="Ya ha rellenado su perfil, pruebe a modificar los datos que ya introdujo ";
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
