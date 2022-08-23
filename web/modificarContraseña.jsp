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
  
   <style type="text/css">
        #idUsuario { display: none}
    </style>

     <script src='tinymce/tinymce.min.js'></script>

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
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">Modificar perfil</h3>
        </div>
        <div class="panel-body">
         <form action="modificar" method="post">
                     <div class="form-group">
              <label for="user">Usuario</label>
              <input type="text" class="form-control" name="user" id="user" required rows="3" value="" placeholder="">
            </div>          
            <div class="form-group">
              <label for="password">Contraseña</label>
              <input type="text" class="form-control" name="password" id="password" required rows="3" value="" placeholder="">
            </div>
            
               <div class="form-group">
             <input type="text" class="form-control" name="codRecuperacion" id="codRecuperacion" rows="4" value="${usuario.codRecuperacion}" placeholder="">
              </div>
            <button type="submit" class="btn btn-default" >Modificar</button>
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