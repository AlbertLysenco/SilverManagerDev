<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    </head>
    <body>
        <p>hello.jsp</p>
        <a href="${contextPath}/clients">Show all clients</a><br/><br/>
        <a href="${contextPath}/crud/client">ADD New Client</a>
    </body>
</html>
