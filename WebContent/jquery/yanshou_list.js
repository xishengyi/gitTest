$(function () {
    loadData();
    $("#updateForm").validate({ // 定义验证规则
        debug: true,  // 采用调试模式，表单不会自动提交
        submitHandler: function (form) {    // 当前表单对象
            // form.submit(); // 手工提交，如果不需要手工提交，可以在此处进行异步处理
           var ysid = $("#yysid").text();
            var bzcj = $("#bzcj").val();
            var cnbh = $("#cnbh").val();
            var bznr = $("#bznr").val();
            var sjid = $("#sjid").val();
            var zwcd = $("#zwcd").val();
            
            var byid = $("#biye").val()
            $.post("pages/back/yanshou/yanshou_update.action",{"ysid":ysid,"bzcj":bzcj,"cnbh":cnbh,"bznr":bznr,"sjid":sjid,"zwcd":zwcd,"biye.byid":byid},function(obj){
                if(obj.trim() == "true"){
                    $("#alertDiv8").attr("class","alert alert-success");
                    $("#alertText8").text("验收标准信息修改成功!");
                    $("#ysid-"+ysid).text(ysid);
                    $("#bzcj-"+ysid).text(bzcj);
                    $("#cnbh-"+ysid).text(cnbh);
                    $("#bznr-"+ysid).text(bznr);
                    $("#sjid-"+ysid).text(sjid);
                    $("#zwcd-"+ysid).text(zwcd);
                    
                }else{
                    $("#alertDiv8").attr("class","alert alert-danger");
                    $("#alertText8").text("验收标准信息修改失败!");
                }
                $("#yanshouInfo").modal("hide");
                $("#alertDiv8").fadeIn(2000,function () {
                    $("#alertDiv8").fadeOut(2000);
                });
            },"text");
        },
        rules: {   // 为每一个表单编写验证规则
        	 "ysid": {
                 required: true,  // 此字段不允许为空
             },
             "bzcj": {
                 required: true,  // 此字段不允许为空
             },
             "cnbh": {
                 required: true,  // 此字段不允许为空
             },
             "bznr": {
                 required: true,  // 此字段不允许为空
             },
             "sjid": {
                 required: true,  // 此字段不允许为空
             },
             "zwcd": {
                 required: true,  // 此字段不允许为空
             }
            
        }
    });
})
function loadData() {   // 定义数据读取的操作函数
    $.post("pages/back/yanshou/yanshou_list.action", {"cp": jsCommonCp, "ls": jsCommonLs}, function (obj) {
        $("#yanshouTable tr:gt(0)").remove();
        for(var x=0;x < obj.allYanshou.length;x++){
            addRow(obj.allYanshou[x].ysid,obj.allYanshou[x].bzcj,obj.allYanshou[x].cnbh,obj.allYanshou[x].bznr,obj.allYanshou[x].sjid,obj.allYanshou[x].zwcd,obj.allYanshou[x].biye.byid);
        }
        createSplitBar(obj.allRecorders);
        setSelectAll($("#selall"),$("input[id='ysid']"));
        setDelete8($("#deleteBtn8"),$("input[id='ysid']"),"pages/back/yanshou/yanshou_delete.action");
    }, "json");
};

function addRow(ysid,bzcj,cnbh,bznr,sjid,zwcd,byid) {
    var str = "<tr><td class='text-center'><input type='checkbox' class='text-center' name='ysid' id='ysid' value='"+ysid+"'></td>" +
        "<td class='text-center' id='ysid-"+ysid+"'>"+ysid+"</td>" +
        "<td class='text-center' id='bzcj-"+ysid+"'>"+bzcj+"</td>" +
        "<td class='text-center' id='cnbh-"+ysid+"'>"+cnbh+"</td>" +
        "<td class='text-center' id='bznr-"+ysid+"'>"+bznr+"</td>" +
        "<td class='text-center' id='sjid-"+ysid+"'>"+sjid+"</td>" +
        "<td class='text-center' id='zwcd-"+ysid+"'>"+zwcd+"</td>" +
        "<td class='text-center'><button type='button' class='btn btn-success btn-sm' data-toggle='modal' data-target='#yanshouInfo' id='"+ ysid +"-"+ byid +"'>更新</button> </td>" +
        "</tr>";
    $("#yanshouTable").append($(str));
    $("#"+ysid+"-"+byid).on("click",function () {
        $("#yysid").text(ysid);
        $("#bzcj").val(bzcj);
        $("#cnbh").val(cnbh);
        $("#bznr").val(bznr);
        $("#sjid").val(sjid);
        $("#zwcd").val(zwcd);
        loadBiye(byid);
    });
}

function loadBiye(byid) {
    $.post("pages/back/biye/biye_list.action",{},function (obj) {
        $("#biye tr:gt(0)").remove();
        for (var x = 0;x <obj.allBiye.length;x++){
            if (obj.allBiye[x].byid== byid){
                $("#biye ").append($("<option value='" + obj.allBiye[x].byid + "' selected>" + obj.allBiye[x].byname + "</option>"));
            }else {
                $("#biye ").append($("<option value='" + obj.allBiye[x].byid + "'>" + obj.allBiye[x].byname + "</option>"));
            }
        }
    },"json");
}