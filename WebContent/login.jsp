<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
    <%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!DOCTYPE html>
<head>
<title>演讲口才大师</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="assets/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="assets/js/login.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
<link href="assets/css/login2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
   function ckName(){
	   var name = document.getElementById("user");
	   var xhr = getXMLHttpRequest();
		//处理结果
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){//请求一切正常
				if(xhr.status==200){//服务器响应一切正常
					//alert(xhr.responseText);//得到响应结果
					var msg = document.getElementById("ckmsg");
					if(xhr.responseText=="true"){
						msg.innerHTML =  "<font color='red'>用户名已存在</font>";
						
					}else{
						msg.innerHTML = "ok你可以使用";
					}
				}
			}
   }
		//创建连接
		xhr.open("get","${pageContext.request.contextPath }/AjaxCkName?name="+name.value);
		//发送请求
		xhr.send(null);
   }
 
</script>
</head>
<body>
<div>
<h1>&nbsp;</h1>
           <div class="SystemLogo"  style="margin-top:-190px">
				<a><img src="images/logo.png" alt=""/></a>
			</div>
<div class="login" style="margin-top:50px;">
   
    <div class="header">
        <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">快速登录</a>
			<a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">快速注册</a><div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>    
  
    
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 320px;">
            <!--登录-->
            <div class="web_login" id="web_login">
               <div>
            
			<div class="login_form">
				<form action="${pageContext.request.contextPath}/doLogin"   name="loginform" accept-charset="utf-8" id="login_form" class="loginForm" method="post"><input type="hidden" name="did" value="0"/>
               <input type="hidden" name="to" value="log"/>
                <div class="uinArea" id="uinArea">	
                <label class="input-tips" for="u">帐号：</label>
                <div class="inputOuter" id="uArea">
                    
                    <input type="text" id="u" name="username" class="inputstyle"/>  
                </div>
                </div>
                <div class="pwdArea" id="pwdArea">
               <label class="input-tips" for="p">密码：</label> 
               <div class="inputOuter" id="pArea">
                    
                    <input type="password" id="p" name="password" class="inputstyle"/>
                </div>
                </div>	
				<div id="checkcode" >
					<input type="radio" name="rememberid">是否记住帐号？<br/><br/>
					验证码：<input type="text" name="checkcode" style="height:30px;width: 75px; "  size="25"/><img src="/YingTeEr/CheckCode" id="checkimage" onclick="changecode()"/><a href="javascript:changecode()"/>看不清
					</div>
               <div style="padding-left:50px;margin-top:15px;"><input type="submit"  value="登 录"   style="width:150px" class="button_blue"/></div>	
             <%
             String msg=(String)request.getAttribute("msg");
             String message =(String)request.getAttribute("message");
             String checkcode=(String)request.getAttribute("checkcode1");
             String checkformcode =(String)request.getAttribute("checkcode2");
          if(msg!=null){  	
             out.print(msg);
          }else{
          	if(message!=null){
          		out.print(message);
          	}
          } %>
              </form>
           </div>
           
            	</div>
               
            </div>
            <!--登录end-->
  </div>

  <!--注册-->
    <div class="qlogin" id="qlogin" style="display: none; ">
   
    <div class="web_login">
        <form name="form2" id="regUser" accept-charset="utf-8"  action="${pageContext.request.contextPath}/RegistServlet" method="post">
	      <input type="hidden" name="to" value="reg"/>
            <input type="hidden" name="did" value="0"/>
            <ul class="reg_form" id="reg-ul">
        		<div id="userCue" class="cue">快速注册请注意格式</div>
                <li>
                    <label for="user"  class="input-tips2">用户名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="user" name="username" maxlength="16" class="inputstyle2" onBlur="ckName()"/><span id="ckmsg"></span>
                    </div>
                </li>
                <li>
                <label for="passwd" class="input-tips2">密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="password"  name="password" maxlength="16" class="inputstyle2"/>
                    </div>
                </li>
                <li>
                <label for="passwd2" class="input-tips2">确认密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd2" name="password2" maxlength="16" class="inputstyle2" />
                    </div>
                </li>
				<li>
                    <label for="user"  class="input-tips2">姓名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="name" name="name" maxlength="16" class="inputstyle2"/>
                    </div>
                </li>
				<li>
                    <label for="user"  class="input-tips2">电话号码：</label>
                    <div class="inputOuter2">
                        <input type="text" id="phone" name="tele" maxlength="16" class="inputstyle2"/>
                    </div>
                </li>
                <li>
                 <label for="mailbox" class="input-tips2">邮箱：</label>
                    <div class="inputOuter2">
                        <input type="text" id="mailbox" name="email" maxlength="15" class="inputstyle2"/>
                    </div>
                </li>
               
                <li>
                    <div class="inputArea">
                        <input type="submit" id="reg"  style="margin-top:10px; width:40%; margin-left:30%;" class="button_blue" value="注册"/>
                    </div>
                </li>
                <div class="cl"><% 
     String message2 =(String)request.getAttribute("message2");
    	if(message2!=null){
    		out.print(message2);
    	}
   %> </div>
            </ul>
        </form>
           
    
    </div>
    </div>
    <!--注册end-->
</div>
</div>
</body></html>
</html>