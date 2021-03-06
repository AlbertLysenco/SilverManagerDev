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
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/960.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/text.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
        <script>
            $(function() {
                $('#navbar li').hover(function() {
                    $(this).children('ul').stop(false, true).fadeIn(300);
                }, function() {
                    $(this).children('ul').stop(false, true).fadeOut(300);
                });
            });
        </script>
        <title>Client list</title>
    </head>
    <body>
        <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
        <br/><br/>
        <div id="header">
            <ul id="navbar">
                <li><a href="#">Клиент</a>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/clients">Все клиенты</a></li>
                        <li><a href="#">Добавить клиента</a></li>
                        <li><a href="#">Найти клиента</a></li>
                    </ul>
                </li>
                <li><a href="#">Техплощадки</a>
                    <ul>
                        <li><a href="#">Все техплощадки</a></li>
                        <li><a href="#">Добавить техплощадку</a></li>
                        <li><a href="#">Найти техплощадку</a></li>
                    </ul>
                </li>
                <li><a href="#">Заявки</a>
                    <ul>
                        <li><a href="#">Все заявки</a></li>
                        <li><a href="#">Апхив заявок</a></li>
                    </ul>
                </li>
                <li><a href="#">Администирование</a>
                    <ul>
                        <li><a href="#">Админ панель</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="container_12">
            <div class="grid_2" id="bodylist">
                <h1>Клиенты:</h1>
                <!--<a href="${contextPath}">Hello page</a>-->
                <c:forEach var="clientlist" items="${clientlist}">
                    <ul>
                        <li><a href="${contextPath}/client?id=${clientlist.getClientId()}" >${clientlist.getClientFullName()}</a></li>
                    </ul>
                </c:forEach>
            </div>
            <div class="grid_9" id="clientinfo">
                <h1>Информация по клиенту:</h1>

            </div>
            <div class="clear"></div>
        </div>


    </body>
</html>
