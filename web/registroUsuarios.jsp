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
    <link href="css/regin.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">
        <center>
          <a href="inicio"><img  src="images/jobnet2.png"><br></a>
        </center>        
        <form class="form-regin" method="post" action="registro">
        <h2 class="form-regin-heading">Registro de nuevo usuario</h2>
        <label for="user" class="sr-only">Nombre de usuario</label>
        <input type="text" id="user" name="user" class="form-control" placeholder="Escriba nombre de usuario" required autofocus>
        <label for="pass" class="sr-only">Password</label>
        <input type="password" id="pass" name="pass" class="form-control" placeholder="Escriba su password" required> 
         
        <label for="perfil" class="sr-only">Perfil de usuario: </label>
          <select class="form-control" name="perfil" id="perfil" rows="4" placeholder="Elija su perfil">
                  <option>Trabajador</option>
                  <option>Empresa</option>
              </select>
        <p class="text-danger">${message}</p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Registrarse</button>
      </form>

    </div> <!-- /container -->

  </body>
</html>