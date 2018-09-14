$(function () {
    loadData();
    $("#updateForm").validate({ // 定义验证规则
        debug: true,  // 采用调试模式，表单不会自动提交
        submitHandler: function (form) {    // 当前表单对象
            // form.submit(); // 手工提交，如果不需要手工提交，可以在此处进行异步处理
           var kid = $("#kkid").text();
           var kname = $("#kname").val();    
           var ktime = $("#ktime").val();  
           //alert(id+","+name+","+note)
           $.post("pages/back/course/course_update.action",{"kid":kid,"kname":kname,"ktime":ktime},function(obj){
            	 if(obj.trim() == "true"){
            		 $("#alertDiv11").attr("class","alert alert-success");
                     $("#alertText11").text("课程信息修改成功!");
                     $("#kid-"+kid).text(kid);
                     $("#kname-"+kid).text(kname);
                     $("#ktime-"+kid).text(ktime);
                     loadData();
            	 }else{
                     $("#alertDiv11").attr("class","alert alert-danger");
                     $("#alertText11").text("课程信息修改失败!");
                 }
            	 $("#courseInfo").modal("hide");
                 $("#alertDiv11").fadeIn(2000,function () {
                     $("#alertDiv11").fadeOut(2000);
                 });
            },"text");
        
        },
        rules: {   // 为每一个表单编写验证规则

            "kid": {
                required: true,  // 此字段不允许为空
            },
            "kname": {
                required: true,  // 此字段不允许为空
            },
           
            "ktime": {
                required: true,  // 此字段不允许为空
            }
        }
    });
})

function loadData() {
    $.post("pages/back/course/course_list.action",{"cp": jsCommonCp, "ls": jsCommonLs},function (obj) {
        $("#courseTable tr:gt(0)").remove();
        for (var x = 0;x <obj.allCourse.length;x++){
            addRow(obj.allCourse[x].kid,obj.allCourse[x].kname,obj.allCourse[x].ktime);
        }
        createSplitBar(obj.allRecorders);
        setSelectAll($("#selall2"),$("input[id='kid']"));
        setDelete11($("#deleteBtn11"),$("input[id='kid']"),"pages/back/course/course_delete.action");
        query($("#query"),"pages/back/course/course_findByName.action");
    },"json");
}

function addRow(kid,kname,ktime) {
    var str = "<tr><td class='text-center'><input type='checkbox' class='text-center' name='kid' id='kid' value='"+kid+"'></td>" +
    "<td class='text-center' id='kid-"+kid+"'>"+kid+"</td>" +
    "<td class='text-center' id='kname-"+kid+"'>"+kname+"</td>" +
    "<td class='text-center' id='ktime-"+kid+"'>"+ktime+"</td>" +
    "<td class='text-center'><button type='button' class='btn btn-success btn-sm' data-toggle='modal' data-target='#courseInfo' id='"+ kid +"'>更新</button> </td>" +
    "</tr>";
    $("#courseTable").append($(str));
    //模态窗口填充
    $("#"+kid).on("click",function () {
        $("#kkid").text(kid);
        $("#kname").val(kname);
        $("#ktime").val(ktime);
    });
}
//实现查询操作
function query(btn,url){
	btn.on("click",function () {
		var keyword = $("#keyword").val();
		$.post(url,{"keyword":keyword},function(obj){
			 $("#courseTable tr:gt(0)").remove();
		        for (var x = 0;x <obj.allCourse.length;x++){
		            addRow(obj.allCourse[x].kid,obj.allCourse[x].kname,obj.allCourse[x].ktime);
		        }
		        createSplitBar(obj.allRecorders);
		        setSelectAll($("#selall2"),$("input[id='kid']"));
		        setDelete11($("#deleteBtn11"),$("input[id='kid']"),"pages/back/course/course_delete.action");  
        },"json");
	});
}