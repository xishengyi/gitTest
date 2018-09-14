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
       <h2 class="h2" style="text-align: center">增加课程评价标准</h2>
   </div>
            <form action="<%=basePath%>pages/back/kcpjbz/kcpjbz_insert.action" method="post" class="form-horizontal" id="insertForm">
                <%--教师编号--%>
                <div class="form-group">
                    <label for="uid" class="control-label col-md-3">单元编号</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="tid" id="tid" placeholder="请输入单元编号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="uname" class="control-label col-md-3">单元名称</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="uname" id="uname" placeholder="请输入单元名称">
                    </div>
                </div>
                <div class="form-group">
                    <label for="uaim" class="control-label col-md-3">单元目标</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="uaim" id="uaim" placeholder="请输入单元目标">
                    </div>
                </div>
                <div class="form-group">
                    <label for="saim" class="control-label col-md-3">学习目标</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="saim" id="saim" placeholder="请输入学习目标">
                    </div>
                </div>
                 <div class="form-group">
                    <label for="khfs" class="control-label col-md-3">考核方式</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="khfs" id="khfs" placeholder="请输入考核方式">
                    </div>
                </div>
                 <div class="form-group">
                    <label for="pjbz" class="control-label col-md-3">评价标准</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="pjbz" id="pjbz" placeholder="请输入评价标准">
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="qz" class="control-label col-md-3">权重</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="qz" id="qz" placeholder="请输入权重">
                    </div>
                </div>
                <div class="form-group">
                    <label for="sjdcd" class="control-label col-md-3">实际达成度</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="sjdcd" id="sjdcd" placeholder="请输入实际达成度">
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
<script src="jquery/kcpjbz_insert.js"></script>
</body>
</html>
