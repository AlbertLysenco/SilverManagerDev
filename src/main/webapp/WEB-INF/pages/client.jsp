<%-- 
    Document   : client
    Created on : Oct 26, 2013, 6:52:59 PM
    Author     : albert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Client</h1>
        <p>${id}</p>

        <table border="1">
            <tr>
                <th>ИД клиента</th>
                <th>Имя клиента</th>
                <th>Имя директора</th> 
            </tr>
                <td>${client.getClientId()}</td>
                <td>${client.getClientFullName()}</td>
                <td>${client.getClientDirName()}</td>
        </table>
    </body>
</html>
