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
<style type="text/css">
        #boton { margin-top: 40px;}
    </style>

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
           <c:if test="${usuario.id > 0}">
                       <c:set var = "perfil" scope = "session" value = "administrador"/>
                        <c:if  test="${usuario.perfil.equals(perfil)}" >
           <li><a href="usuarios?action=lista">Usuarios</a></li>
                                   </c:if>
                    </c:if>

           <li><a href="info-perfil?action=ver&id=${usuario.id}">Perfil</a></li> 
           
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
      <form method ="post" action="buscar" class="navbar-form navbar-right">
        <div class="form-group">
          <input type="text" name="query" required placeholder="Buscar oferta..." class="form-control">
        </div>        
        <button type="submit" class="btn btn-success">Buscar</button>
      </form>
      <br><br><br>

      <div class="panel panel-primary">
        <div class="panel-heading">
          <h3 class="panel-title">Numero de la vacante</h3>
        </div>
        <div class="panel-body">
            <!--<h5><b>Vacante: </b>${vacante.nombre}</h5>-->
            <h5><b>Publicado: </b>${vacante.fechaPublicacion}</h5>                             
            <b>Descripción: </b><br>
            <p class="text-justify">${vacante.descripcion}</p>
            <h5><b>Ciudad: </b>${vacante.ciudad}</h5>
            <h5><b>Estudios solicitados: </b>${vacante.estudios}</h5>
            <h5><b>Experiencia mínima: </b>${vacante.experiencia}</h5>
            <h5><b>Jornada: </b>${vacante.jornada}</h5>
            <h5><b>Salario: </b>${vacante.salario}</h5>
            <b>Detalles de la vacante: </b>:<br>
            ${vacante.detalle}
             <!--
          Mostramos un boton para permitir a un usuario enviar su Curriculm Vitae para esta Vacante. Estamos mandando 
          como parametro el id de esta vacante, ya que lo ocuparemos para hacer una busqueda para mostrar el nombre
          de la vacante en el siguiente formulario que es el formulario para enviar los datos del usuario, junto con su
          archivo DOC o PDF de su CV.
          -->          
          <c:if test="${usuario.id > 0}">
              <c:set var = "perfil" scope = "session" value = "Trabajador"/>
              <c:if  test="${usuario.perfil.equals(perfil)}" >
                  <p><a class="btn btn-default btn-success" id="boton" title="Enviar Curriculm Vitae para aplicar a esta vacante." href="nueva-vacante?action=enviarCV&id=${vacante.id}" role="button">Enviar CV</a></p>                         
              </c:if>
          </c:if>

          
        </div>
      </div>      
      <!-- Site footer -->
       <footer class="footer">
                <p>&copy; 2021 Job.net</p>
            </footer>

    </div> <!-- /container -->

  </body>
</html>
