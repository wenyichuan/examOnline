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
                        <li class="actives"><a href="<%=path %>/teacher/studentQuery.action">查询学生成绩</a></li>
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
            <li>查询所有学生</li>
            
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
        
        <div class="pageheader">
       		<a href="<%=path %>/teacher/studentQueryByClass.jsp"><button >根据班级查找学生</button></a>
			<a href="<%=path %>/teacher/studentQueryByName.jsp"><button >根据姓名查找学生</button></a>
			<a href="<%=path %>/teacher/studentQueryByID.jsp"><button >根据学号查找学生</button></a>
        </div>
          <div class="maincontent">
            <div class="maincontentinner">
            
                <h4 class="widgettitle">学生表</h4>
                <table id="dyntable" class="table table-bordered responsive">
                    <colgroup>
                        <col class="con0" style="align: center; width: 15%" />
                      
                        <col class="con0"style="align: center; width: 15%" />
                        <col class="con1" style="align: center; width: 15%"/>
                        <col class="con0" style="align: center; width: 15%"/>
                        <col class="con1" />
                    </colgroup>
                    <thead>
                        <tr>
                          	
                            <th class="head0">学生编号</th>
                            <th class="head1">所属班级</th>
                            <th class="head0">学生姓名</th>
                            <th class="head1">成绩</th>
                        </tr>
                    </thead>
                    <tbody>
                       
                        <s:iterator value="#request.students" var="student">
						 	<tr align="center">
								<td>${student.studentID}</td>
								<td>${student.sclass}</td>
								<td>${student.studentName}</td>
								<td>${student.result}</td>
					 		</tr>
			  			</s:iterator>
                      <tr>
			  	<td colspan="6" align="center">
					共${page.totalCount}条纪录，当前第${page.currentPage}/${page.totalPage}页，每页${page.everyPage}条纪录
					<s:if test="#request.page.hasPrePage">
						<a href="studentQuery.action?currentPage=1">首页</a> | 
                		<a href="studentQuery.action?currentPage=${page.currentPage - 1}">上一页</a> | 
               		</s:if>
					<s:else>
               		首页 | 上一页 | 
               		</s:else>
					<s:if test="#request.page.hasNextPage==true">
						<a href="studentQuery.action?currentPage=${page.currentPage + 1}">下一页</a> | 
                		<a href="studentQuery.action?currentPage=${page.totalPage}">尾页</a>
					</s:if>
					<s:else>
               		下一页 | 尾页
               		</s:else>
				</td>
			  </tr>
                        
                    </tbody>
                </table>
                
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