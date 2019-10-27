<%--
  Created by IntelliJ IDEA.
  User: LJW
  Date: 2019/10/24
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
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
    <script language="JavaScript" src="${pageContext.request.contextPath}/admin/js/houseTwo.js"></script>
</head>
<body>
<table id="dg"></table>

<!--工具栏-->
<div id="tb">
    区域:<select></select>
    街道:<select></select>
    类型:<select></select>
    价格:<input id="sname1" type="text" name="name"/>-<input id="sname2" type="text" name="name"/>
    <a
            href="javascript:search()" class="easyui-linkbutton"
            iconCls="icon-search" plain="true">搜索</a>
</div>
</body>
</html>
