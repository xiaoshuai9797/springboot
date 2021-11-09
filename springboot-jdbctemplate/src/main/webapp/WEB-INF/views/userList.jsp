<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<div>
    hello you!你好！！
</div>

<div>
    <table>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>

        </tr>
        <c:forEach items="${users }" var="user">
        <tr>
            <td>${user.id }</td>
            <td>${user.name }</td>
            <td>${user.age }</td>
        </tr>
    </c:forEach>

    </table>
</div>

</body>
</html>
