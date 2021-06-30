<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2021/6/30
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生信息表单</title>
</head>
<body>
    进入操作页面
    ${student}
    <%--用表格展示数据--%>
    <table border="1">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>学会</td>
            <td>班级</td>
            <td>地址</td>
            <td>分数</td>
        </tr>
        <%--循环展示每个学生信息--%>
        <%--循环中属性：item表示数据源一般是集合 s表示每个对象--%>
        <c:forEach items="${studentList}" var="s">
            <tr>
                <td>${s.sid}</td>
                <td>${s.sname}</td>
                <td>${s.sno}</td>
                <td>${s.gradeid}</td>
                <td>${s.address}</td>
                <td>${s.score}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
