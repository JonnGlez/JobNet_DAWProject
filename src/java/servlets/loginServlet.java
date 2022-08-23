
package servlets;

import DAO.DbConnection;
import DAO.UsuarioDAO;
import DAO.VacanteDAO;
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
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        //Recuperamos la sesion activa
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        String msg = "";

        switch (action) {
            case "login":
                // Aqui no existe aun sesion y lo mandamos al login
                if (session.getAttribute("usuario") == null) {
                    request.setAttribute("message", msg);
                    rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                } else {// ya esta logueado, lo mandamos al indice correspondiente a su perfil
                    rd = request.getRequestDispatcher("/admin.jsp");
                    rd.forward(request, response);

                }
                break;
            case "logout":
                session.invalidate();
                response.sendRedirect(request.getContextPath() + "/inicio");
                break;
            case "crear":
                 // Aqui no existe aun sesion y lo mandamos al login
                if (session.getAttribute("usuario") == null) {
                   msg = "Acceso denegado";
                    request.setAttribute("message", msg);
                    rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                } else {// ya esta logueado, lo mandamos al indice correspondiente a su perfil
                    rd = request.getRequestDispatcher("/formVacante.jsp");
                    rd.forward(request, response);
                }
                break;
            case "eliminar":
                if(session.getAttribute("usuario") == null){
                    msg = "Acceso denegado";
                    request.setAttribute("message", msg);
                    rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                } else {
                    this.eliminarVacante(request, response);
                }
                break;
        }
    }
    
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userParam = request.getParameter("user");
        String passParam = request.getParameter("pass");
        String msg = "";
        //Recuperamos una instancia del objeto HttpSession
        HttpSession session = request.getSession();
        DbConnection conn = new DbConnection();
        UsuarioDAO uDAO = new UsuarioDAO(conn);
        //Verificar en la BBDD
        Usuario u = uDAO.userLogin(userParam, passParam);
        conn.disconnect();
   
        
        RequestDispatcher rd;
        if (u.getId() > 0) {
           
            //Creamos sesion con el usuario
            session.setAttribute("usuario", u);
            rd = request.getRequestDispatcher("/admin.jsp");
            rd.forward(request, response);
        
        } else {
            msg = "Usuario y/o password incorrecto";
            request.setAttribute("message", msg);
            rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
        
    }
    
    private void eliminarVacante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recibimos el id de la vacante que vamos a eliminar
        int idVacanteParam = Integer.parseInt(request.getParameter("idVacante"));
        DbConnection conn = new DbConnection();
        VacanteDAO vacanteDao = new VacanteDAO(conn);
        int respuesta = vacanteDao.eliminarVacante(idVacanteParam);
        String msg = "";
        if (respuesta == 1) { // Fue afectado un registro, esto significa que si se borro
            msg = "La vacante fue eliminada correctamente.";
        } else {
            msg = "Ocurrio un error. La vacante no fue eliminada.";
        }
        conn.disconnect();
        request.setAttribute("message", msg);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/mensaje.jsp");
        rd.forward(request, response);
    }
    
}
