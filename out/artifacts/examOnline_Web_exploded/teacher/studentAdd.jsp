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

<link rel="stylesheet" href="../css/style.default.css" type="text/css" />
<link rel="stylesheet" href="../css/responsive-tables.css">
<link rel="stylesheet" href="../css/bootstrap-fileupload.min.css" type="text/css" />
<link rel="stylesheet" href="../css/bootstrap-timepicker.min.css" type="text/css" />

<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/jquery.uniform.min.js"></script>
<script type="text/javascript" src="../js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../js/jquery.cookie.js"></script>
<script type="text/javascript" src="../js/modernizr.min.js"></script>
<script type="text/javascript" src="../js/responsive-tables.js"></script>
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
     //ajax
     function showStatus(str){
     	//如果form表单中的字符串为空的话，就把显示的返回值清空，并且返回函数，不再往下执行
            if (str.length == 0) {
                document.getElementById("txt").innerHTML = "";
                return;
            }
            if (window.XMLHttpRequest) {
			//chrome Firefox opera Safari……
                var xmlhttp = new XMLHttpRequest();
            } else {
			//兼容老版本
                var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function () {
			//如果可以连接的通
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			// 并且返回值是HTTP200
                    document.getElementById("txt").innerHTML = xmlhttp.responseText;
			// 获取ajax 从后台回传的数据
                }
            }
		//打开ajax
            xmlhttp.open("GET", "checkStudentID.action?studentID=" + str, true);
		//发送请求
            xmlhttp.send();
     }
</script>
<title>老师登陆成功</title>
</head>
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
                    	<li class="actives"><a  href="<%=path %>/teacher/studentAdd.jsp">添加学生</a></li>
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
			 <li>学生管理 <span class="separator"></span></li>
            <li>添加学生</li>
            
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
            <h4 class="widgettitle">添加学生</h4>
            <div class="widgetcontent">
                <form class="stdform" action="studentAdd.action" method="post">               
                      
                            <label>学生编号：</label>
                            <span class="field">
                      			<input type="text" name="studentID" class="input-xlarge" placeholder="请输入..." required="required" onkeyup="showStatus(this.value)"/>
                            	<span id="txt" ></span><!-- 验证 -->
                            </span>
                       
                            <label>学生姓名：</label>
                            <span class="field"><input type="text" name="studentName" class="input-xlarge" placeholder="请输入..." required="required" /></span>
                        
                            <label>所属班级:</label>
                            <span class="field">
                          	  <select name="sclass" class="form-control">
                          	  	<option value="[A]软件开发与测试方向（A01）" selected="selected">[A]软件开发与测试方向（A01）</option>
		                          	<option value="[A]软件开发与测试方向（A02）">[A]软件开发与测试方向（A02）</option>
		                          	<option value="[A]软件开发与测试方向（A03）">[A]软件开发与测试方向（A03）</option>
                                    <option value="[A]软件开发与测试方向（A04）">[A]软件开发与测试方向（A04）</option>
                                    <option value="[B]企业信息化软件开发与应用方向（B01）">[B]企业信息化软件开发与应用方向（B01）</option>
                                    <option value="[T]电子商务与现代物流软件开发与应用方向（T01）">[T]电子商务与现代物流软件开发与应用方向（T01）</option>
                                    <option value="[X]移动互联网软件开发与应用方向（X01）">[X]移动互联网软件开发与应用方向（X01）</option>
                                    <option value="[X]移动互联网软件开发与应用方向（X02）">[X]移动互联网软件开发与应用方向（X02）</option>
                                    <option value="[Y]云计算与大数据分析方向(Y01)">[Y]云计算与大数据分析方向(Y01)</option>
                                    <option value="[Y]云计算与大数据分析方向(Y02)">[Y]云计算与大数据分析方向(Y02)</option>
                                    <option value="[Y]云计算与大数据分析方向(Y03)">[Y]云计算与大数据分析方向(Y03)</option>
                                    <option value="[Y]云计算与大数据分析方向(Y04)">[Y]云计算与大数据分析方向(Y04)</option>
                                    <option value="[Y]云计算与大数据分析方向(Y05)">[Y]云计算与大数据分析方向(Y05)</option>
                                    <option value="[Y]云计算与大数据分析方向(Y06)">[Y]云计算与大数据分析方向(Y06)</option>
                                    <option value="[Y]云计算与大数据分析方向(Y07)">[Y]云计算与大数据分析方向(Y07)</option>
                                    <option value="[Z]智慧城市建设应用软件开发与测试方向(Z01)">[Z]智慧城市建设应用软件开发与测试方向(Z01)</option>
	                           	</select>
                            </span>
                       
                        <p class="stdformbutton">
							<input class="btn btn-primary" type="submit" value="录入">
							<input class="btn btn-primary" type="reset" value="重置">
                        </p>
                    
                </form>

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