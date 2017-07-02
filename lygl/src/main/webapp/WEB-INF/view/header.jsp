<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<title></title>
</head>
<body>
    <div class="header1">
        <div class="header2">
            <div class="logo">
                <strong>中国矿业大学楼宇管理系统</strong>
            </div>
            <div class="contact">
                <div class="prompt">
                    <span id="today"></span>
                </div>
                <div id="headerMenu" class="headerMenu">
                    <ul>
                        <li><a href="#" class="easyui-linkbutton" data-options="plain:true" onclick="exit()">安全退出</a></li>
                        <li><a  class="easyui-linkbutton" data-options="plain:true" >您好，<s:property value="#session.person.personName"/></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
    
		$(document).ready( function(){
			$("#today").text("");
			// 指定向JSONExample发送请求，将id为form1的表单所包含的表单控件转换为请求参数
			$.post("${pageContext.request.contextPath}/chinaDate" , function(data , statusText)
				{
				for(var propName in data)
				{
					$("#today").append(data[propName]);
				}
				},
				// 指定服务器响应为JSON数据
				"json");
		});
		function exit(){
			$.messager.confirm('确认','您确认想要安全退出吗？',function(r){    
			    if (r){
					var url ='${pageContext.request.contextPath}/exitAction_exit.action';
					  $('<form method="post" action="' + url + '"></form>').appendTo('body').submit().remove();
			    	//$.post("${pageContext.request.contextPath}/hazard/exitAction_exit.action");
			    }    
			});
		};
	</script>
</body>
</html>