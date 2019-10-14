<%--
  Created by IntelliJ IDEA.
  User: lipeijing
  Date: 2019/10/13
  Time: 4:51 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>edit.jsp</title>
  </head>
  <body>
  <form action='<c:url value="/updateOne" />' method="post">
    id: <input type="hidden" name="id" value='<c:out value="${user.id}" /> '><br />
    name: <input type="text" name="name" value='<c:out value="${user.name}" /> '><br />
    age: <input type="text" name="age" value='<c:out value="${user.age}" /> '><br />
    <input type="submit">
  </form>
  </body>
</html>
