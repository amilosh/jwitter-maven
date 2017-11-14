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

<%--<img src="/imageServlet">--%>

<img src="/uploadFileREST">



<br/><br/>


<form method="POST" action="/uploadFile?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
    File to upload: <input type="file" name="file">
    <input type="submit" value="Upload"> Press here to upload the file!
</form>







