<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<head>
    <link rel="stylesheet" href="${contextPath}/resources/css/login.css"/>
</head>

<div class="signup">
    <div class="signup-message">
        <span>Войти в Твиттер</span>
    </div>
    <div class="signup-form-div">

        <form class="signup-form" method="post" action="${contextPath}/login">

            <input type="text" name="username" placeholder="Электронная почта"/>

            <input type="password" name="password" placeholder="Пароль"/>

            <label>
                <input type="checkbox" name="spring_security_remember_me"/>
                Запомнить
            </label>

            <div>
                <c:if test="${not empty error}">
                    неправильные имя или пароль
                </c:if>
            </div><br/><br/>

            <input type="submit" value="Войти"/>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        </form>

    </div>
</div>

