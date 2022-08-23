/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Joni
 */
public class modificarContraseña extends HttpServlet {

   

   
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String codParam = request.getParameter("codRecuperacion");
          String codUsu = request.getParameter("user");
           String passParam = request.getParameter("password");
       
       

        Usuario usuario = new Usuario(0);
       usuario.setUser(codUsu);
       usuario.setPassword(passParam);
       usuario.setCodRecuperacion(codParam);
       
       
    

        
        //Procesar datos para guardar en la BD
        DbConnection conn = new DbConnection();
        UsuarioDAO uDAO = new UsuarioDAO(conn);
        
      
       
        
        //Mensaje para el usuario
        
        String msg="";
        
        boolean status = uDAO.modificarUsuario(usuario);
        if (status){
         msg="Información de usuario modificada correctamente";
        }else{
        msg="Ocurrió un error y no se modificó la información del usuario";
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
