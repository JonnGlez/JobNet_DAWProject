<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1">    
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
                       <c:set var = "perfil" scope = "session" value = "administrador"/>
                        <c:if  test="${usuario.perfil.equals(perfil)}" >
           <li><a href="usuarios?action=lista">Usuarios</a></li>
                                   </c:if>
                    </c:if>

           <li><a href="info-perfil?action=ver&id=${usuario.id}">Perfil</a></li> 
            <c:if test="${usuario.id > 0}">
                       <c:set var = "perfil" scope = "session" value = "Empresa"/>
                        <c:if  test="${usuario.perfil.equals(perfil)}" >
           <li><a href="perfil?action=crear">Crear Vacante</a></li>   
                        </c:if>
                    </c:if>
            <li><a href="nueva-vacante?action=lista&idUsu=${usuario.id}&perfil=${usuario.perfil}">Vacantes</a></li> 
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
      
      <br>    
      <div class="panel panel-info">
        <div class="panel-heading">
          <h3 class="panel-title">Responder vía email</h3>
        </div>
        <div class="panel-body">

          <p class="text-danger">${message}</p>    

          <form action="email" method="post">
            <div class="form-group">
              <label for="destino">Destinatario</label>
              <input type="text" class="form-control" name="destino" readonly id="destino" value="${email}" >
            </div>                                     
            <div class="form-group">
              <label for="asunto">Asunto</label>
              <input type="text" class="form-control" name="asunto" required id="asunto" placeholder="Asunto del Email">
            </div>                   
            <div class="form-group">
              <label for="mensaje">Mensaje</label>
              <textarea class="form-control" name="mensaje" id="mensaje" required rows="3" placeholder="Escribe el mensaje del correo electrónico"></textarea>
            </div>        
            <button type="submit" class="btn btn-default" >Enviar correo</button>
          </form>
        </div>
      </div>

      <!-- Site footer -->
      <footer class="footer">
                <p>&copy; 2021 Job.net</p>
            </footer>

    </div> <!-- /container -->

  </body>
</html>
