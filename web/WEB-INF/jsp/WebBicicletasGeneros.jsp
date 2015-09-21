<%-- 
    Document   : WebBicicletasGeneros
    Created on : 20-sep-2015, 9:29:43
    Author     : Nacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"
          prefix="c" %>

 
 
<!DOCTYPE html>
<html>
    <head>
        
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--        <title>JSP Page</title>-->
    </head>
    <body>
        <h1 style='text-align: center' style='color: blue'>Selecciona el tipo de Bicicleta</h1>
         
        <div style='float:left' class="col-sm-3" style="background-color:blue;"class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav nav-pills nav-stacked" class="nav navbar-nav">
                <c:forEach items="${generos}" var="genero">
                    <li class="dropdown">
                        <a href='WebBicicletasGeneros.htm?idgenero=<c:out value="${genero.idgenero}"/>'>
                            <c:out value="${genero.genero}"/>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>            
        <div style='float:left' class="col-sm-6" style="background-color:lavenderblush;">
            <c:if test="${not empty bicicletas}">
                <dl>
                    <c:forEach items="${bicicletas}" var="bicicleta">
                        <dt><b>
                            Marca:
                            <c:out value="${bicicleta.marca}"/>
                        </b>
                         <img src='BICIS/<c:out value="${bicicleta.foto}"/>'
                             style='width: 200px; height: 270px' />
                        </dt>
                        <dd>
                            Precio:
                            <c:out value="${bicicleta.precio}"/>€
                        </dd>
          
                        <dd>
                            <a href='WebDetallesBicicleta.htm?idbicicleta=<c:out value="${bicicleta.idbicicleta}"/>&idgenero=<c:out value="${bicicleta.idgenero}"/>'>
                                Detalles
                            </a>
                        </dd>   
                        <br/>
                    </c:forEach>                    
                </dl>
            </c:if>
        </div>
         
         <div style='float:center'class="col-sm-3" style="background-color:blue;">
         
             
             <a href='WebCarritoCompra.htm'> <img src="BICIS/carrito.jpg"  style='width: 100px; height: 100px' /> </a>   

             
        </div>
    </body>
</html>