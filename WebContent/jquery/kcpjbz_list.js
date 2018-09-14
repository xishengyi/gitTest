$(function () {
    loadData();
    $("#updateForm").validate({ // 定义验证规则
        debug: true,  // 采用调试模式，表单不会自动提交
        submitHandler: function (form) {    // 当前表单对象
            // form.submit(); // 手工提交，如果不需要手工提交，可以在此处进行异步处理
           var uid = $("#uuid").text();
           var uname = $("#uname").val();    
           var uaim = $("#uaim").val();
           var saim = $("#saim").val();
           var khfs = $("#khfs").val();
           var pjbz = $("#pjbz").val();
           var qz = $("#qz").val();
           var sjdcd = $("#sjdcd").val();
         
           $.post("pages/back/kcpjbz/kcpjbz_update.action",{"uid":uid,"uname":uname,"uaim":uaim,"saim":saim,"khfs":khfs,"pjbz":pjbz,"qz":qz,"sjdcd":sjdcd},function(obj){
            	 if(obj.trim() == "true"){
            		 $("#alertDiv0").attr("class","alert alert-success");
                     $("#alertText0").text("课程评价标准修改成功!");
                     $("#uid-"+uid).text(uid);
                     $("#uname-"+uid).text(uname);
                     $("#uaim-"+uid).text(uaim);
                     $("#saim-"+uid).text(saim);
                     $("#khfs-"+uid).text(khfs);
                     $("pjbz-"+uid).text(pjbz);
                     $("qz-"+uid).text(qz);
                     $("sjdcd-"+uid).text(sjdcd);
                     
                     loadData();
            	 }else{
                     $("#alertDiv0").attr("class","alert alert-danger");
                     $("#alertText0").text("课程评价标准修改失败!");
                 }
            	 $("#kcpjbzInfo").modal("hide");
                 $("#alertDiv0").fadeIn(2000,function () {
                     $("#alertDiv0").fadeOut(2000);
                 });
            },"text");
        
        },
        rules: {   // 为每一个表单编写验证规则

        	"uid": {
                required: true,  // 此字段不允许为空
            },
            "uname": {
                required: true,  // 此字段不允许为空
            },
            "uaim": {
                required: true,  // 此字段不允许为空
            },
            "saim": {
                required: true,  // 此字段不允许为空
            },
            "khfs": {
                required: true,  // 此字段不允许为空
            },
            "pjbz": {
                required: true,  // 此字段不允许为空
            },
            "qz": {
                required: true,  // 此字段不允许为空
            },
            "sjdcd": {
                required: true,  // 此字段不允许为空
            }
        }
    });
})

function loadData() {
    $.post("pages/back/kcpjbz/kcpjbz_list.action",{"cp": jsCommonCp, "ls": jsCommonLs},function (obj) {
        $("#kcpjbzTable tr:gt(0)").remove();
        for (var x = 0;x <obj.allKcpjbz.length;x++){
            addRow(obj.allKcpjbz[x].uid,obj.allKcpjbz[x].uname,obj.allKcpjbz[x].uaim,obj.allKcpjbz[x].saim,obj.allKcpjbz[x].khfs,obj.allKcpjbz[x].pjbz,obj.allKcpjbz[x].qz,obj.allKcpjbz[x].sjdcd);
        }
        createSplitBar(obj.allRecorders);
        setSelectAll($("#selall2"),$("input[id='uid']"));
        setDelete9($("#deleteBtn12"),$("input[id='uid']"),"pages/back/kcpjbz/kcpjbz_delete.action");
        query($("#query"),"pages/back/kcpjbz/kcpjbz_findByName.action");
    },"json");
}

function addRow(uid,uname,uaim,saim,khfs,pjbz,qz,sjdcd) {
    var str = "<tr><td class='text-center'><input type='checkbox' class='text-center' name='uid' id='uid' value='"+uid+"'></td>" +
    "<td class='text-center' id='uid-"+uid+"'>"+uid+"</td>" +
    "<td class='text-center' id='uname-"+uid+"'>"+uname+"</td>" +
    "<td class='text-center' id='uaim-"+uid+"'>"+uaim+"</td>" +
    "<td class='text-center' id='saim-"+uid+"'>"+saim+"</td>" +
    "<td class='text-center' id='khfs-"+uid+"'>"+khfs+"</td>" +
    "<td class='text-center' id='pjbz-"+uid+"'>"+pjbz+"</td>" +
    "<td class='text-center' id='qz-"+uid+"'>"+qz+"</td>" +
    "<td class='text-center' id='sjdcd-"+uid+"'>"+sjdcd+"</td>" +
    "<td class='text-center'><button type='button' class='btn btn-success btn-sm' data-toggle='modal' data-target='#kcpjbzInfo' id='"+ uid +"'>更新</button> </td>" +
    "</tr>";
    $("#kcpjbzTable").append($(str));
    //模态窗口填充
    $("#"+uid).on("click",function () {
        $("#uuid").text(uid);
        $("#uname").val(uname);
        $("#uaim").val(uaim);
        $("#saim").val(saim);
        $("#khfs").val(khfs);
        $("#pjbz").val(pjbz);
        $("#qz").val(qz);
        $("#sjdcd").val(sjdcd);
    });
}
//实现查询操作
function query(btn,url){
	btn.on("click",function () {
		var keyword = $("#keyword").val();
		$.post(url,{"keyword":keyword},function(obj){
			 $("#kcpjbzTable tr:gt(0)").remove();
			 for (var x = 0;x <obj.allKcpjbz.length;x++){
		            addRow(obj.allKcpjbz[x].uid,obj.allKcpjbz[x].uname,obj.allKcpjbz[x].uaim,obj.allKcpjbz[x].saim,obj.allKcpjbz[x].khfs,obj.allKcpjbz[x].pjbz,obj.allKcpjbz[x].qz,obj.allKcpjbz[x].sjdcd);
		        }
		        
		        createSplitBar(obj.allRecorders);
		        setSelectAll($("#selall2"),$("input[id='uid']"));
		        setDelete9($("#deleteBtn12"),$("input[id='uid']"),"pages/back/kcpjbz/kcpjbz_delete.action");  
        },"json");
	});
}