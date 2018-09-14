$(function () {
    loadData();
    $("#updateForm").validate({ // 定义验证规则
        debug: true,  // 采用调试模式，表单不会自动提交
        submitHandler: function (form) {    // 当前表单对象
            // form.submit(); // 手工提交，如果不需要手工提交，可以在此处进行异步处理
           var id = $("#idd").text();
           var name = $("#name").val();    
           var note = $("#note").val();  
           alert(id+","+name+","+note)
           $.post("pages/back/note/note_update.action",{"id":id,"name":name,"note":note},function(obj){
            	 if(obj.trim() == "true"){
            		 $("#alertDiv1").attr("class","alert alert-success");
                     $("#alertText1").text("标记信息修改成功!");
                     $("#id-"+id).text(id);
                     $("#name-"+id).text(name);
                     $("#note-"+id).text(note);
                     loadData();
            	 }else{
                     $("#alertDiv1").attr("class","alert alert-danger");
                     $("#alertText1").text("标记信息修改失败!");
                 }
            	 $("#noteInfo").modal("hide");
                 $("#alertDiv1").fadeIn(2000,function () {
                     $("#alertDiv1").fadeOut(2000);
                 });
            },"text");
        
        },
        rules: {   // 为每一个表单编写验证规则

            "id": {
                required: true,  // 此字段不允许为空
            },
            "name": {
                required: true,  // 此字段不允许为空
            },
           
            "note": {
                required: true,  // 此字段不允许为空
            }
        }
    });
})

function loadData() {
    $.post("pages/back/note/note_list.action",{"cp": jsCommonCp, "ls": jsCommonLs},function (obj) {
        $("#noteTable tr:gt(0)").remove();
        for (var x = 0;x <obj.allNote.length;x++){
            addRow(obj.allNote[x].id,obj.allNote[x].name,obj.allNote[x].note);
        }
        createSplitBar(obj.allRecorders);
        setSelectAll($("#selall2"),$("input[id='id']"));
        setDelete2($("#deleteBtn2"),$("input[id='id']"),"pages/back/note/note_delete.action");
        query($("#query"),"pages/back/note/note_findByName.action");
    },"json");
}

function addRow(id,name,note) {
    var str = "<tr><td class='text-center'><input type='checkbox' class='text-center' name='id' id='id' value='"+id+"'></td>" +
    "<td class='text-center' id='id-"+id+"'>"+id+"</td>" +
    "<td class='text-center' id='name-"+id+"'>"+name+"</td>" +
    "<td class='text-center' id='note-"+id+"'>"+note+"</td>" +
    "<td class='text-center'><button type='button' class='btn btn-success btn-sm' data-toggle='modal' data-target='#noteInfo' id='"+ id +"'>更新</button> </td>" +
    "</tr>";
    $("#noteTable").append($(str));
    //模态窗口填充
    $("#"+id).on("click",function () {
        $("#idd").text(id);
        $("#name").val(name);
        $("#note").val(note);
    });
}
//实现查询操作
function query(btn,url){
	btn.on("click",function () {
		var keyword = $("#keyword").val();
		$.post(url,{"keyword":keyword},function(obj){
			 $("#noteTable tr:gt(0)").remove();
		        for (var x = 0;x <obj.allNote.length;x++){
		            addRow(obj.allNote[x].id,obj.allNote[x].name,obj.allNote[x].note);
		        }
		        createSplitBar(obj.allRecorders);
		        setSelectAll($("#selall2"),$("input[id='id']"));
		        setDelete2($("#deleteBtn2"),$("input[id='id']"),"pages/back/note/note_delete.action");  
        },"json");
	});
}