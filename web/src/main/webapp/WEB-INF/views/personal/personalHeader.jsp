<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<head>
    <link rel="stylesheet" href="${contextPath}/resources/css/personal.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/newTweet.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<div id="zatemnenie">
    <div class="modal-for-tweet">
        <div class="modal-header">
            <div class="modal-header-message">
                <span>Новый твит</span>
            </div>
            <div class="modal-header-close">
                <span><a href="#"><div class='cross'></div></a></span>
            </div>
        </div>
        <div class="modal-container">
            <div class="tweet-form">
                <form:form method="post" modelAttribute="tweet" action="${contextPath}/addNewTweet">

                    <spring:bind path="content">
                        <div class="tweet-form-message">
                            <form:input path="content" type="text" placeholder="Что нового?" id="contentTweet" name="contentTweet" autofocus="true"/>
                        </div>
                    </spring:bind>

                    <div class="tweet-form-buttonDiv">
                        <div class="tweet-button-div">
                            <input type="submit" name="submit" value="Твитнуть" class="tweet-button"/>
                        </div>
                    </div>

                    <spring:bind path="userNickname">
                            <form:input path="userNickname" type="hidden"  id="userNickname" name="userNickname" value="${user.nickname}"/>
                    </spring:bind>

                </form:form>
            </div>
        </div>
    </div>
</div>





<div class="header">
    <div class="header-container">
        <div class="header-container-left">
            <ul>
                <li><a href="#home">Главная</a></li>
                <li><a href="#about">Уведомления</a></li>
                <li><a href="#about">Сообщения</a></li>
            </ul>
        </div>
        <div class="header-container-right">
            <ul>
                <li>
                    <a href="#zatemnenie">
                        <input type="submit" name="submit" value="Твитнуть"/>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>


