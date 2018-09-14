<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>优乐在线教育图书管理系统</title>
</head>
<body>
<jsp:include page="/pages/header.jsp"/>
<!--主体内容编写-->
<div id="page-wrapper">
   <div class="col-md-12">
       <h2 class="h2" style="text-align: center">增加课程信息</h2>
   </div>
            <form action="<%=basePath%>pages/back/course/course_insert.action" method="post" class="form-horizontal" id="insertForm">
                <%--课程编号
                <div class="form-group">
                    <label for="kid" class="control-label col-md-3">课程编号</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="kid" id="kid" placeholder="请输入课程编号">
                    </div>
                </div>--%>
                <div class="form-group">
                    <label for="kname" class="control-label col-md-3">课程名称</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="kname" id="kname" placeholder="请输入课程名称">
                    </div>
                </div>
                <div class="form-group">
                    <label for="ktime" class="control-label col-md-3">开课学期</label>
                    <div class="col-md-5">
                  	 	<input type="text" class="form-control" name="ktime" id="ktime" placeholder="请输入开课学期">        
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-4 col-md-offset-6">
                        <button type="submit" class="btn btn-success btn-sm">增加</button>
                        <button type="reset" class="btn btn-danger btn-sm">重置</button>
                    </div>
                </div>
            </form>
    </div>


<jsp:include page="/pages/footer.jsp"/>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/additional-methods.min.js"></script>
<script src="jquery/jquery.metadata.js"></script>
<script src="jquery/Message_zh_CN.js"></script>
<script src="jquery/course_insert.js"></script>
</body>
</html>
