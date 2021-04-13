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
    <a href="<c:url value='/add'/>">Add Post</a>
    <a href="<c:url value='/login'/>">Sign in</a>
    <a href="<c:url value='/reg'/>">Sign Up</a>
</div>

<div class="wrapper">
    <form action="<c:url value='/addpost'/>" method="post">
        Title:<br>
        <textarea id="name" name="name" rows="1" cols="100"></textarea><br><br>
        Text:<br>
        <textarea id="description" name="description" rows="4" cols="100"></textarea><br><br>
        <button type="submit">add</button>
    </form>
</div>

</body>
</html>