<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layout.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/layout.js" charset="gb2312"></script>
<title>中国矿业大学楼宇管理系统</title>
</head>
<body class="easyui-layout">
    <div id="divHeader" data-options="region:'north',border:false,href:'header'">
    </div>
    <div id="divMenuBar" data-options="region:'west',split:true,collapsed:false,title:'菜单栏',href:'menu'">
    </div>
    <div id="divFooter" data-options="region:'south',border:false,href:'footer'">
    </div>
    <div id="divContent" data-options="region:'center',title:false">
        <div id="tabs" class="easyui-tabs" data-options="fit:true,border:false">
            <div id="divTitleBar" title="主页">
             	中国矿业大学楼宇管理系统
            </div>
        </div>
    </div>
</body>
</html>