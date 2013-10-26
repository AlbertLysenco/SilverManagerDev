<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    </head>
    <body>
        <p>hello.jsp</p>
        <a href="${contextPath}/clients">Show all clients</a>
        <h1>${message}</h1>

        <!--            <table border="1">
                        <tr>
                            <th>Ид клиента</th>
                            <th>Client Name</th>
                            <th>Client Director Name</th>
                            <th>Client Status</th>
                            <th>Manager</th>
                        </tr>
        <c:forEach var="list" items="${list}">
        <tr>
            <td>${list.getClientId()}</td>
            <td>${list.getClientFullName()}</td>
            <td>${list.getClientDirName()}</td>
            <td>${list.getClientStatus()}</td>
            <td>${list.getManagerId().getManagerFirstName()}</td>
            
        </tr>
        </c:forEach>
    </table> -->



        
            <ul>
                <c:forEach var="client" items="${list}">
                    <li>${client.getClientFullName()}</li>
                </c:forEach>
            </ul>
        


    </body>
</html>
