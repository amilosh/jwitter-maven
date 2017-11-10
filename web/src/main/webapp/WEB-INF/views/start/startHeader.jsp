<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<head>
    <link rel="stylesheet" href="${contextPath}/resources/css/start.css"/>
</head>

<c:choose>
    <c:when test="${pageContext.request.userPrincipal.name != null}">

    </c:when>
    <c:otherwise>
        <div class="header">
            <div class="header-container">
                <div class="header-container-left">
                    <ul>
                        <li><a href="#home">Главная</a></li>
                        <li><a href="#about">О нас</a></li>
                        <ul>
                </div>
                <div class="header-container-right">
                    <ul>
                        <li><a href="#home">Язык: <b>Русский</b></a></li>
                        <ul>
                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>



