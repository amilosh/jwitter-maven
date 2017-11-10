<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <link rel="stylesheet" href="${contextPath}/resources/css/template.css"/>
</head>
<body>

    <header id="header">
        <tiles:insertAttribute name="header"/>
    </header>

    <nav id="navBar">
        <tiles:insertAttribute name="navBar"/>
    </nav>

    <section id="content">
        <tiles:insertAttribute name="content"/>
    </section>

    <footer id="footer">
        <tiles:insertAttribute name="footer"/>
    </footer>


</body>
</html>