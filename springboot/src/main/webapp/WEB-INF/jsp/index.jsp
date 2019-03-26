<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>


</head>
<h1> 全文搜索${name}</h1>

<div>
    <form action="/test/tt" method="post">
        <input type="text" class="search" name="context" placeholder="搜索">
        <input type="submit" value="搜索">
    </form>
</div>
<h1>精准搜索</h1>
<table>
    <form action="/test/search" method="post">
        <tr>
            <td>机构:</td>
            <td><input type="text" name="reAuthority" placeholder="text"></td>
            <td></td>
        </tr>
        <tr>
            <td>级别:</td>
            <td><input type="text" name="level" placeholder="text"></td>
            <td></td>
            <td>区域:</td>
            <td><input type="text" name="area" placeholder="text"></td>
            <td></td>
        </tr>
        <tr>
            <td>行业:</td>
            <td><input type="text" name="trade" placeholder="text"></td>
            <td>类别:</td>
            <td><input type="text" name="index" value="test" placeholder="text"></td>
        </tr>
        <tr>
            <td>发布日期:</td>
            <td><input type="date" name="reFromTime" placeholder="text"></td>
            <td>-</td>
            <td><input type="date" name="reToTime" placeholder="text"></td>

        </tr>
        <tr>
            <td>生效日期:</td>
            <td><input type="date" name="acFromTime" placeholder="time"></td>
            <td>-</td>
            <td><input type="date" name="acToTime" placeholder="time"></td>

        </tr>
        <tr>
            <td>失效日期:</td>
            <td><input type="date" name="faFromTime" placeholder="time"></td>
            <td>-</td>
            <td><input type="date" name="faToTime" placeholder="time"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="搜索">
            </td>
        </tr>
    </form>
</table>
<h1>录入信息</h1>
<table>
    <form action="/test/save" method="post">
        <tr>
            <td>标题:</td>
            <td><input type="text" name="title" placeholder="text"></td>
            <td>发布机构:</td>
            <td><input type="text" name="reAuthority" placeholder="text"></td>
        </tr>
        <tr>
            <td>级别:</td>
            <td><input type="text" name="level" placeholder="text"></td>
            <td>区域:</td>
            <td><input type="text" name="area" placeholder="text"></td>
        </tr>

        <tr>
            <td>行业:</td>
            <td><input type="text" name="trade" placeholder="text"></td>
            <td>发布文号:</td>
            <td><input type="text" name="reNumber" placeholder="text"></td>
        </tr>

        <tr>
            <td>关键词:</td>
            <td><input type="text" name="antistop" placeholder="text"></td>
            <td>描述:</td>
            <td><input type="text" name="describe" placeholder="text"></td>
        </tr>

        <tr>
            <td>发布日期:</td>
            <td><input type="date" name="reDate" placeholder="text"></td>
            <td>生效日期:</td>
            <td><input type="date" name="acDate" placeholder="text"></td>
        </tr>

        <tr>
            <td>失效日期:</td>
            <td><input type="date" name="failDate" placeholder="text"></td>
            <td>全文:</td>
            <td><input type="text" name="fulltext" ></td>
        </tr>
        <tr>
            <td><input type="submit" value="保存"></td>
        </tr>
    </form>
</table>
</body>
</html>