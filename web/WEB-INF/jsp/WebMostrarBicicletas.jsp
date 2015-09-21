<%-- 
    Document   : WebMostrarBicicletas
    Created on : 20-sep-2015, 9:01:52
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
        <h1>Bicicletas</h1>
        
        <form action="WebMostrarBicicletas.jsp">
            
            <c:out value="${bicicletas}"
                   escapeXml="false"/>
        </form>
        
    </body>
</html>
