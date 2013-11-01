<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <title>JSP Page</title>
    </head>
    <body>
        <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
        <br/><br/>
        <a href="${contextPath}">Hello page</a>
        <br/><br/>
        <%@include file="segments/chooseOperationButtons.jspf" %>
        <br/><br/>
        <h1>Please Create New Client!</h1>
        <br/>
        <form:form method="POST">
            <table>

                <tr>                   
                    <td>Client Full Name : </td>
                    <td><form:input path="clientFullName"/></td>
                    <td><form:errors path="clientFullName"/></td>
                </tr>

                <tr>
                    <td>Client Director Name : </td>
                    <td><form:input path="clientDirName"/></td>
                    <td><form:errors path="clientDirName"/></td>
                </tr>

                <tr>                    
                    <td>Address : </td>
                    <td>
                        <form:select path="adressId">
                            <c:forEach items="${allAdresses}" var="adress">
                                <form:option value="${adress.getAdressId()}">${adress.getAdressCity()},  ${adress.getAdressStreet()} ${adress.getAdressHouseNumber()}</form:option>
                            </c:forEach>
                        </form:select>
                    </td>
                    <td><form:errors path="adressId"/></td>
                </tr>

                <tr>                    
                    <td>Stages : </td>
                    <td>
                        <form:select path="stageId">
                            <c:forEach items="${allStages}" var="stage">
                                <form:option value="${stage.getStageId()}">${stage.getStageName()}</form:option>
                            </c:forEach>
                        </form:select>
                    </td>
                    <td><form:errors path="stageId"/></td>
                </tr>

                <tr>                   
                    <td>Manager : </td>
                    <td>
                        <form:select path="managerId">
                            <c:forEach items="${allManagers}" var="manager">
                                <form:option value="${manager.getManagerId()}">${manager.getManagerFirstName()} ${manager.getManagerLastName()}</form:option>
                            </c:forEach>
                        </form:select>
                    </td>
                    <td><form:errors path="managerId"/></td>
                </tr>

                <tr>
                    <td>Client Status : </td>
                    <td>
                        <span>("ON" or "OFF")</span><br/>
                        <form:input path="clientStatus"/>
                    </td>
                    <td><form:errors path="clientStatus"/></td>
                </tr>

                <tr>                    
                    <td>Client Date On : </td>
                    <td>
                        <span>(yyyy/dd/mm)</span><br/>
                        <form:input path="clientDateOn"/>
                    </td>
                    <td><form:errors path="clientDateOn"/></td>
                </tr>

                <tr>                   
                    <td>Client Date Off : </td>
                    <td>
                        <span>(yyyy/dd/mm)</span><br/>
                        <form:input path="clientDateOff" id="date"/>
                    </td>
                    <td><form:errors path="clientDateOff"/></td>
                </tr>

                <tr>                    
                    <td>Service ID: </td>
                    <td>
                        <form:select path="serviceId">
                            <c:forEach items="${allServices}" var="service">
                                <form:option value="${service.getServiceId()}">${service.getServiceId()}</form:option>
                            </c:forEach>
                        </form:select>
                    </td>
                    <td><form:errors path="serviceId"/></td>
                </tr>
                <tr>
                    <td><form:button>ADD</form:button></td>
                    </tr>
                </table>
        </form:form>
    </body>
</html>
