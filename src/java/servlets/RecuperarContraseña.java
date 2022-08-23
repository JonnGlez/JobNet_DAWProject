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
public class RecuperarContraseña extends HttpServlet {


  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codParam = request.getParameter("codRecuperacion");
       
        String msg = "";
        //Recuperamos una instancia del objeto HttpSession
      
        DbConnection conn = new DbConnection();
        UsuarioDAO uDAO = new UsuarioDAO(conn);
        //Verificar en la BBDD
        Usuario u = uDAO.recuperarContraseña(codParam);
        conn.disconnect();
   
        
        RequestDispatcher rd;
        if (u.getId() > 0) {
           
            //Creamos sesion con el usuario
           request.setAttribute("usuario", u);
            rd = request.getRequestDispatcher("/modificarContraseña.jsp");
            rd.forward(request, response);
        
        } else {
            msg = "El código de recuperación no es correcto";
            request.setAttribute("message", msg);
            rd = request.getRequestDispatcher("/recuperarContraseña.jsp");
            rd.forward(request, response);
        }
        
    }

   
}
