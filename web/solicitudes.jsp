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

      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title"><b>Lista de solicitudes recibidas</b></h3>
        </div>
        <div class="panel-body">
          <table class="table table-striped">
            <thead>
              <tr>
                <th class="left">Fecha</th>
                <th>Nombre</th>
                <th>Email</th>                
                <th>Teléfono</th>
                <th>Dirección</th>
                <th>Aplicó para</th>
                 <c:if test="${usuario.id > 0}">
                       <c:set var = "perfil" scope = "session" value = "administrador"/>
                       <c:set var = "perfil1" scope = "session" value = "Empresa"/>
                       <c:if  test="${usuario.perfil.equals(perfil) || usuario.perfil.equals(perfil1)}" >
                <th>Opciones</th>
                </c:if>
                </c:if>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${solicitudes}" var="solicitud" varStatus="status">
                <tr>
                  <td class="left">${solicitud.fecha}</td>
                  <td>${solicitud.nombre}</td>
                  <td>${solicitud.email}</td>
                  <td>${solicitud.telefono}</td>
                  <td>${solicitud.direccion}</td>
                  <td>${solicitud.idVacante.nombre}</td>
                 
                  <c:if test="${usuario.id > 0}">
                       <c:set var = "perfil" scope = "session" value = "administrador"/>
                       <c:set var = "perfil1" scope = "session" value = "Empresa"/>
                       <c:if  test="${usuario.perfil.equals(perfil) || usuario.perfil.equals(perfil1)}" >
                  <td>
                    <center>   
                      <!-- Mostramos un link para el archivo del CV que subio el usuario. El nombre del archivo lo tenemos
                      guadado en el campo archivo de la tabla solicitud y estan almacenados en la carpeta uploads en nuestro
                      directorio raiz de nuestra aplicacion.
                      -->
                      <a href="uploads/${solicitud.archivo}" target="_blank">
                        <img src="images/download.png" title="Descargar Curriculum Vitae">
                      </a>
                      &nbsp;&nbsp;&nbsp;
                       <!-- Mostramos un link para que el administrador le pueda enviar un correo electronico al usuario que
                       envio su CV. Mandamos el parametro email del usuario, al formulario donde se redactara el email.
                      -->
                      <a href="solicitud?action=responder&email=${solicitud.email}">
                        <img src="images/mail.png" title="Enviar correo electrónico.">
                      </a>
                    </center>  
                  </td>                                      
                </tr>
                </c:if>
                </c:if>
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
