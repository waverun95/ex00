<%--
  Created by IntelliJ IDEA.
  User: joonyoung
  Date: 2023-02-10
  Time: 오전 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="uploadFormAction" method="post" enctype="multipart/form-data">
  <input type="file" name="uploadFile" multiple>
  <button>Submit</button>
</form>
</body>
</html>
