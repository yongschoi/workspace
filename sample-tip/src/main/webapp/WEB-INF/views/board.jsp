<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>
    </head>
    <body>
        <form:form action="boarding" method="post" modelAttribute="jspMessage">
            <form:label path="message">Message : </form:label>
            <form:input path="message"/>
            <form:button>글올리기</form:button>
        </form:form>
    </body>
</html>
