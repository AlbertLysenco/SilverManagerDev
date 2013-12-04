<%-- 
    Document   : adminpage
    Created on : Oct 28, 2013, 6:05:17 PM
    Author     : albert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:set var="contextPath" value="${pageContext.request.contextPath}">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/960.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/text.css"/>
<!--        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.less"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/less-1.3.3.min.js"></script>-->
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
        <title>Admin Page</title>
    </head>

    <body>
        <div id="header">
            <ul id="navbar">
                    <li><a href="#">Клиент</a>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/clients">Все клиенты</a></li>
                            <li><a href="#">Добавить клиента</a></li>
                            <li><a href="#">Найти клиента</a></li>
                            </br>
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
            <div class="grid_12">
                
            </div>
        </div>

    </body>
</html>
