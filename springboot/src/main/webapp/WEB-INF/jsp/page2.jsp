<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
<head>
    <title>Spring Boot Sample</title>
</head>

<body>
<h1>搜索结果:</h1>
<table>
    <c:forEach items="${name}" var="e">
        <tr>
            <td>标题：</td>
            <td>${e.title}</td>

            <td>发布文号:</td>
            <td>${e.reNumber}</td>

            <td>发布机构:</td>
            <td>${e.reAuthority}</td>

            <td>级别:</td>
            <td>${e.level}</td>

            <td>区域:</td>
            <td>${e.area}</td>

            <td>行业:</td>
            <td>${e.trade}</td>
        </tr>

    </c:forEach>
</table>
</body>
</html>