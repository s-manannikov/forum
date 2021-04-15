<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style><%@include file="/style/style.css"%></style>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Forum</title>
</head>
<body>

<div class="rc_nav" id="centered_nav">
    <a href="<c:url value='/'/>">Home</a>
    <a href="<c:url value='/add'/>">Create Post</a>
    <a href="<c:url value='/login'/>">Sign in</a>
    <a href="<c:url value='/reg'/>">Sign Up</a>
</div>

<div class="signup">
    <form id="signup" action="<c:url value='/login'/>" method="post">
        <div class="header">
            <h3>Sign In</h3>
            <c:if test="${not empty errorMessage}">
                <p>${errorMessage}</p>
            </c:if>
        </div>
        <div class="sep"></div>
        <div class="inputs">
            <input type="username" id="username" name="username" placeholder="username" autofocus />
            <input type="password" id="password" name="password" placeholder="password" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button id="submit" type="submit">SIGN IN</button>
        </div>
    </form>
</div>

</body>
</html>