<%-- 
    Document   : WebMostrarArgumentosBicicletas
    Created on : 20-sep-2015, 8:58:02
    Author     : Nacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"
          prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Argumentos de la bicicleta</h1>
        <form>
            
            <c:out value="${argumento}"
                   escapeXml="false"/>
               
        </form>
        
             <c:out value="${compra}"
                   escapeXml="false"/>
    </body>
</html>