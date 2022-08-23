
package servlets;

import DAO.DbConnection;
import DAO.VacanteDAO;
import domain.Vacante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Joni
 */
public class busquedaOfertas extends HttpServlet {

   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String q = request.getParameter("query");
        List<Vacante> lista = null;
        DbConnection conn = new DbConnection();
        VacanteDAO vDAO = new VacanteDAO(conn);
        lista = vDAO.busquedaVacante(q);
        conn.disconnect();
        RequestDispatcher rd;
        request.setAttribute("vacantes", lista);
        rd = request.getRequestDispatcher("/vacantes.jsp");
        rd.forward(request, response);
    }

}
