<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
<head>
    <title>Spring Boot Sample</title>
    <style>
        table, td, th {
            border: 1px solid #80791e;
        }

        th {
            background-color: #807519;
            color: white;
        }
    </style>
</head>

<body>
<h1>全文搜索结果:</h1>
<table>
    <tr>
        <th>标题</th>
        <th>发布文号</th>
        <th>发布机构</th>
        <th>级别</th>
        <th>区域</th>
        <th>行业</th>
    </tr>
    <c:forEach items="${name}" var="e">
        <tr>
            <td><a href="/test/get?id=${e.id}&index=${e.index}"/>${e.title}
            </td>

            <td>${e.reNumber}</td>

            <td>${e.reAuthority}</td>

            <td>${e.level}</td>

            <td>${e.area}</td>

            <td>${e.trade}</td>

        </tr>

    </c:forEach>
</table>
</body>
</html>