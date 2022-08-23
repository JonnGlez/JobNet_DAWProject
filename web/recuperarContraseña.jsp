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
                        <li><a href="perfil?action=login">Administración</a></li>                        
                        <li><a href="acerca.jsp">Acerca</a></li> 
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
          <h3 class="panel-title">Recuperar Contraseña</h3>
        </div>
        <div class="panel-body">

          <p class="text-danger">${message}</p>    

          <form action="recuperar" method="post">
            <div class="form-group">
              <label for="codRecuperacion">Introduce tu código de recuperación de contraseña</label>
              <input type="text" class="form-control" name="codRecuperacion" id="codRecuperacion" value="" >
            </div>                                     
          
            <button type="submit" class="btn btn-default" >Recuperar</button>
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
