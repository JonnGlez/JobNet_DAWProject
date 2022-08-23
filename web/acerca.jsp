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
                        <li><a href="perfil?action=login">Administraci�n</a></li>                        
                        
                        <c:if test="${usuario.id > 0}">
                        <li><a href="perfil?action=logout">Salir</a></li> 
                        </c:if>
                        <c:if test="${usuario.id ==null}">
                        <li><a href="login.jsp">Iniciar sesi�n</a></li> 
                        </c:if>          
          </ul>
        </nav>
      </div>

      <!-- Jumbotron -->
      <div class="jumbotron">
        <h2>ACERCA</h2>
        <p class="lead text-justify">
            Job.net es una p�gina que facilita la b�squeda de empleo y la publicaci�n de vacantes por parte de las empresas.<br>
            El c�digo de recuperaci�n de contrase�a es un c�digo alfanum�rico de 8 d�gitos el cu�l es muy importante que apuntes para poder recuperar tu contrase�a en caso de que sea necesario.<br>
            Esperamos que tu experiencia con nosotros sea la mejor posible.<br>
            Puede contactar con nosotros en el tel�fono gratuito 916870000 o en el correo electr�nico administraci�n@jobnet.com
        <p>
      </div>
 <footer class="footer">
                <p>&copy; 2021 Job.net</p>
            </footer>
    </div> <!-- /container -->
   
  </body>
</html>
