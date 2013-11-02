<%-- 
    Document   : login
    Created on : Oct 31, 2013, 10:26:54 PM
    Author     : artem
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Log IN!</h1>
        <form method="POST" action="<c:url value='j_spring_security_check'/>">
            <table>
                <tr>
                    <td>Userame</td>
                    <td><input type="text" name="j_username"/></td>
                    <td><label>Admin</label></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="j_password"/></td>
                    <td><label>12345</label></td>
                </tr>
                <tr>
                    <td><input type="submit" value="login"/></td>
                </tr>
                <tr>
                    <td>Remember me</td>
                    <td><input type="checkbox" name="_spring_security_remember_me"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
