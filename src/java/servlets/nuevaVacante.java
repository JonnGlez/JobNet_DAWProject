package servlets;

import DAO.DbConnection;
import DAO.VacanteDAO;
import domain.Usuario;
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
public class nuevaVacante extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String perfil = request.getParameter("perfil");
        String action = request.getParameter("action");
       if (action.equals("ver")){
           this.verDetalle(request, response);
       } if (action.equals("lista")){
           if(perfil.equals("Empresa")){
           this.verTodasEmpresas(request, response);
           }else{
           this.verTodas(request, response);
           }
       }if (action.equals("enviarCV")){
           this.mostrarFormularioCV(request, response);
       }
        
       }
    
    
    protected void verDetalle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    //Recibimos id de la vacante a consultar
    int idVacante = Integer.parseInt(request.getParameter("id"));
    DbConnection conn = new DbConnection();
    VacanteDAO vDAO = new VacanteDAO(conn);
    Vacante v = vDAO.detalleVacante(idVacante);
    conn.disconnect();
    
    //Compartimos la variable msg, para acceder con expression language
    request.setAttribute("vacante", v);
    RequestDispatcher rd;
    
    //Enviamos respuesta, desde detalle.jsp
    rd = request.getRequestDispatcher("/detalleVacante.jsp");
    rd.forward(request, response);
    
    }
    
    protected void verTodas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DbConnection conn = new DbConnection();
        VacanteDAO vDAO = new VacanteDAO(conn);
        List<Vacante> listaTodasVacantes = vDAO.todasVacantes();
        conn.disconnect();
        //Compartimos la lista para poder acceder desde la vista
        request.setAttribute("vacantes", listaTodasVacantes);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/vacantes.jsp");
        rd.forward(request, response);
    }
    
     protected void verTodasEmpresas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int idUsuario = Integer.parseInt(request.getParameter("idUsu"));
    DbConnection conn = new DbConnection();
     VacanteDAO vDAO = new VacanteDAO(conn);
   List<Vacante> listaTodasVacantes = vDAO.todasVacantesEmpresa(idUsuario);
    conn.disconnect();
    //Compartimos la lista para poder acceder desde la vista
     request.setAttribute("vacantes", listaTodasVacantes);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/vacantesEmpresas.jsp");
        rd.forward(request, response);
    }
     
      protected void mostrarFormularioCV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        int idVacante = Integer.parseInt(request.getParameter("id"));      
        Vacante vacante = null;
        DbConnection conn = new DbConnection();
        VacanteDAO vacanteDao = new VacanteDAO(conn);
        vacante = vacanteDao.detalleVacante(idVacante);
        conn.disconnect();        
        request.setAttribute("vacante", vacante);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/frm_cv.jsp");
        rd.forward(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recibir parámetros
        String nombreParam = request.getParameter("nombre");
        String descripcionParam = request.getParameter("descripcion");
        String detalleParam = request.getParameter("detalle");
        String ciudadParam = request.getParameter("ciudad");
        String estudiosParam = request.getParameter("estudios");
        String experienciaParam = request.getParameter("experiencia");
        String jornadaParam = request.getParameter("jornada");
        String salarioParam = request.getParameter("salario");
        int idUsuarioParam = Integer.parseInt(request.getParameter("idUsuario"));

        Vacante v = new Vacante(0);
        Usuario usu = new Usuario(idUsuarioParam);

        
        
        v.setNombre(nombreParam);
        v.setDescripcion(descripcionParam);
        v.setDetalle(detalleParam);
        v.setCiudad(ciudadParam);
        v.setEstudios(estudiosParam);
        v.setExperiencia(experienciaParam);
        v.setJornada(jornadaParam);
        v.setSalario(salarioParam);
        v.setIdUsuario(usu);

        
        //Procesar datos para guardar en la BD
        DbConnection conn = new DbConnection();
        VacanteDAO vDAO = new VacanteDAO(conn);
        boolean status = vDAO.insertarVacante(v);
        
        //Mensaje para el usuario
        String msg="";
        if (status){
         msg="La vacante fue guardada correctamente";
        }else{
        msg="Ocurrió un error y la vacante no fue guardada" + v;
        }
        conn.disconnect();
        RequestDispatcher rd;
        //Mensaje que vamos a enviar al usuario
        request.setAttribute("message", msg);
        //Enviamos respuesta y renderizamos la vista mensaje.jsp
        rd = request.getRequestDispatcher("/mensaje.jsp");
        rd.forward(request, response);
        
        
    }

}
