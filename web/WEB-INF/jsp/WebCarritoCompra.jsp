<%-- 
    Document   : WebCarritoCompra
    Created on : 20-sep-2015, 9:47:37
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
        
        
        
        <div style='text-align: center'>
        <h1 style='text-align: center'>Carrito de la compra</h1>
        <h3 style='color:blue'>
            Bicicletas compradas: 
            <c:choose>
                <c:when test="${sessionScope.CARRITO == null}">
                    
                </c:when>
                <c:otherwise>
                    <c:out value="${sessionScope.CARRITO.size()}"/>
                </c:otherwise>
            </c:choose>
        </h3>
        <h3 style='color:red'>
            <c:out value="${mensaje}"/>
        </h3>
        <c:if test="${not empty bicicletas}">
                <dl>
                    <c:forEach items="${bicicletas}" var="bicicleta">
                        <dt><b>
                            <c:out value="${bicicleta.marca}"/>
                        </b>
                        <img src='BICIS/<c:out value="${bicicleta.foto}"/>'
                             style='width: 200px; height: 270px' />
                        </dt>
                        <dd>
                            <c:out value="${bicicleta.precio}"/>€
                        </dd>
                        <dd>
                            <a href='WebCarritoCompra.htm?eliminar=<c:out value="${bicicleta.idbicicleta}"/>'>
                                Eliminar
                            </a>
                        </dd>                    
                        <dd>
                            <a href='WebDetallesBicicleta.htm?idbicicleta=<c:out value="${bicicleta.idbicicleta}"/>'>
                                Detalles
                            </a>
                        </dd>
                    </c:forEach>                    
                </dl>
        </c:if>  
        <a href='WebBicicletasGeneros.htm'>
            Ir a Seleccionar tipo de  Bicicletas
        </a>
        
        <br/>
        <br/>
        
        <!-- PayPal Logo --><table border="0" cellpadding="10" cellspacing="0" align="center">
            <tbody><tr><td align="center"></td></tr><tr><td align="center">
                        <a href="https://www.paypal.com/es/webapps/mpp/paypal-popup" title="Cómo funciona PayPal" onclick="javascript:window.open('https://www.paypal.com/es/webapps/mpp/paypal-popup','WIPaypal','toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, width=1060, height=700'); return false;">
                            <img src="https://www.paypalobjects.com/webstatic/mktg/logo-center/logotipo_paypal_pagos.png" border="0" alt="Pague con PayPal" /></a>
                        <div style="text-align:center"><a href="https://www.paypal.com/es/webapps/mpp/why" target="_blank"><font size="2" face="Arial" color="#0079CD"><strong>Cómo funciona PayPal</strong></font></a></div></td></tr></tbody></table><!-- PayPal Logo -->
        
        </div>
        
        
    </body>
</html>