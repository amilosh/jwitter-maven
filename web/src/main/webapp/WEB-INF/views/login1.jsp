<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
        <title>Login Page</title>
</head>
<body>

                <form class="form" method="post" action="${contextPath}/login1">

                        <input type="text" name="username" placeholder="username" class="inputlogin"><br/><br/>

                        <input type="text" name="password" placeholder="<password" class="inputpassword"><br/><br/>

                        <div>
                            <button type="submit" class="entersubmit">login</button><br/><br/>
                        </div>

                        <div>
                            <input type="checkbox" name="spring_security_remember_me" class="rememberme" id="rememberMe">
                            <label for="rememberMe" class="remembermelabel">запомнить меня</label><br/><br/>
                        </div>


                    <div>
                        <c:if test="${not empty error}">
                            неправильные имя или пароль
                        </c:if>
                    </div><br/>

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                </form>



</body>
</html>

