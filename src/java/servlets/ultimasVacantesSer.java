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
public class ultimasVacantesSer extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        DbConnection conn = new DbConnection();
        VacanteDAO vDAO = new VacanteDAO(conn);
        List<Vacante> listaUltiVacantes = vDAO.ultimasVacantes();
        conn.disconnect();
        request.setAttribute("ultimas", listaUltiVacantes);
        rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
        
    }
    
}
