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
    
     <script src='tinymce/tinymce.min.js'></script>
<!--
    <script>

      tinymce.init({
        selector: '#detalle',
        plugins: "textcolor, table",
        /* https://www.tinymce.com/docs/advanced/editor-control-identifiers/#toolbarcontrols */
        toolbar: "styleselect | undo redo | removeformat | bold italic underline | table \n\
                  aligncenter alignjustify  | bullist numlist outdent indent | link | print | \n\
                  fontselect fontsizeselect forecolor backcolor",
      });

    </script>
    -->
    
     <style type="text/css">
        #idUsuario { display: none}
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
          <h3 class="panel-title">Crear Vacante</h3>
        </div>
        <div class="panel-body">
         <form action="nueva-vacante" method="post">
            <div class="form-group">
              <label for="nombre">Nombre</label>
              <input type="text" class="form-control" name="nombre" required id="nombre" value="" placeholder="Escriba el nombre la vacante">
            </div>                   
            <div class="form-group">
              <label for="descripcion">Descripción</label>
              <textarea class="form-control" name="descripcion" id="descripcion" required rows="3" placeholder="Escribe una descripción de la vacante"></textarea>
            </div>
            <div class="form-group">
              <label for="detalle">Escriba los detalles</label>
              <textarea class="form-control" name="detalle" id="detalle" rows="4" placeholder="Escriba los detalles de la vacante"></textarea>
            </div>
              <div class="form-group">
              <label for="ciudad">Lugar de trabajo</label>
              <textarea class="form-control" name="ciudad" id="ciudad" rows="4" placeholder="Escriba el lugar de trabajo"></textarea>
            </div>
              <div class="form-group">
              <label for="estudios">Nivel académico</label>
              <select class="form-control" name="estudios" id="estudios" rows="4" placeholder="Escriba el nivel académico">
                  <option>Sin estudios </option>
                  <option>Educación Secundaria </option>
                  <option>Bachillerato</option>
                  <option>Formación Profesional Grado Medio</option>
                  <option>Formación Profesional Grado Superior</option>
                  <option>Grado</option>
                  <option>Licenciatura</option>
                  <option>Diplomatura</option>
                  <option>Postgrado</option>
                  <option>Ingeniería Técnica</option>
                  <option>Ingeniería Superior</option>
                  <option>Máster</option>
                  <option>Otros títulos, certificaciones y carnés</option>
                  <option>Otros cursos y formación no reglada</option>
              </select>
            </div>
              <div class="form-group">
              <label for="experiencia">Experiencia requerida</label>
              <textarea class="form-control" name="experiencia" id="experiencia" rows="4" placeholder="Escriba la experiencia requerida"></textarea>
            </div>
              <div class="form-group">
              <label for="jornada">Jornada</label>
              <select class="form-control" name="jornada" id="jornada" rows="4" placeholder="Escriba la jornada de la vacante">
                  <option>Completa</option>
                  <option>Parcial - Mañana</option>
                  <option>Parcial - Tarde</option>
                  <option>Parcial - Noche</option>
                  <option>Parcial - Rotatoria</option>
              </select>
            </div>
              <div class="form-group">
              <label for="salario">Escriba el salario</label>
              <textarea class="form-control" name="salario" id="salario" rows="4" placeholder="Escriba el salario de la vacante"></textarea>
            </div>
             <div class="form-group">
             <input type="text" class="form-control" name="idUsuario" id="idUsuario" rows="4" value="${usuario.id}" placeholder="">
              </div>
            <button type="submit" class="btn btn-default" >Guardar</button>
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

