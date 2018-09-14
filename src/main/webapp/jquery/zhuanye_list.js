$(function () {
    loadData();
    $("#updateForm").validate({ // 定义验证规则
        debug: true,  // 采用调试模式，表单不会自动提交
        submitHandler: function (form) {    // 当前表单对象
            // form.submit(); // 手工提交，如果不需要手工提交，可以在此处进行异步处理
           var zid = $("#zzid").text();
            var zname = $("#zname").val();
            var xID = $("#xueyuan").val()
            $.post("pages/back/zhuanye/zhuanye_update.action",{"zid":zid,"zname":zname,"xueyuan.xID":xID},function(obj){
                if(obj.trim() == "true"){
                    $("#alertDiv6").attr("class","alert alert-success");
                    $("#alertText6").text("专业信息修改成功!");
                    $("#zid-"+zid).text(zid);
                    $("#zname-"+zid).text(zname);
                    
                }else{
                    $("#alertDiv6").attr("class","alert alert-danger");
                    $("#alertText6").text("专业信息修改失败!");
                }
                $("#zhuanyeInfo").modal("hide");
                $("#alertDiv6").fadeIn(2000,function () {
                    $("#alertDiv6").fadeOut(2000);
                });
            },"text");
        },
        rules: {   // 为每一个表单编写验证规则

            "zid": {
                required: true,  // 此字段不允许为空
            },
            "zname": {
                required: true,  // 此字段不允许为空
            }
            
        }
    });
})
function loadData() {   // 定义数据读取的操作函数
    $.post("pages/back/zhuanye/zhuanye_list.action", {"cp": jsCommonCp, "ls": jsCommonLs}, function (obj) {
        $("#zhuanyeTable tr:gt(0)").remove();
        for(var x=0;x < obj.allZhuanye.length;x++){
            addRow(obj.allZhuanye[x].zid,obj.allZhuanye[x].zname,obj.allZhuanye[x].xueyuan.xID);
        }
        createSplitBar(obj.allRecorders);
        setSelectAll($("#selall"),$("input[id='zid']"));
        setDelete6($("#deleteBtn6"),$("input[id='zid']"),"pages/back/zhuanye/zhuanye_delete.action");
    }, "json");
};

function addRow(zid,zname,xID) {
    var str = "<tr><td class='text-center'><input type='checkbox' class='text-center' name='zid' id='zid' value='"+zid+"'></td>" +
        "<td class='text-center' id='zid-"+zid+"'>"+zid+"</td>" +
        "<td class='text-center' id='zname-"+zid+"'>"+zname+"</td>" +
        "<td class='text-center'><button type='button' class='btn btn-success btn-sm' data-toggle='modal' data-target='#zhuanyeInfo' id='"+ zid +"-"+ xID +"'>更新</button> </td>" +
        "</tr>";
    $("#zhuanyeTable").append($(str));
    $("#"+zid+"-"+xID).on("click",function () {
        $("#zzid").text(sid);
        $("#zname").val(name);
        loadXueyuan(xID);
    });
}

function loadXueyuan(xID) {
    $.post("pages/back/xueyuan/xueyuan_list.action",{},function (obj) {
        $("#xueyuan tr:gt(0)").remove();
        for (var x = 0;x <obj.allXueyuan.length;x++){
            if (obj.allXueyuan[x].xID== xID){
                $("#xueyuan ").append($("<option value='" + obj.allXueyuan[x].xID + "' selected>" + obj.allXueyuan[x].xname + "</option>"));
            }else {
                $("#xueyuan ").append($("<option value='" + obj.allXueyuan[x].xID + "'>" + obj.allXueyuan[x].xname + "</option>"));
            }
        }
    },"json");
}