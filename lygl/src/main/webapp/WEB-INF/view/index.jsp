<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>MIS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
  </head>
  <body>
    <div class="cont">
  <div class="demo">
    <div class="login">
      <div class="login__check"></div>
      <div class="login__form">
        <div class="login__row">
          <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
            <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
          </svg>
          <input id="personId" type="text" class="login__input name" placeholder="Username"/>
        </div>
        <div class="login__row">
          <svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
            <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
          </svg>
          <input id="password" type="text" class="login__input pass" placeholder="Password"/>
        </div>
	    <div style="margin-top:15px"><input type="checkbox" style="margin:15px 5px" name="chkRemember" id="chkRemember" /><font color="white" size="3">记住用户名和密码</font></div>
        <button id="login" type="button" class="login__submit">登录</button>
        <p class="login__signup">忘记密码? &nbsp;<a>找回密码</a></p>
      </div>
    </div>
  </div>
</div>
	<script type="text/javascript">
		//初始化页面时验证是否记住了密码
		$(document).ready(function() {
			if ($.cookie("chkRemember") == "true") {
		        $("#chkRemember").attr("checked", true);
		        $("#password").attr('type','password');
		        $("#personId").val($.cookie("personId"));	        
		        $("#password").val($.cookie("password"));
		    }
		});
		$(function(){
			//回车登录
			$("body").keydown(function() {
			    if (event.keyCode == "13") {//keyCode=13是回车键
			    	$("#login").click();
			    }
			});
			//密码聚焦时改变属性
	 		$("#password").focus(function(event) {
	 			 $(this).attr('type','password');
	 		});
	 		//提交
			$("#login").click(function(){
				if($.trim($("#personId").val()).length == 0){
					$("#personId").focus();
				}else if($.trim($("#password").val()).length == 0){
					$("#password").focus();
				}else{
					if($("#chkRemember").prop("checked") == true){
						$.cookie("personId", $("#personId").val(), { expires: 7 });
				        $.cookie("password", $("#password").val(), { expires: 7 });
				        $.cookie("chkRemember", $("#chkRemember").prop("checked"), { expires: 7 });
					}
					$.post("${pageContext.request.contextPath}/person/person_login",{personId:$('#personId').val(),password:$('#password').val(),rememberPwd:$("#chkRemember").prop("checked")},function(result){
						if(result == "success"){
							location.href ="main";
						}else if(result == "login"){
							$("#personId").val("");
							$("#password").val("");
							$("#personId").focus();	
							alert("用户名不存在，请重新输入!")
						}else{
							$("#password").val("");
							$("#password").focus();	
							alert("密码错误，请重新输入!")
						}
					},'json');
				}
			});
		});
	</script>
  </body>
</html>
