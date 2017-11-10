<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<head>
    <link rel="stylesheet" href="${contextPath}/resources/css/registration.css"/>
</head>

<div class="signup">
    <div class="signup-message">
        <span>Присоединяйтесь к Твиттеру сегодня</span>
    </div>
    <div class="signup-form-div">

        <form:form method="post" modelAttribute="user" action="${contextPath}/registration" class="signup-form">
            <spring:bind path="name">
                <form:input path="name" type="text" placeholder="Имя и фамилия" id="name"/>
                <form:errors path="name" cssStyle="color: red"/>
            </spring:bind>
            <spring:bind path="nickname">
                <form:input path="nickname" type="text" placeholder="Никнэйм" id="nickname"/>
                <form:errors path="nickname" cssStyle="color: red"/>
            </spring:bind>
            <spring:bind path="username">
                <form:input path="username" type="text" placeholder="Электронная почта" id="username"/>
                <form:errors path="username" cssStyle="color: red"/>
            </spring:bind>
            <spring:bind path="password">
                <form:input path="password" type="password" placeholder="Пароль" id="password"/>
                <form:errors path="password" cssStyle="color: red"/>
            </spring:bind>
            <input type="submit" value="Регистрация"/>
        </form:form>

    </div>
</div>
