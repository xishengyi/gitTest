$(function () {
    loadData();
    $("#updateForm").validate({ // 定义验证规则
        debug: true,  // 采用调试模式，表单不会自动提交
        submitHandler: function (form) {    // 当前表单对象
            // form.submit(); // 手工提交，如果不需要手工提交，可以在此处进行异步处理
           var tid = $("#ttid").text();
           var tname = $("#tname").val();    
          
         
           $.post("pages/back/teacher/teacher_update.action",{"tid":tid,"tname":tname},function(obj){
            	 if(obj.trim() == "true"){
            		 $("#alertDiv9").attr("class","alert alert-success");
                     $("#alertText9").text("教师信息修改成功!");
                     $("#tid-"+tid).text(tid);
                     $("#tname-"+tid).text(tname);
                   
                     loadData();
            	 }else{
                     $("#alertDiv9").attr("class","alert alert-danger");
                     $("#alertText9").text("教师信息修改失败!");
                 }
            	 $("#teacherInfo").modal("hide");
                 $("#alertDiv9").fadeIn(2000,function () {
                     $("#alertDiv9").fadeOut(2000);
                 });
            },"text");
        
        },
        rules: {   // 为每一个表单编写验证规则

            "tid": {
                required: true,  // 此字段不允许为空
            },
            "tname": {
                required: true,  // 此字段不允许为空
            }
        }
    });
})

function loadData() {
    $.post("pages/back/teacher/teacher_list.action",{"cp": jsCommonCp, "ls": jsCommonLs},function (obj) {
        $("#teacherTable tr:gt(0)").remove();
        for (var x = 0;x <obj.allTeacher.length;x++){
            addRow(obj.allTeacher[x].tid,obj.allTeacher[x].tname);
        }
        createSplitBar(obj.allRecorders);
        setSelectAll($("#selall2"),$("input[id='tid']"));
        setDelete9($("#deleteBtn9"),$("input[id='tid']"),"pages/back/teacher/teacher_delete.action");
        query($("#query"),"pages/back/teacher/teacher_findByName.action");
    },"json");
}

function addRow(tid,tname) {
    var str = "<tr><td class='text-center'><input type='checkbox' class='text-center' name='tid' id='tid' value='"+tid+"'></td>" +
    "<td class='text-center' id='tid-"+tid+"'>"+tid+"</td>" +
    "<td class='text-center' id='tname-"+tid+"'>"+tname+"</td>" +
    
    "<td class='text-center'><button type='button' class='btn btn-success btn-sm' data-toggle='modal' data-target='#teacherInfo' id='"+ tid +"'>更新</button> </td>" +
    "</tr>";
    $("#teacherTable").append($(str));
    //模态窗口填充
    $("#"+tid).on("click",function () {
        $("#ttid").text(tid);
        $("#tname").val(tname);
       
    });
}
//实现查询操作
function query(btn,url){
	btn.on("click",function () {
		var keyword = $("#keyword").val();
		$.post(url,{"keyword":keyword},function(obj){
			 $("#teacherTable tr:gt(0)").remove();
		        for (var x = 0;x <obj.allTeacher.length;x++){
		            addRow(obj.allTeacher[x].tid,obj.allTeacher[x].tname);
		        }
		        createSplitBar(obj.allRecorders);
		        setSelectAll($("#selall2"),$("input[id='tid']"));
		        setDelete9($("#deleteBtn9"),$("input[id='tid']"),"pages/back/teacher/teacher_delete.action");  
        },"json");
	});
}