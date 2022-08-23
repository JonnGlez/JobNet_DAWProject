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

      <h4><font color="red">${message}</font></h4>
      
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title"><b>Enviar CV para vacante: ${vacante.nombre}</b></h3>
        </div>
        <div class="panel-body">

          <form action="solicitud" method="post" enctype="multipart/form-data">
             <div class="form-group">
              <label for="nombre">Nombre</label>
              <input type="text" class="form-control" name="nombre" value="${solicitud.nombre}" required id="nombre">
            </div>                   
            <div class="form-group">
              <label for="email">Email</label>
              <input type="email" class="form-control" name="email" value="${solicitud.email}" required id="email">
            </div>                   
            <div class="form-group">
              <label for="telefono">Teléfono</label>
              <input type="text" class="form-control" name="telefono" value="${solicitud.telefono}" required id="telefono">
            </div>                   
            <div class="form-group">
              <label for="direccion">Dirección</label>
              <input type="text" class="form-control" name="direccion" value="${solicitud.direccion}" required id="direccion">
            </div>                                          
            <div class="form-group">
              <label for="archivo">Subir CV</label>
              <input type="file" required id="archivo" name="archivo">
              <p class="help-block">Solo se permiteo archivos [ pdf,doc,docx ]</p>
            </div>             
             <div class="form-group">
              
              <input type="hidden" class="form-control" name="idVacante" value="${vacante.id}" required id="idVacante">
              <input type="hidden" class="form-control" name="idUsuario" value="${usuario.id}" required id="idUsuario">
            </div>
            <button type="submit" class="btn btn-success" >Enviar</button>
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
