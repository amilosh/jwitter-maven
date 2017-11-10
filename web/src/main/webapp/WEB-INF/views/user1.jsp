<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>user</title>
</head>
<body>

<div class="wrapper">

    <p style="color: red">this is <b>user</b> page</p><br/><br/>

    <span>
            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.name != null}">
                    <a href="${contextPath}/personal">личная страница: ${pageContext.request.userPrincipal.name}</a> | <a href="${contextPath}/logout1">logout </a>
                </c:when>
                <c:otherwise>
                    <a href="${contextPath}/login">login </a> | <a href="${contextPath}/registration">registration </a>
                </c:otherwise>
            </c:choose>
    </span><br/><br/>

    <a href="/user1">перейти на <b>user</b></a><br/><br/>

    <a href="/admin1">перейти на <b>admin</b></a><br/><br/>

    <a href="/1">перейти на <b>main</b></a><br/><br/>


</div>

</body>
</html>
