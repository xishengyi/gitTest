var jsCommonCp = 1;        // 当前所在页
var jsCommonLs = 4;        // 每页显示的数据个数
var jsCommonPageSize;      // 总页数
function createSplitBar(allRecorders) {    // 专门用于创建分页的操作
    clearBar();    // 清空全部的内容
    calcPageSize(allRecorders);    // 计算总页数
    if (jsCommonPageSize > 1) { // 有很多页
        previousPage() ;
        addBar(1) ;
    }
    var seed = 3 ;  // 设置一个分页种子数
    if (jsCommonCp > seed * 2) {    // 页码很大
        addDetailPage() ;   // 增加省略页
        var startPage = jsCommonCp - seed ;
        for (var x = startPage ; x <= jsCommonCp + seed ; x ++) {
            if (x < jsCommonPageSize) {
                addBar(x) ;
            }
        }
        if (jsCommonCp + seed * 2 < jsCommonPageSize) {
            addDetailPage() ;
        }
    } else {
        for (var x = 2 ; x <= jsCommonCp + seed ; x ++) {
            if (x < jsCommonPageSize) {
                addBar(x) ;
            }
        }
        if (jsCommonCp + seed <= jsCommonPageSize) {
            addDetailPage() ;
        }
    }

    addBar(jsCommonPageSize) ;
    if (jsCommonPageSize > 1) {
        nextPage() ;
    }
}
function addDetailPage() {
    var liObj = $("<li><span>...</span></li>") ;
    $("#pagecontrol").append(liObj) ;
}
function previousPage() {   // 上一页按钮
    var liObj = $("<li></li>");    // 定义li元素
    var aObj = $("<a style='cursor:pointer;'>上一页</a>");
    if (jsCommonCp == 1) {  // 已经是第一页了
        liObj.addClass("disabled") ;
    } else {
        aObj.on("click",function(){
            if (jsCommonCp > 1) {   // 可以有上一页
                jsCommonCp -- ;
                loadData();
            }
        })
    }
    liObj.append(aObj) ;
    $("#pagecontrol").append(liObj) ;
}
function nextPage() {   // 下一页按钮
    var liObj = $("<li></li>");    // 定义li元素
    var aObj = $("<a style='cursor:pointer;'>下一页</a>");
    if (jsCommonCp == jsCommonPageSize) {  // 已经是总页数
        liObj.addClass("disabled") ;
    } else {
        aObj.on("click",function(){
            if (jsCommonCp < jsCommonPageSize) {   // 可以有下一页
                jsCommonCp ++ ;
                loadData();
            }
        })
    }
    liObj.append(aObj) ;
    $("#pagecontrol").append(liObj) ;
}
function clearBar() {   // 清空已有的内容
    $("#pagecontrol li").remove();
}
function addBar(index) { // 专门生成分页控制代码
    var liObj = $("<li></li>");    // 定义li元素
    var aObj = $("<a style='cursor:pointer;'>" + index + "</a>");
    if (jsCommonCp == index) {  // 为当前所在页
        liObj.addClass("active") ;
    } else {
        aObj.on("click",function(){
            jsCommonCp = index ;
            loadData() ;
        })
    }
    liObj.append(aObj) ;
    $("#pagecontrol").append(liObj) ;
}
function calcPageSize(allRecorders) {   // 计算总页数
    if (allRecorders == 0) {    // 没有数据
        jsCommonPageSize = 1;  // 就在第1页上显示
    } else {    // 避免小数点问题
        jsCommonPageSize = parseInt((allRecorders + jsCommonLs - 1) / jsCommonLs);
    }
}
// 表示实现全选功能
function setSelectAll(eleA,eleB) {
    eleA.on("click",function () {
        eleB.each(function () {
            this.checked = eleA.prop("checked");
        })
    })
}
// 实现批量删除操作
function  setDelete(btn,ele,url) {
    btn.on("click",function () {
        var data = "";
        ele.each(function () {
            if(this.checked){
                data += this.value + "|";
            }
        });
        if (data == ""){
            alert("请选择数据后操作！")
        }else{
            $.post(url,{"ids":data},function(obj){
                if(obj.trim() == "true"){
                    $("#alertDiv").attr("class","alert alert-success");
                    $("#alertText").text("学生信息删除成功!");
                    loadData(); // 重新加载数据
                }else{
                    $("#alertDiv").attr("class","alert alert-danger");                 
                    $("#alertText").text("学生信息删除失败!");                   
                }
                $("#alertDiv").fadeIn(2000,function () {
                    $("#alertDiv").fadeOut(2000);
                })
            },"text");
        }
    })
}
//实现批量删除操作
function  setDelete2(btn,ele,url) {
    btn.on("click",function () {
        var data = "";
        ele.each(function () {
            if(this.checked){
                data += this.value + "|";
            }
        });
        if (data == ""){
            alert("请选择数据后操作！")
        }else{
            $.post(url,{"ids":data},function(obj){
                if(obj.trim() == "true"){
                    $("#alertDiv1").attr("class","alert alert-success");
                    $("#alertText1").text("标记信息删除成功!");
                    loadData(); // 重新加载数据
                }else{
                    $("#alertDiv1").attr("class","alert alert-danger");                 
                    $("#alertText1").text("标记信息删除失败!");                   
                }
                $("#alertDiv1").fadeIn(2000,function () {
                    $("#alertDiv1").fadeOut(2000);
                })
            },"text");
        }
    })
}

//实现批量删除操作
function  setDelete5(btn,ele,url) {
    btn.on("click",function () {
        var data = "";
        ele.each(function () {
            if(this.checked){
                data += this.value + "|";
            }
        });
        if (data == ""){
            alert("请选择数据后操作！")
        }else{
            $.post(url,{"ids":data},function(obj){
                if(obj.trim() == "true"){
                    $("#alertDiv2").attr("class","alert alert-success");
                    $("#alertText2").text("学院信息删除成功!");
                    loadData(); // 重新加载数据
                }else{
                    $("#alertDiv2").attr("class","alert alert-danger");                 
                    $("#alertText2").text("学院信息删除失败!");                   
                }
                $("#alertDiv2").fadeIn(2000,function () {
                    $("#alertDiv2").fadeOut(2000);
                })
            },"text");
        }
    })
}

//实现批量删除操作
function  setDelete6(btn,ele,url) {
    btn.on("click",function () {
        var data = "";
        ele.each(function () {
            if(this.checked){
                data += this.value + "|";
            }
        });
        if (data == ""){
            alert("请选择数据后操作！")
        }else{
            $.post(url,{"ids":data},function(obj){
                if(obj.trim() == "true"){
                    $("#alertDiv6").attr("class","alert alert-success");
                    $("#alertText6").text("专业信息删除成功!");
                    loadData(); // 重新加载数据
                }else{
                    $("#alertDiv6").attr("class","alert alert-danger");                 
                    $("#alertText6").text("专业信息删除失败!");                   
                }
                $("#alertDiv6").fadeIn(2000,function () {
                    $("#alertDiv6").fadeOut(2000);
                })
            },"text");
        }
    })
}

//实现批量删除操作
function  setDelete7(btn,ele,url) {
    btn.on("click",function () {
        var data = "";
        ele.each(function () {
            if(this.checked){
                data += this.value + "|";
            }
        });
        if (data == ""){
            alert("请选择数据后操作！")
        }else{
            $.post(url,{"ids":data},function(obj){
                if(obj.trim() == "true"){
                    $("#alertDiv7").attr("class","alert alert-success");
                    $("#alertText7").text("毕业要求信息删除成功!");
                    loadData(); // 重新加载数据
                }else{
                    $("#alertDiv7").attr("class","alert alert-danger");                 
                    $("#alertText7").text("毕业要求信息删除失败!");                   
                }
                $("#alertDiv7").fadeIn(2000,function () {
                    $("#alertDiv7").fadeOut(2000);
                })
            },"text");
        }
    })
}

//实现批量删除操作
function  setDelete8(btn,ele,url) {
    btn.on("click",function () {
        var data = "";
        ele.each(function () {
            if(this.checked){
                data += this.value + "|";
            }
        });
        if (data == ""){
            alert("请选择数据后操作！")
        }else{
            $.post(url,{"ids":data},function(obj){
                if(obj.trim() == "true"){
                    $("#alertDiv8").attr("class","alert alert-success");
                    $("#alertText8").text("验收标准信息删除成功!");
                    loadData(); // 重新加载数据
                }else{
                    $("#alertDiv8").attr("class","alert alert-danger");                 
                    $("#alertText8").text("验收标准信息删除失败!");                   
                }
                $("#alertDiv8").fadeIn(2000,function () {
                    $("#alertDiv8").fadeOut(2000);
                })
            },"text");
        }
    })
}
//实现批量删除操作
function  setDelete9(btn,ele,url) {
    btn.on("click",function () {
        var data = "";
        ele.each(function () {
            if(this.checked){
                data += this.value + "|";
            }
        });
        if (data == ""){
            alert("请选择数据后操作！")
        }else{
            $.post(url,{"ids":data},function(obj){
                if(obj.trim() == "true"){
                    $("#alertDiv9").attr("class","alert alert-success");
                    $("#alertText9").text("教师信息删除成功!");
                    loadData(); // 重新加载数据
                }else{
                    $("#alertDiv9").attr("class","alert alert-danger");                 
                    $("#alertText9").text("教师信息删除失败!");                   
                }
                $("#alertDiv9").fadeIn(2000,function () {
                    $("#alertDiv9").fadeOut(2000);
                })
            },"text");
        }
    })
}
//实现批量删除操作
function  setDelete11(btn,ele,url) {
    btn.on("click",function () {
        var data = "";
        ele.each(function () {
            if(this.checked){
                data += this.value + "|";
            }
        });
        if (data == ""){
            alert("请选择数据后操作！")
        }else{
            $.post(url,{"ids":data},function(obj){
                if(obj.trim() == "true"){
                    $("#alertDiv11").attr("class","alert alert-success");
                    $("#alertText11").text("课程信息删除成功!");
                    loadData(); // 重新加载数据
                }else{
                    $("#alertDiv11").attr("class","alert alert-danger");                 
                    $("#alertText11").text("课程信息删除失败!");                   
                }
                $("#alertDiv11").fadeIn(2000,function () {
                    $("#alertDiv11").fadeOut(2000);
                })
            },"text");
        }
    })
}
//实现批量删除操作
function  setDelete12(btn,ele,url) {
    btn.on("click",function () {
        var data = "";
        ele.each(function () {
            if(this.checked){
                data += this.value + "|";
            }
        });
        if (data == ""){
            alert("请选择数据后操作！")
        }else{
            $.post(url,{"ids":data},function(obj){
                if(obj.trim() == "true"){
                    $("#alertDiv0").attr("class","alert alert-success");
                    $("#alertText0").text("课程评价标准删除成功!");
                    loadData(); // 重新加载数据
                }else{
                    $("#alertDiv0").attr("class","alert alert-danger");                 
                    $("#alertText0").text("课程评价标准删除失败!");                   
                }
                $("#alertDiv0").fadeIn(2000,function () {
                    $("#alertDiv0").fadeOut(2000);
                })
            },"text");
        }
    })
}