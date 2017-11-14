<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<p style="color: red;">image page</p>

<p>Avatar Id is: ${avatar.avatarId}</p>

<div>
    ${avatar.image}
</div>

<img src="/imageServlet">






