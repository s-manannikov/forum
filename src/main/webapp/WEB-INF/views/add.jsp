<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style><%@include file="/style/style.css"%></style>
<style><%@include file="/style/poststyle.css"%></style>

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
    <a href="<c:url value='/logout'/>">Sign out</a>
</div>

<div class="signup">
    <form id="signup" action="<c:url value='/addpost?userid=${user.id}'/>" method="post">
        <div class="header">
            <h3>Create new post</h3>
        </div>
        <div class="sep"></div>
        <div class="inputs">
            <input type="name" id="name" name="name" maxlength="200" required placeholder="Post Title" />
            <textarea rows="10" type="description" id="description" name="description" required></textarea>
            <button id="submit" type="submit">CREATE</button>
        </div>
    </form>
</div>

</body>
</html>