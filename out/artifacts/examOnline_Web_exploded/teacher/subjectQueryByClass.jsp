<%--
  Created by IntelliJ IDEA.
  User: wyc
  Date: 2019/1/11
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Shamcey - Metro Style Admin Template</title>

    <link rel="stylesheet" href="../css/style.default.css" type="text/css" />
    <link rel="stylesheet" href="../css/bootstrap-fileupload.min.css" type="text/css" />
    <link rel="stylesheet" href="../css/bootstrap-timepicker.min.css" type="text/css" />

    <script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="../js/jquery-migrate-1.1.1.min.js"></script>
    <script type="text/javascript" src="../js/jquery-ui-1.9.2.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap-fileupload.min.js"></script>
    <script type="text/javascript" src="../js/bootstrap-timepicker.min.js"></script>
    <script type="text/javascript" src="../js/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="../js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../js/jquery.tagsinput.min.js"></script>
    <script type="text/javascript" src="../js/jquery.autogrow-textarea.js"></script>
    <script type="text/javascript" src="../js/charCount.js"></script>
    <script type="text/javascript" src="../js/colorpicker.js"></script>
    <script type="text/javascript" src="../js/ui.spinner.min.js"></script>
    <script type="text/javascript" src="../js/chosen.jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.cookie.js"></script>
    <script type="text/javascript" src="../js/modernizr.min.js"></script>
    <script type="text/javascript" src="../js/custom.js"></script>
    <script type="text/javascript" src="../js/forms.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function(){
            // dynamic table
            jQuery('#dyntable').dataTable({
                "sPaginationType": "full_numbers",
                "aaSortingFixed": [[0,'asc']],
                "fnDrawCallback": function(oSettings) {
                    jQuery.uniform.update();
                }
            });

            jQuery('#dyntable2').dataTable( {
                "bScrollInfinite": true,
                "bScrollCollapse": true,
                "sScrollY": "300px"
            });

        });
    </script>
</head>
<title>老师登陆成功</title>
<body>

<div class="mainwrapper">

    <div class="header">
        <div class="logo">
            <a href="<%=path %>/teacher/teacher.jsp"><img src="../images/logo.png" alt="" /></a>
        </div>
        <div class="headerinner">
            <ul class="headmenu">

                <li class="right">
                    <div class="userloggedinfo">
                        <img src="../images/photos/thumb1.png" alt="" />
                        <div class="userinfo">
                            <h5>${sessionScope.teacherInfo.teacherID} <small>you are welcome</small></h5>
                            <ul>
                                <li><a href="<%=path %>/login.jsp">退出登录</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
            </ul><!--headmenu-->
        </div>
    </div>

    <div class="leftpanel" style="margin-left: 0px;">

        <div class="leftmenu">
            <ul class="nav nav-tabs nav-stacked">
                <li class="nav-header">Navigation</li>

                <li class="dropdown active"><a href=""><span class="iconfa-pencil"></span> 学生管理</a>
                    <ul>
                        <li><a href="<%=path %>/teacher/studentAdd.jsp">添加学生</a></li>
                        <li><a href="<%=path %>/teacher/InExcel.jsp">批量管理学生信息</a></li>
                        <li><a href="<%=path %>/teacher/studentQuery.action">查询学生成绩</a></li>
                    </ul>
                </li>
                <li class="dropdown"><a href=""><span class="iconfa-briefcase"></span> 试题管理</a>
                    <ul>
                        <li><a href="<%=path %>/teacher/subjectAdd.jsp">添加选择题</a></li>
                        <li><a href="<%=path %>/teacher/fillAdd.jsp">添加填空题</a></li>
                        <li><a href="">添加程序题</a></li>
                        <li><a href="">添加简答题</a></li>
                        <li><a href="<%=path %>/teacher/querySubject.action">管理选择题</a></li>
                        <li><a href="<%=path %>/teacher/subjectQuery.jsp">搜索选择题</a></li>
                        <li><a href="<%=path %>/teacher/queryFill.action">管理填空题</a></li>
                        <li><a href="<%=path %>/teacher/fillQuery.jsp">搜索填空题</a></li>
                    </ul>
                </li>

            </ul>
        </div><!--leftmenu-->

    </div><!-- leftpanel -->
    <div class="rightpanel">

        <ul class="breadcrumbs">
            <li><a href="<%=path %>/teacher/teacher.jsp"><i class="iconfa-home"></i></a> <span class="separator"></span></li>
            <li><a href="/examOnline/teacher/studentQuery.action">学生管理</a> <span class="separator"></span></li>
            <li>分课程查询试题</li>

            <li class="right">
                <a href="" data-toggle="dropdown" class="dropdown-toggle"><i class="icon-tint"></i> Color Skins</a>
                <ul class="dropdown-menu pull-right skin-color">
                    <li><a href="default">Default</a></li>
                    <li><a href="navyblue">Navy Blue</a></li>
                    <li><a href="palegreen">Pale Green</a></li>
                    <li><a href="red">Red</a></li>
                    <li><a href="green">Green</a></li>
                    <li><a href="brown">Brown</a></li>
                </ul>
            </li>
        </ul>

        <div class="maincontent" style="">
            <div class="maincontentinner">

                <div class="widget">
                    <h4 class="widgettitle">分课程查询试题</h4>
                    <div class="widgetcontent">
                        <form class="stdform" action="querySubjectLike.action" method="post">

                            <label>课程名称:</label>
                            <span class="field">
	                          	<select name="sclass" class="form-control" onchange="A()" id="SS">
		                          	<option value="【JAVA】" selected="selected">【JAVA】</option>
		                          	<option value="【C】">【C】</option>
		                          	<option value="【操作系统】">【操作系统】</option>
                                    <option value="【数据结构】">【数据结构】</option>
                                    <option value="【计算机网络】">【计算机网络】</option>
                                    <option value="【前端】">【前端】</option>
                                    <option value="【算法】">【算法】</option>

	                           	</select>
                            </span>
                            <%--//通过隐藏域传递值--%>
                            <span class="field"><input  type="hidden"  name="subjectTitle" id="box" class="input-xlarge" placeholder="请输入..." /></span>

                            <p class="stdformbutton">
                                <input type="submit" name="Submit" value="查询">
                                <input type="reset" name="Submit2" value="重置">
                            </p>

                        </form>
                        <%--//将select值传给input--%>
                        <script language="javascript">
                            function A(){
                                document.getElementById('box').value=
                                    document.getElementById('SS').options[document.getElementById('SS').selectedIndex].value;
                                // {#document.getElementById('SS').value;#}
                            }
                        </script>

                    </div><!--widgetcontent-->
                </div><!--widget-->

                <br /><br />

                <div class="footer">
                    <div class="footer-left">
                        <span>&copy; WYC. All Rights Reserved.</span>
                    </div>

                </div><!--footer-->

            </div><!--maincontentinner-->
        </div><!--maincontent-->

    </div><!--rightpanel-->

</div><!--mainwrapper-->

</body>
</html>
