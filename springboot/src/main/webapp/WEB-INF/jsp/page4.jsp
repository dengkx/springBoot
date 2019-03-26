<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
    <h1>查询详情</h1>
</head>
<body>
<div>徐州市警务和城管辅助人员管理办法</div>
<table>
    <tbody>
    <tr align="left">
        <td align="right" width="80">公布机关：</td>
        <td width="400">${name.title}</td>
    </tr>
    <tr align="left">
        <td align="right" width="80">公布日期：</td>
        <td width="200">${name.reDate}</td>
        <td align="right" width="80">施行日期：</td>
        <td width="200">${name.acDate}</td>
    </tr>
    </tbody>
</table>
<div>
    <%--${name.fulltext}--%>
</div>
</body>
</html>
