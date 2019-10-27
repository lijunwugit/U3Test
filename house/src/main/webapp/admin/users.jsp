
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/easyUI/css/demo.css">
    <script src="${pageContext.request.contextPath}/admin/js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="${pageContext.request.contextPath}/admin/js/jquery.easyui.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/js/users.js"></script>
</head>
<body>
<table id="dg"></table>
<!--工具栏-->
<div id="tb">
     用户名: <input type="text" id="name" name="name">
     电话: <input type="text" id="telephone" name="telephone">
    <a href="javascript:search()" class="easyui-linkbutton"
       iconCls="icon-search" plain="true">搜索</a>
</div>
</body>
</html>
