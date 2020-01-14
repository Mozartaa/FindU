<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/1/14
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="http://localhost:8080/file " method="post" enctype="multipart/form-data">
    文件上传：<input type="file" name="file">
    <input type="submit" value="上传">
</form>


</body>
</html>
