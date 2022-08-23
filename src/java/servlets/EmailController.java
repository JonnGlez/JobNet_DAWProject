package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.Mail;

public class EmailController extends HttpServlet {

   
    
    
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
     
      String email = request.getParameter("destino");
      String asunto = request.getParameter("asunto");
      String mensaje = request.getParameter("mensaje");
      String msg=null; 
      HttpSession session = request.getSession();
      RequestDispatcher rd;
      try {         
         if (session.getAttribute("usuario") != null) {
            // Clase para enviar un email a un usuario  
            Mail mail = new Mail();
            // Enviamos el correo
            msg = mail.sendMail(email, asunto, mensaje);
            request.setAttribute("message", msg);
            rd = request.getRequestDispatcher("/mensaje.jsp");
            rd.forward(request, response);
         } else {
            msg = "Usuario y/o password incorrectos";
            request.setAttribute("message", msg);
            rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
         }
      } catch (Exception e) {
         System.out.println("Error: EmailController.doPost: " + e.getMessage());
      }

   }

}
