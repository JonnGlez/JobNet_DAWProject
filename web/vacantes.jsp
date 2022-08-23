<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Job.net</title> 
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/justified-nav.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">

      <!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
      <div class="masthead">
       <a href="inicio"><img  src="images/jobnet.PNG"><br></a>
        <nav>
            <ul class="nav nav-justified">
                 <li><a href="inicio">Inicio</a></li>
                  <c:if test="${usuario.id > 0}">
                       <c:set var = "perfil" scope = "session" value = "Empresa"/>
                        <c:if  test="${usuario.perfil.equals(perfil)}" >
           <li><a href="perfil?action=crear">Crear Vacante</a></li>   
                        </c:if>
                    </c:if>
            <li><a href="perfil?action=login">Administración</a></li> 
            <c:if test="${usuario.id > 0}">
                       <c:set var = "perfil" scope = "session" value = "administrador"/>
            <c:set var = "perfil1" scope = "session" value = "Trabajador"/>
                        <c:if  test="${usuario.perfil.equals(perfil) || usuario.perfil.equals(perfil1)}" >
            <li><a href="solicitud?action=solicitudes&id=${usuario.id}&perfil=${usuario.perfil}">Solicitudes</a></li>  
               </c:if>
                    </c:if>
             <c:if test="${usuario.id > 0}">
                        <li><a href="perfil?action=logout">Salir</a></li> 
                        </c:if>
                        <c:if test="${usuario.id ==null}">
                        <li><a href="login.jsp">Iniciar sesión</a></li> 
                        </c:if>
          </ul>
        </nav>
      </div>
      <form method ="post" action="buscar" class="navbar-form navbar-right">
        <div class="form-group">
          <input type="text" name="query" required placeholder="Buscar oferta..." class="form-control">
        </div>        
        <button type="submit" class="btn btn-success">Buscar</button>
      </form>
      <br><br><br>

      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title"><b>Lista de Vacantes</b></h3>
        </div>
        <div class="panel-body">
          <table class="table table-striped">
            <thead>
              <tr>
                <th class="left">ID</th>
                <th>Vacante</th>
                <th>Publicado</th>                
                <th></th>
              </tr>
            </thead>
            <tbody>     
                
                <c:forEach items="${vacantes}" var="vacante">
                <tr>
                  <td class="left">${vacante.id}</td>
                  <td>${vacante.nombre}</td>
                  <td>${vacante.fechaPublicacion}</td>
                  <td>
                    <a class="btn btn-default" href="nueva-vacante?action=ver&id=${vacante.id}" role="button">Ver Detalles</a>  
                    <c:if test="${usuario.id > 0}">
                       <c:set var = "perfil" scope = "session" value = "administrador"/>
                        <c:if  test="${usuario.perfil.equals(perfil)}" >
                    <a class="btn btn-default" href="perfil?action=eliminar&idVacante=${vacante.id}" role="button">Eliminar</a>                         
                        </c:if>
                    </c:if>
                    </td>  
                </tr>
                </c:forEach> 
               
               
            </tbody>           
          </table>
        </div>
      </div>

      <!-- Site footer -->
       <footer class="footer">
                <p>&copy; 2021 Job.net</p>
            </footer>

    </div> <!-- /container -->

  </body>
</html>
