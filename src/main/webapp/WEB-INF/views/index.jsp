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
    <table>
        <thead>
        <tr>
            <th style="width: 560px">Post</th>
            <th style="width: 120px">Author</th>
            <th style="width: 100px">Messages</th>
            <th style="width: 120px">Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${posts}" var="post">
            <tr>
                <td><a href="<c:url value='/post?id=${post.id}'/>"><c:out value="${post.name}"/></a></td>
                <td></td>
                <td><c:out value="${post.replies.size()}"/></td>
                <td><c:out value="${post.created}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>