<%-- 
    Document   : WebDetallesBicicleta
    Created on : 20-sep-2015, 9:59:54
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style='text-align: center'>Detalles de la bicicleta</h1>
        <form style='text-align: center'>
        <dl style='alignment-adjust: center' style='text-align: justify'>
            <dt><b> Modelo:
                <c:out value="${bicicleta.modelo}"/>
            </b>
            <br/>
            <img src='BICIS/<c:out value="${bicicleta.foto}"/>'
                 style='width: 200px; height: 270px' />
            </dt>
            
            <dd>
                 Marca: 
                <c:out value="${bicicleta.marca}"/>
            </dd>
            
 
            <dd>
                Color: 
                <c:out value="${bicicleta.color}"/>
            </dd>
              <dd>
                  Talla: 
                <c:out value="${bicicleta.talla}"/>
            </dd>
            <dd>Precio: 
                <c:out value="${bicicleta.precio}"/>€
            </dd>
            <dd>
                <br/>
            <a href='WebDetallesBicicleta.htm?comprar=<c:out value="${bicicleta.idbicicleta}"/>'>
                Comprar bicicleta
            </a>
            </dd>                    
            <dd>
                <a href='WebBicicletasGeneros.htm?idgenero=<c:out value="${bicicleta.idgenero}"/>'>
                    Volver
                </a>
            </dd>
        </dl>  
        <h3 style='color:blue'>
            <c:out value="${mensaje}"/>
        </h3>
        
        </form>
    </body>
</html>

