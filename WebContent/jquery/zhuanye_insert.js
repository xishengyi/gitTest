$(function() {  // 在页面加载的时候执行
	loadXueyuan(); // 加载数据
    $("#insertForm").validate({ // 定义验证规则
        debug: true,  // 采用调试模式，表单不会自动提交
        submitHandler: function (form) {    // 当前表单对象
            form.submit(); // 手工提交，如果不需要手工提交，可以在此处进行异步处理
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
});

function loadXueyuan() {
    $.post("pages/back/xueyuan/xueyuan_list.action",{},function (obj) {
        $("#xueyuan\\.xID tr:gt(0)").remove();
        for (var x = 0;x <obj.allXueyuan.length;x++){
            $("#xueyuan\\.xID ").append($("<option value='"+obj.allXueyuan[x].xID+"'>"+obj.allXueyuan[x].xname+"</option>"));
        }
    },"json");
}