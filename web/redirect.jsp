<%--
Views should be stored under the WEB-INF folder so that
they are not accessible except through controller process.

This JSP is here to provide a redirect to the dispatcher
servlet but should be the only JSP outside of WEB-INF.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!--<ol>
    <li>
        <a href="Web01PrimeraVista.htm">
            Primera Vista de Spring
        </a>
    </li>
    <li>
        <a href="Web02InfoControladorVista.htm">
            Información Controlador Vista
        </a>
    </li>
    <li>
        <a href="Web03InfoVistaControlador.htm">
            Información Vista Controlador
        </a>
    </li>
    <li>
        <a href="Web04PedirNumero.htm">
            Tabla de multiplicar con dos páginas
        </a>
    </li>
     <li>
        <a href="Web05ObjetosContainer.htm">
            Recuperar objstos Application Context
        </a>
    </li>
    <li>
        <a href="Web06DatosApplicationContext.htm">
            Acceso a datos con JDBC Spring Container
        </a>
    </li>
    <li>
        <a href="Web07EliminarEnfermo.htm">
            Eliminar Enfermos JDBC
        </a>
    </li>
    <li>
        <a href="Web08MultiplesAcciones.htm?operacion=inicio">
            Múltiples Acciones en Controller
        </a>
    </li>
    <li>
        <a href="Web09Departamentos.htm?operacion=inicio">
            Múltiples Acciones en Departamentos
        </a>
    </li>
    
    <li>
        <a href="Web10MostrarPeliculas.htm?operacion=inicio">
            Múltiples Acciones en Peliculas
        </a>
    </li>
    
    <li>
        <a href="Web11CrearSession.htm">
            Objetos Session con Spring
        </a>
    </li>
 
     <li>
        <a href="Web12AlmacenarSalarioEmpleados.htm">
            Almacenar salario empleados Session
        </a>
    </li>
     <li>
        <a href="Web13AlmacenarEmpleadoSession.htm">
            Almacenar empleados Session
        </a>
    </li>
    
     <li>
        <a href="Web14ValidarDoctor.htm">
            Validar doctor Session
        </a>
    </li>
     <li>
        <a href='Web15PeliculasGeneros.htm'>
            Carrito de la compra peliculas
        </a>
    </li>    
    
 
     <li>
        <a href='Web16NombreDepartamentoDao.htm'>
            Buscar NOMBRE Departamento DAO
        </a>
    </li>    
    
     <li>
        <a href='Web17ConsultaSeleccionDao.htm'>
            Consultas de Seleccion DAO
        </a>
    </li>  
    
    <li>
        <a href='Web18ConsultasParametrizadas.htm'>
            Consultas parametrizadas Spring DAO
        </a>
    </li>  
     <li>
        <a href='Web19ModificarDepartamentosDao.htm'>
            Modificar Departamento Spring DAO
        </a>
    </li>  
    
     <li>
        <a href='Web20InsertarDepartamentoDao.htm'>
            Insertar Departamento Spring DAO
        </a>
    </li>  
    
    <li>
        <a href='Web21EliminarDepartamentosBatch.htm'>
            Eliminar Departamento Batch Spring DAO
        </a>
    </li>  
    
    <li>
        <a href='Web22BuscarEmpleadosOficio.htm'>
            Buscar empleados oficio DAO
        </a>
    </li> 
    
    <li>
        <a href='Web23ModificarSalarioPlantilla.htm'>
           Modificar Salario Plantilla DAO
        </a>
    </li> 
     <li>
        <a href='Web24ClientesDaoSupport.htm'>
           Insertar Clientes JdbcDaosupport
        </a>
    </li> 
    
      <li>
        <a href="WebMostrarBicicletas.htm?operacion=inicio">
            Entrar Tienda
        </a>
    </li>
    -->
<!--    
        <a href='WebBicicletasGeneros.htm'>
            Entrar Tienda 2
        </a>-->
<hr/>

<!DOCTYPE html>
<html lang="en">
<head>
<!--  <title>Bootstrap Example</title>-->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 
  <style>
  .btn-default {
      background: #000;
      color: #fff;
   }
  .btn-default:hover {
      background: #fff;
      color: #000;
   }
  </style>
  
  
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
  </style>
</head>
<body>
    <form action="WebBicicletasGeneros.htm">
<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="BICIS/logo.jpg" alt="Tienda" width="460" height="345">
      </div>

      <div class="item">
        <img src="BICIS/museo.jpg" alt="Museo" width="460" height="345">
      </div>
    
      <div class="item">
        <img src="BICIS/audi.jpg" alt="Logo" width="460" height="345">
      </div>

      <div class="item">
        <img src="BICIS/xt.jpg" alt="Componentes" width="460" height="345">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Anterior</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Siguiente</span>
    </a>
    
  </div>
  
  <div class="container text-center">
     

      <button type="submit" class="btn btn-primary btn-lg" style="text-align:center" >Entrar a tienda</button>

    </form>
</body>
</html>