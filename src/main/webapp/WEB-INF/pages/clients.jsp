<%-- 
    Document   : clients
    Created on : Oct 26, 2013, 6:35:16 PM
    Author     : albert
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Client list</h1>

        <c:forEach var="clientlist" items="${clientlist}">
            <ul>
                <li><a href="client?id=${clientlist.getClientId()}">${clientlist.getClientFullName()}</a></li>
            </ul>
        </c:forEach>


    </body>
</html>
