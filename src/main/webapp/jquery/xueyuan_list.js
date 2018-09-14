$(function () {
    loadData();
    $("#updateForm").validate({ // 定义验证规则
        debug: true,  // 采用调试模式，表单不会自动提交
        submitHandler: function (form) {    // 当前表单对象
            // form.submit(); // 手工提交，如果不需要手工提交，可以在此处进行异步处理
           var xID = $("#xxID").text();
            var xname = $("#xname").val();
            
            $.post("pages/back/xueyuan/xueyuan_update.action",{"xID":xID,"xname":xname},function(obj){
                if(obj.trim() == "true"){
                    $("#alertDiv").attr("class","alert alert-success");
                    $("#alertText").text("学院信息修改成功!");
                    $("#xID-"+xID).text(xID);
                    $("#xname-"+xID).text(xname);
                }else{
                    $("#alertDiv").attr("class","alert alert-danger");
                    $("#alertText").text("学院信息修改失败!");
                }
                $("#xueyuanInfo").modal("hide");
                $("#alertDiv").fadeIn(2000,function () {
                    $("#alertDiv").fadeOut(2000);
                });
            },"text");
        },
        rules: {   // 为每一个表单编写验证规则

            "xID": {
                required: true,  // 此字段不允许为空
            },
            "xname": {
                required: true,  // 此字段不允许为空
            }
        }
    });
})
function loadData() {   // 定义数据读取的操作函数
    $.post("pages/back/xueyuan/xueyuan_list.action", {"cp": jsCommonCp, "ls": jsCommonLs}, function (obj) {
        $("#xueyuanTable tr:gt(0)").remove();
        for(var x=0;x < obj.allXueyuan.length;x++){
            addRow(obj.allXueyuan[x].xID,obj.allXueyuan[x].xname);
        }
        createSplitBar(obj.allRecorders);
        setSelectAll($("#selall"),$("input[id='xID']"));
        setDelete($("#deleteBtn"),$("input[id='xID']"),"pages/back/xueyuan/xueyuan_delete.action");
    }, "json");
};

function addRow(xID,xname) {
    var str = "<tr><td class='text-center'><input type='checkbox' class='text-center' name='xID' id='xID' value='"+xID+"'></td>" +
        "<td class='text-center' id='xID-"+xID+"'>"+xID+"</td>" +
        "<td class='text-center' id='xname-"+xID+"'>"+xname+"</td>" +
        "<td class='text-center'><button type='button' class='btn btn-success btn-sm' data-toggle='modal' data-target='#xueyuanInfo' id='"+ xID +"'>更新</button> </td>" +
        "</tr>";
    $("#xueyuanTable").append($(str));
     $("#"+xID).on("click",function () {
            $("#xxID").text(xID);
            $("#xname").val(xname);
    });
}
