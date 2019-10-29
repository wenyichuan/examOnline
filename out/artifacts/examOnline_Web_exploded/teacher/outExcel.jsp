<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wyc
  Date: 2019/1/8
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="outexcel2" method="post">
    <s:submit value="导出学生成绩数据"></s:submit>
</s:form>

<s:form action="InExcel" method="post" enctype="multipart/form-data">
    <s:file name="file" ></s:file>
    <s:submit value="导入"></s:submit>
</s:form>
</body>
</html>
