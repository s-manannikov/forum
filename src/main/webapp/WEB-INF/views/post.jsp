<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <tr>
            <td style="width: 150px; padding-left: 20px">
                Username
            </td>

            <td>
                <table>
                    <tr>
                        <td style="text-align: left">
                            <c:out value="${post.name}"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: left; padding-top: 15px">
                            <c:set var="newline" value="<%= '\n' %>" />
                            ${fn:replace(post.desc, newline, "<br />")}
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <div style="text-align: right">posted on <c:out value="${post.created}"/></div>
</div>

<c:forEach items="${post.replies}" var="reply">
    <div class="wrapper">
        <c:out value="${reply.desc}"/><br>
    </div>
</c:forEach>

<div class="wrapper">
    <form action="<c:url value='/reply?id=${post.id}'/>" method="post">
        <textarea id="reply" name="reply" rows="10" cols="100"></textarea>
        <button type="submit">reply</button>
    </form>
</div>

</body>
</html>