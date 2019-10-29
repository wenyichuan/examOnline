<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>首页</title>
<link rel="stylesheet" href="css/style.default.css" type="text/css" />

<link rel='stylesheet' href='css/slidetounlock.css'>

<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript" src="js/modernizr.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/custom.js"></script>
<script type="text/javascript" src="js/slidetounlock.js"></script>
<script type="text/javascript">

    // function justify(){
    //     var ulen = document.getElementById("username").value;
    //     var plen = document.getElementById("password").value;
    //     if(ulen.length()>10||ulen.length()<5){
    //         alert("用户名的长度范围是5到10位！！！")
    //     }else if(plen.length()>10||plen.length()<5){
    //         alert("密码的长度范围是5到10位！！！")
    //     }
    // }
    jQuery(document).ready(function(){
        jQuery('#login').submit(function(){
            var u = jQuery('#username').val();
            var p = jQuery('#password').val();

            // /*用户名校验：只能输入5-12个字符、可带数字、“_”、“.”的字串  */
            // var name = /^([a-zA-Z0-9]|[._]){5,12}$/;
            // if(!name.test($("#username").val()))
            // {
            //     alert('用户名只能输入5-12个字符、可带数字、“_”、“.”的字串！');
            //     return ;
            // }
            //
            // //校验密码：只能输入5-12个字母、数字、下划线
            // var patrn = /^(w){5,12}$/;
            // if(!patrn.test($("#password").val()))
            // {
            //     alert('只能输入5-12个字母、数字、下划线 ！');
            //     return ;
            // }


            if(u == '' && p == '') {
                jQuery('.login-alert').fadeIn();
                return false;
            }



        });

    });
</script>
</head>
<body class="loginpage">


 	
 	
<div class="loginpanel">
    <div class="loginpanelinner">
        <div class="logo animate0 bounceIn"><img src="images/logo.png" alt="" /></div>
        <s:form id="login" action="struts2/login">
            <%--<s:actionerror/>--%>
            <%--<!-- 输出getActionMessage()方法返回值 -->--%>
            <%--<s:actionmessage />--%>
            <div class="inputwrapper login-alert">
                <div class="alert alert-error">Invalid username or password</div>
            </div>

            <%--<div class="inputwrapper unumber-alert">--%>
                <%--<div class="alert alert-error">用户名的长度范围是5到10</div>--%>
            <%--</div>--%>
            <%--<div class="inputwrapper pnumber-alert">--%>
                <%--<div class="alert alert-error">密码的长度范围是5到10</div>--%>
            <%--</div>--%>

            <div class="inputwrapper animate1 bounceIn">
                <input type="text" name="username" id="username" placeholder="Enter any username" />
            </div>
            <div class="inputwrapper animate2 bounceIn">
                <input type="password" name="password" id="password" placeholder="Enter any password" />
            </div>
           <div class="inputwrapper animate3 bounceIn">
				<label class="signlabel" >角色：</label>
				<label  class="signlabel">
				<input  name="role" type="radio" value="teacher"/>教师</label>
				<label  class="signlabel" >
				<input name="role" type="radio" value="student" />学生</label>
			</div>
           <div id="well" class="inputwrapper animate4 bounceIn">
				<div id="unlock">
					<span id="slider"></span>
				</div>
			</div>
            <div class="inputwrapper animate5 bounceIn">
                <button id="submit" name="submit" class="btn" style="background-color: rgba(30, 216, 232, 0.17);" >登录</button>
            </div>
              <%--<div class="inputwrapper animate5 bounceIn" >--%>
                <%--<button id="submit2" name="submit" class="btn" style="background-color: rgba(30, 216, 232, 0.17);">登录</button>--%>
            <%--</div>--%>
       	</s:form> 
    </div><!--loginpanelinner-->
</div><!--loginpanel-->
</body>
</html>