$(function () {
    loadData();
    $("#updateForm").validate({ // 定义验证规则
        debug: true,  // 采用调试模式，表单不会自动提交
        submitHandler: function (form) {    // 当前表单对象
            // form.submit(); // 手工提交，如果不需要手工提交，可以在此处进行异步处理
           var byid = $("#bbyid").text();
            var byname = $("#byname").val();
            
            $.post("pages/back/biye/biye_update.action",{"byid":byid,"byname":byname},function(obj){
                if(obj.trim() == "true"){
                    $("#alertDiv7").attr("class","alert alert-success");
                    $("#alertText7").text("毕业要求信息修改成功!");
                    $("#byid-"+byid).text(byid);
                    $("#byname-"+byid).text(byname);
                }else{
                    $("#alertDiv7").attr("class","alert alert-danger");
                    $("#alertText7").text("毕业要求信息修改失败!");
                }
                $("#biyeInfo").modal("hide");
                $("#alertDiv7").fadeIn(2000,function () {
                    $("#alertDiv7").fadeOut(2000);
                });
            },"text");
        },
        rules: {   // 为每一个表单编写验证规则

            "byid": {
                required: true,  // 此字段不允许为空
            },
            "byname": {
                required: true,  // 此字段不允许为空
            }
        }
    });
})
function loadData() {   // 定义数据读取的操作函数
    $.post("pages/back/biye/biye_list.action", {"cp": jsCommonCp, "ls": jsCommonLs}, function (obj) {
        $("#biyeTable tr:gt(0)").remove();
        for(var x=0;x < obj.allBiye.length;x++){
            addRow(obj.allBiye[x].byid,obj.allBiye[x].byname);
        }
        createSplitBar(obj.allRecorders);
        setSelectAll($("#selall"),$("input[id='byid']"));
        setDelete7($("#deleteBtn7"),$("input[id='byid']"),"pages/back/biye/biye_delete.action");
    }, "json");
};

function addRow(byid,byname) {
    var str = "<tr><td class='text-center'><input type='checkbox' class='text-center' name='byid' id='byid' value='"+byid+"'></td>" +
        "<td class='text-center' id='byid-"+byid+"'>"+byid+"</td>" +
        "<td class='text-center' id='byname-"+byid+"'>"+byname+"</td>" +
        "<td class='text-center'><button type='button' class='btn btn-success btn-sm' data-toggle='modal' data-target='#biyeInfo' id='"+ byid +"'>更新</button> </td>" +
        "</tr>";
    $("#biyeTable").append($(str));
     $("#"+byid).on("click",function () {
            $("#bbyid").text(byid);
            $("#byname").val(byname);
    });
}
