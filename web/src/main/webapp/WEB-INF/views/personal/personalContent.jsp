<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<head>
    <link rel="stylesheet" href="${contextPath}/resources/css/personal.css"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/changeProfile.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<div id="changeProfile">
    <div class="modal">
        <div class="modal-header">
            <span>Изменить прифиль</span>
        </div>
        <div class="changeProfile-container">
            <div class="changeProfile-form">
                <form:form method="post" modelAttribute="user" action="${contextPath}/personal/changeProfile1">
                <table>
                    <tr>
                        <td>О себе:</td>
                        <td>
                            <div>
                                <spring:bind path="message">
                                    <form:input path="message" type="text" placeholder="message"/>
                                </spring:bind>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Место:</td>
                        <td>
                            <div>
                                <spring:bind path="location">
                                    <form:input path="location" type="text" placeholder="location"/>
                                </spring:bind>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Сайт:</td>
                        <td>
                            <div>
                                <spring:bind path="site">
                                    <form:input path="site" type="text" placeholder="site"/>
                                </spring:bind>
                            </div>
                        </td>
                    </tr>
                </table>

            <div class="tweet-form-buttonDiv">
                <div class="tweet-button-div">
                    <input type="submit" name="submit" value="Сохоанить" class="tweet-button"/>
                </div>
            </div>

            <%--<spring:bind path="userNickname">--%>
                <%--<form:input path="userNickname" type="hidden"  id="userNickname" name="userNickname" value="${user.nickname}"/>--%>
            <%--</spring:bind>--%>

            </form:form>
        </div>
    </div>
</div>
</div>


<div class="profile-header">
    <div class="profile-header-container">

        <div class="profile-info">
            <div class="profile-info-username">
                <a href="${contextPath}/personal/${user.nickname}">
                    <span class="username">${user.name}</span>
                </a>
            </div>
            <div class="profile-info-nickname">
                <a href="${contextPath}/personal/${user.nickname}">
                    <span class="nickname">@${user.nickname}</span>
                </a>
            </div>
        </div>

        <div class="profile-navbar">
            <ul>
                <li class="profile-navbar-left">
                    <a href="#home">
                        <span class="profile-navbar-text">Твиты</span>
                        <span class="profile-navbar-number">202</span>
                    </a>
                </li>
                <li class="profile-navbar-left">
                    <a href="#about">
                        <span class="profile-navbar-text">Читаемые</span>
                        <span class="profile-navbar-number">391</span>
                    </a>
                </li>
                <li class="profile-navbar-left">
                    <a href="#about">
                        <span class="profile-navbar-text">Читатели</span>
                        <span class="profile-navbar-number">98</span>
                    </a>
                </li>
                <li class="profile-navbar-left">
                    <a href="#about">
                        <span class="profile-navbar-text">Нравится</span>
                        <span class="profile-navbar-number">3294</span>
                    </a>
                </li>
                <li class="profile-navbar-right">
                    <div class="profile-navbar-right-button-div">
                        <a href="#changeProfile" class="profile-navbar-right-button-div-a">
                            <button type="button" class="profile-navbar-right-button">Изменить профиль</button>
                        </a>
                    </div>

                </li>
                </ul>
        </div>
    </div>
</div>

<div class="content">

    <div class="profile-data">
        <div class="profile-data-content">
            <span class="profile-data-content-username">${user.name}</span>
            <span class="profile-data-content-meaasge">${user.message}</span>
            <span class="profile-data-content-location">${user.location}</span>
            <span class="profile-data-content-link">${user.site}</span>
            <span class="profile-data-content-registration">Дата регистрации: июнь 2009</span>
        </div>
    </div>

    <div class="tweets">
        <div class="tweets-content">
            <div class="tweets-content-header">
                <ul>
                    <li><a href="#">Твиты</a></li>
                    <li><a href="#">Твиты и ретвиты</a></li>
                </ul>
            </div>



            <c:forEach var="tweet" items="${tweets}">
                <div class="tweet">
                    <div class="tweet-header">
                        <span><a href="#">${user.nickname}</a></span>
                    </div>
                    <div class="tweet-content">
                        ${tweet.content}
                    </div>
                    <div class="tweet-footer">
                        <span><a href="#" class="tweet-footer-answer">Ответить</a></span>
                        <span><a href="#" class="tweet-footer-retweet">Ретвит</a></span>
                        <span><a href="#" class="tweet-footer-like">Лайк</a></span>
                    </div>
                </div>
            </c:forEach>



        </div>
    </div>


    <div class="recommendation">
        <div class="recommendation-content">
            <span class="recommendation-content-interest">Вам также может понравиться</span>
            <span class="recommendation-content-new"><a href="#">Обновить</a></span>
            <span class="recommendation-content-link"><a href="#">Denis Blisch</a></span>
            <span class="recommendation-content-link"><a href="#">GUVD_Minsk</a></span>
            <span class="recommendation-content-link"><a href="#">РБ головного мозга</a></span>
            <span class="recommendation-content-link"><a href="#">112.by МЧС Беларуси</a></span>
            <span class="recommendation-content-link"><a href="#">Onlinar.by</a></span>
        </div>

        <div class="footer">
            <ul>
                <li>Twitter, 2017</li>
                <li><a href="#">О нас</a></li>
                <li><a href="#">Справочный центр</a></li>
                <li><a href="#">Условия</a></li>
                <li><a href="#">Политика конфиденциальности</a></li>
                <li><a href="#">Файлы cookie</a></li>
                <li><a href="#">О рекламе</a></li>
            </ul>
        </div>

    </div>
</div>




