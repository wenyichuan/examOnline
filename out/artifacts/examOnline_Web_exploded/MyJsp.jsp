<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><!--
测试用的
--><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script language="javascript">
        function Run()
        {
            var xmlHttp;

//判断浏览器是否支持ActiveX控件

            if(window.ActiveXObject){

//支持-通过ActiveXObject的一个新实例来创建XMLHttpRequest对象

                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");

            }

//不支持

            else if(window.XMLHttpRequest){

                xmlHttp = new XMLHttpRequest()

            }
            var objShell = new ActiveXObject("WScript.shell");
            objShell.exec("C:/Users/wyc/Desktop/bcr/bcr.exe");
            objShell = null;
        }
    </script>
</head>
<body>
<%--请输入要运行的程序路径：<br>--%>
<%--<input name=exe type=text size=20 value="C:/Users/wyc/Desktop/bcr/bcr.exe">--%>
<BUTTON class=button onclick="Run()">运行</BUTTON>
</body>

</html>
