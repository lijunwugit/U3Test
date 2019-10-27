//加载显示区域
$(function(){  //加载事件
    //显示数据
    $('#dg').datagrid({
        title:"区域信息",
        url:'/admin/getDistrictByPage.do',
        pagination:true,
        pageSize:5,
        pageList:[5,10,15,20],
        toolbar:"#tb",  //绑定工具栏
        columns:[[
            {field:'opt',checkbox:"true",width:100},
            {field:'id',title:'编号',width:100},
            {field:'name',title:'区域名称',width:100},
            {field:'dd',title:'操作',width:100,
                formatter: function(value,row,index){
                    return "<a href='javascript:delDistrict("+row.id+");'>删除| <a href='javascript:selectStreet("+row.id+");'>街道详情</a></a>";
                }
            }
        ]]
    });

});


//点击添加按钮调用的函数
function add(){
    //alert("打开添加窗口");
    $("#AddDialog").dialog("setTitle","添加区域");
    $("#AddDialog").dialog("open"); //打开  close 关闭
}
function ModifyBySelect(){
    //获取选中的行
    var SelectRows = $("#dg").datagrid('getSelections');
    if( 0 == SelectRows.length ){
        $.messager.alert("系统提示", "请选择一行要编辑的数据");
        return;
    }
    if(SelectRows.length>1 ){
        $.messager.alert("系统提示", "一次只能选择一行要编辑的数据");
        return;
    }
    var SelectRow = SelectRows[0];
    //打开编辑对话框
    $("#updateDialog").dialog('open').dialog('setTitle',"修改数据");
    //获得行对象的数据加载到表单中显示
    $("#updateForm").form('load',SelectRow);
}
//关闭添加窗口
function CloseDialog(id){
    $("#"+id).dialog("close"); //打开  close 关闭
}
function SaveDialog() {
    //1.使用jquery的post方法发送异步请求实现添加
    /*  $.post("addDistrit",{"name":$("#name").val()},function(data){
          if(data.result==1){
              $("#dg").datagrid('reload'); //刷新
              $("#AddDialog").dialog("close");//关闭窗口
          }else{
              alert("添加失败!!!");
          }
      },"json");*/

    //2.使用easyui的表单提示插件
    $('#addForm').form('submit',{   //提交按钮
        url:"/admin/addDistrit.do",
        success:function(data){ //获得是json字符串
            //将json字符串转化为json对象
            data=$.parseJSON(data);
            if(data.result==1){
                $("#dg").datagrid('reload'); //刷新
                $("#AddDialog").dialog("close");//关闭窗口
            }else{
                alert("添加失败!!!");
            }
        }
    });
}
function updateDistrict() {
    //使用easuy提交表单
    $('#updateForm').form('submit',{   //提交按钮
        url:"/admin/upDistrit.do",
        success:function(data){ //获得是json字符串
            //将json字符串转化为json对象
            data=$.parseJSON(data);
            if(data.result==1){
                $("#dg").datagrid('reload'); //刷新
                $("#updateDialog").dialog("close");//关闭窗口
            }else{
                $.messager.alert('提示信息','修改失败!','error');
            }
        }
    });
}
function delDistrict(id) {
    //确认提示框
    $.messager.confirm('删除区域', '真的想删除吗?', function(r){
        if (r){
            $.post("/admin/delDistrit.do",{"id":id},function(data){
                if(data.result==1){
                    $("#dg").datagrid('reload'); //刷新
                }else{
                    $.messager.alert('提示信息','删除失败!','error');
                }
            },"json");
        }
    });
}
function DeleteByFruitName() {
    var SelectRows = $("#dg").datagrid('getSelections');
    if( 0 == SelectRows.length ){
        $.messager.alert("系统提示", "请选择要删除的数据");
        return;
    }
    var SelectIndexArr = [];
    for( var i = 0 ; i < SelectRows.length; i++ ){
        SelectIndexArr.push(SelectRows[i].id);
    }
    var SelectIndexToString = SelectIndexArr.toString();
    $.messager.confirm("系统提示", "你确定要删除<font color=red> " + SelectRows.length + " </font>条数据吗?", function(xo){
        if( xo ){
            $("#dg").datagrid('reload');
            $.post("/admin/delMore.do",{ids:SelectIndexToString},function(data){
                if( data.result>0 ){
                    $.messager.alert("系统提示", "你已成功删除 <font color=green> " + data.result + " </font>条数据!~");
                    $("#dg").datagrid('reload');
                }
                else{
                    $.messager.alert("系统提示", "<font color=red>删除失败</font>");
                }
            },"json");
        }
    });
}
function selectStreet(id) {
    $('#dg2').datagrid({
        url:'/admin/getStreetByPage.do',
        pagination:true,
        pageSize:5,
        queryParams: {
            districtId:id
        },
        pageList:[5,10,15,20],
        columns:[[
            {field:'id',title:'街道编号',width:150},
            {field:'name',title:'街道名称',width:150},
        ]]
    });
    $("#streetDialog").dialog("setTitle","街道详情");
    $("#streetDialog").dialog("open");
}