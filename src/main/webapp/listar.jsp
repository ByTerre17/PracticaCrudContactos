

<%@page import="java.util.List"%>
<%@page import="modelo.Contactos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   
        <title>JSP Page</title>
        <style>
            #lista { padding: 30px}
        </style>
    </head>
    <body>
  <nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">Agenda</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="ServletContactos?op=listar">Listar Contactos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ServletContactos?op=insert1"">Nuevo Contacto</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Agenda</a>
      </li>
    </ul>
  </div>
</nav>
        <div  id="lista">
        <h1>Listado de Contactos</h1>
        <% List<Contactos> misContactos = (List<Contactos>) request.getAttribute("misContactos");
        %>
        <table class="table table-hover">
            <tr><th>id</th><th>Nombre</th><td>Direccion</td><td>Numero</td><td>Borrar</td><td>Actualizar</td></tr>
            <% for( Contactos c: misContactos) { 
            String cadenaBorrar = "<a onclick='return Confirmation()' href='ServletContactos?op=borrar&id="+c.getId()+"'><i class='far fa-trash-alt'></i></a>";
            String cadenaActualizar = "<a href='ServletContactos?op=update1&id="+c.getId()+"'><i class='far fa-edit'></i></a>";
             %>
            <tr>
                <td><%=c.getId()%></td><td><%=c.getNombre() %></td><td><%=c.getDireccion() %></td>
                <td><%=c.getNumero() %></td><td><%=cadenaBorrar%></td><td><%=cadenaActualizar%></td>
        
            </tr>    
            
            <% } %>
        </table>
        </div>
        <script>
            function Confirmation(){
                if ( confirm("Está seguro?")==true) {
                    alert("Procedo a borrar");
                    return true;
                }else {
                    alert("Operación cancelada");
                    return false;
                }
            }
        </script>

 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    </body>
</html>
