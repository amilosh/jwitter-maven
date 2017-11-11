<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<head>
    <link rel="stylesheet" href="${contextPath}/resources/css/registration.css"/>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/resources/js/registration.js"></script>

    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

</head>

<div class="signupWrapper">

    <div class="signupEmty">

    </div>

    <div class="signup">
        <div class="signup-message">
            <span>Присоединяйтесь к Твиттеру сегодня</span>
        </div>
        <div class="signup-form-div">

            <form:form OnSubmit='return Validate(this);' method="post" modelAttribute="user" action="${contextPath}/registration" class="signup-form">
                <spring:bind path="name">
                    <form:input path="name" type="text" placeholder="Имя и фамилия" id="name" name="name" oninput="checkAfterChangeName()"/>
                    <form:errors path="name" cssStyle="color: red"/>
                </spring:bind>
                <spring:bind path="nickname">
                    <form:input path="nickname" type="text" placeholder="Никнэйм" id="nickname" name="nickname" oninput="checkAfterChangeNickName()"/>
                    <form:errors path="nickname" cssStyle="color: red"/>
                </spring:bind>
                <spring:bind path="username">
                    <form:input path="username" type="text" placeholder="Электронная почта" id="username" name="username" oninput="checkAfterChangeUsername()"/>
                    <form:errors path="username" cssStyle="color: red"/>
                </spring:bind>
                <spring:bind path="password">
                    <form:input path="password" type="password" placeholder="Пароль" id="password" name="password" oninput="checkAfterChangePassword()"/>
                    <form:errors path="password" cssStyle="color: red"/>
                </spring:bind>
                <input type="submit" name="submit" value="Регистрация" id="submitRegistration"/>
            </form:form>

        </div>
    </div>

    <div class="ajaxDiv">
        <div class="ajaxName"><span class="ajaxDivSpan" id="nameAfterJavaScript">John Doe</span></div>
        <div class="ajaxNickname"><span class="ajaxDivSpan" id="nickNameAfterJavaScript">john_doe</span></div>
        <div class="ajaxEmail"><span class="ajaxDivSpan" id="emailAfterJavaScript">johndoe@gmail.com</span></div>
        <div class="ajaxPassword"><span class="ajaxDivSpan" id="passwordAfterJavaScript">twi-2017!</span></div>
    </div>

</div>