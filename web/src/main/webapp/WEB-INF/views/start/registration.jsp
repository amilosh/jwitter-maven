<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<head>
    <link rel="stylesheet" href="${contextPath}/resources/css/registration.css"/>
</head>

<div class="signup">
    <div class="signup-message">
        <span>Присоединяйтесь к Твиттеру сегодня</span>
    </div>
    <div class="signup-form-div">
        <form class="signup-form">
            <input type="text" placeholder="Имя и фамилия"/>
            <input type="text" placeholder="Электронная почта"/>
            <input type="password" placeholder="Пароль"/>
            <input type="submit" value="Регистрация"/>
        </form>
    </div>
</div>
