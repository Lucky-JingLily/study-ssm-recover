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
    <title>selectAll.jsp</title>
  </head>
  <body>
  <table border="1px">
    <tr>
      <td>ID</td>
      <td>NAME</td>
      <td>AGE</td>
    </tr>
    <c:forEach items="${allUsers}" var="u">
      <tr>
        <td><c:out value="${u.id}"/></td>
        <td><c:out value="${u.name}"/></td>
        <td><c:out value="${u.age}"/></td>
        <td><a href='<c:url value="/deleteOne?uid=${u.id}" />'>delete</a></td>
        <td><a href='<c:url value="/editOne?uid=${u.id}" />'>edit</a></td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
