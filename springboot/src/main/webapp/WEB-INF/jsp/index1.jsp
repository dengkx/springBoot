<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #content {
            width: 600px;
            height: 200px;
        }

        #tab_bar {
            width: 800px;
            height: 20px;
            float: left;
        }

        #tab_bar ul {
            padding: 0px;
            margin: 0px;
            height: 20px;
            text-align: center;
        }

        #tab_bar li {
            list-style-type: none;
            float: left;
            width: 133.3px;
            height: 20px;
            background-color: gray;
        }

        .tab_css {
            width: 600px;
            height: 400px;
            background-color: orange;
            display: none;
            float: left;
        }

    </style>
    <script type="text/javascript">
        var myclick = function (v) {
            var llis = document.getElementsByTagName("li");
            for (var i = 0; i < llis.length; i++) {
                var lli = llis[i];
                if (lli == document.getElementById("tab" + v)) {
                    lli.style.backgroundColor = "orange";
                } else {
                    lli.style.backgroundColor = "gray";
                }
            }

            var divs = document.getElementsByClassName("tab_css");
            for (var i = 0; i < divs.length; i++) {

                var divv = divs[i];

                if (divv == document.getElementById("tab" + v + "_content")) {
                    divv.style.display = "block";
                } else {
                    divv.style.display = "none";
                }
            }

        }
    </script>
</head>
<body>
<h1>${law.title}</h1>
<div id="content">
    <div id="tab_bar">
        <ul>
            <li id="tab1" onclick="myclick(1)" style="background-color: orange">
                全文搜索
            </li>
            <li id="tab2" onclick="myclick(2)">
                精准搜索
            </li>
            <li id="tab3" onclick="myclick(3)">
                信息录入
            </li>
        </ul>
    </div>
    <div class="tab_css" id="tab1_content" style="display: block">
        <form action="/test/tt" method="post">
            <input type="text" class="search" name="context" placeholder="搜索">
            <input type="submit" value="搜索">
        </form>
    </div>
    <div class="tab_css" id="tab2_content">
        <div>
            <table>
                <form action="/test/search" method="post">
                    <tr>
                        <td>机构:</td>
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
        </div>
    </div>
    <div class="tab_css" id="tab3_content">
        <div>
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
                        <td><input type="text" name="fulltext"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="保存"></td>
                    </tr>
                </form>
            </table>
        </div>
    </div>
</div>
</body>
</html>
