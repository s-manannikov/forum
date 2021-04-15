<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    <a href="<c:url value='/logout'/>">Sign out</a>
</div>

<div class="container">
    <h2>Forum</h2>
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-1">Post</div>
            <div class="col col-2">Author</div>
            <div class="col col-3">Messages</div>
            <div class="col col-4">Date</div>
        </li>
        <c:forEach items="${posts}" var="post">
        <li class="table-row">
            <div class="col col-1" data-label="Post">
                <a href="<c:url value='/post?id=${post.id}'/>"><c:out value="${post.name}"/></a>
            </div>
            <div class="col col-2" data-label="Author">
                <c:out value="${post.user.username}"/>
            </div>
            <div class="col col-3" data-label="Messages">
                <c:out value="${post.replies.size()}"/>
            </div>
            <div class="col col-4" data-label="Date">
                <c:set var="date" value="${post.created}"/><fmt:formatDate type="both" value="${date}"/>
            </div>
        </li>
        </c:forEach>
    </ul>
</div>

</body>
</html>