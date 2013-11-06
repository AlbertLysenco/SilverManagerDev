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
        <h1>Please choose operation for your Client!</h1>
        <br/>
        <h3>Searching works by ID and Full Name!!</h3>
        <br/>
        <form:form method="POST">
            <table>

                <tr>                   
                    <td>Client ID : </td>
                    <td><form:input path="clientId"/></td>
                    <td><form:errors path="clientId"/></td>
                </tr>

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
                            <c:if test="${selectedAdress != null}">
                                <form:option value="${selectedAdress.getAdressId()}">${selectedAdress.getAdressCity()},  ${selectedAdress.getAdressStreet()} ${selectedAdress.getAdressHouseNumber()}</form:option>
                            </c:if>
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
                            <c:if test="${selectedStage != null}">
                                <form:option value="${selectedStage.getStageId()}" label="${selectedStage.getStageName()}"/>
                            </c:if>
                            <form:options items="${allStages}" itemValue="stageId" itemLabel="stageName"/>
                        </form:select>
                    </td>
                    <td><form:errors path="stageId"/></td>
                </tr>

                <tr>                   
                    <td>Manager : </td>
                    <td>
                        <form:select path="managerId">
                            <c:if test="${selectedManager != null}">
                                <form:option value="${selectedManager.getManagerId()}">${selectedManager.getManagerFirstName()} ${selectedManager.getManagerLastName()}</form:option>
                            </c:if>
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
                        <span>(yyyy-dd-mm)</span><br/>
                        <form:input path="clientDateOn"/>
                    </td>
                    <td><form:errors path="clientDateOn"/></td>
                </tr>

                <tr>                   
                    <td>Client Date Off : </td>
                    <td>
                        <span>(yyyy-dd-mm)</span><br/>
                        <form:input path="clientDateOff" id="date"/>
                    </td>
                    <td><form:errors path="clientDateOff"/></td>
                </tr>

                <tr>                    
                    <td>Service ID: </td>
                    <td>
                        <form:select path="serviceId">
                            <c:if test="${selectedService != null}">
                                <form:option value="${selectedService.getServiceId()}" label="${selectedService.getServiceId()}"/>
                            </c:if>
                            <c:forEach items="${allServices}" var="service">
                                <form:option value="${service.getServiceId()}" label="${service.getServiceId()}"/>
                            </c:forEach>
                        </form:select>
                    </td>
                    <td><form:errors path="serviceId"/></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="operation" value="add"/>
                        <input type="submit" name="operation" value="edit"/>
                        <input type="submit" name="operation" value="delete"/>
                    </td>
                    <td>
                        <input type="submit" name="operation" value="search by ID"/>
                        <input type="submit" name="operation" value="search by Full Name"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
