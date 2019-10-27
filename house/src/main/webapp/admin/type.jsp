
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
    <script src="${pageContext.request.contextPath}/admin/js/type.js"></script>
</head>
<body>
<table id="dg"></table>
<!--工具栏-->
<div id="tb">
    <a href="javascript:add()" class="easyui-linkbutton"
       iconCls="icon-add" plain="true">添加</a>
    <a href="javascript:ModifyBySelect()" class="easyui-linkbutton"
       iconCls="icon-edit" plain="true">修改</a>
    <a href="javascript:DeleteByFruitName()" class="easyui-linkbutton"
       iconCls="icon-remove" plain="true">删除</a>
</div>
<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form action="" name="add" method="post" id="addForm">
        类型名称:<input type="text" name="name"><br/>
    </form>
</div>
<div id="updateDialog" class="easyui-dialog" buttons="#updateDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form action="" name="update" method="post" id="updateForm">
        <input type="hidden" name="id"><br/>
        类型名称:<input type="text" name="name"><br/>
    </form>
</div>
<!--对话框的按钮-->
<div id="AddDialogButtons">
    <a href="javascript:SaveDialog()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog('AddDialog')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
<!--对话框的按钮-->
<div id="updateDialogButtons">
    <a href="javascript:updateType()" class="easyui-linkbutton" iconCls="icon-ok">更新</a>
    <a href="javascript:CloseDialog('updateDialog')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
</body>
</html>
