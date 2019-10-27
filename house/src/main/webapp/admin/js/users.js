//加载显示区域
$(function(){  //加载事件
    //显示数据
    $('#dg').datagrid({
        title:"用户信息",
        url:'/admin/getUsersByPage.do',
        pagination:true,
        pageSize:5,
        pageList:[5,10,15,20],
        toolbar:"#tb",  //绑定工具栏
        columns:[[
            {field:'opt',checkbox:"true",width:100},
            {field:'id',title:'编号',width:100},
            {field:'name',title:'用户名',width:100},
            {field:'telephone',title:'电话',width:100},
            {field:'age',title:'年龄',width:100},
            {field:'dd',title:'操作',width:100,
                formatter: function(value,row,index){
                    return "<a href='javascript:delType("+row.id+");'>删除</a>| <a href=''>修改</a>";
                }
            }
        ]]
 });
});

    function search(){
        var name=$("#name").val();
        var telephone=$("#telephone").val();
        $("#dg").datagrid("load",{"name":name,"telephone":telephone});
    }


