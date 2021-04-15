<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<div id="comments" class="comments-area">
    <h2 class="comments-title">
        <c:out value="${post.name}"/>
    </h2>
    <ol class="comment-list">
        <li id="comment-1" class="comment even thread-even depth-1 parent">
            <article id="div-comment-1" class="comment-body">
                <footer class="comment-meta">
                    <div class="comment-author vcard">
                        <img alt="" src="${pageContext.request.contextPath}/img/avatardefault.png"
                             class="avatar avatar-32 photo" height="32" width="32">
                        <b class="fn"><a><c:out value="${post.user.username}"/></a></b>
                    </div>
                    <div class="comment-metadata">
                        <a><time>
                                <c:set var="date" value="${post.created}"/><fmt:formatDate type="both" value="${date}"/>
                        </time></a>
                    </div>
                </footer>
                <div class="comment-content">
                    <p>
                        <c:set var="newline" value="<%= '\n' %>" />
                        ${fn:replace(post.description, newline, "<br />")}
                    </p>
                </div>
                <div class="reply"><a href="#signup" class="comment-reply-link">Reply</a></div>
            </article>
            <ol class="children">
                <c:forEach items="${post.replies}" var="reply">
                <li id="comment-2" class="comment odd alt depth-2">
                    <article id="div-comment-2" class="comment-body">
                        <footer class="comment-meta">
                            <div class="comment-author vcard">
                                <img alt="" src="${pageContext.request.contextPath}/img/avatardefault.png"
                                     class="avatar avatar-32 photo" height="32" width="32">
                                <b class="fn"><a><c:out value="${reply.user.username}"/></a></b>
                            </div>
                            <div class="comment-metadata">
                                <a><time>
                                    <c:set var="date" value="${reply.created}"/><fmt:formatDate type="both" value="${date}"/>
                                </time></a>
                            </div>
                        </footer>
                        <div class="comment-content">
                            <p>
                                <c:set var="newline" value="<%= '\n' %>" />
                                    ${fn:replace(reply.description, newline, "<br />")}
                            </p>
                        </div>
                        <div class="reply"><a class="comment-reply-link" href="#signup">Reply</a></div>
                    </article>
                </li>
                </c:forEach>
            </ol>
        </li>
    </ol>
</div>

<div class="signup" style="margin-top: -50px">
    <form id="signup" action="<c:url value='/reply?id=${post.id}&userid=${user.id}'/>" method="post">
        <div class="header">
            <h3>Reply</h3>
        </div>
        <div class="sep"></div>
        <div class="inputs">
            <textarea rows="10" type="description" id="reply" name="reply" required></textarea>
            <button id="submit" type="submit">REPLY</button>
        </div>
    </form>
</div>

</body>
</html>