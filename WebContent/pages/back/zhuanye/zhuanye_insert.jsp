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
       <h2 class="h2" style="text-align: center">增加专业</h2>
   </div>
            <form action="<%=basePath%>pages/back/zhuanye/zhuanye_insert.action" method="post" class="form-horizontal" id="insertForm">
                <%--学生编号--%>
                <div class="form-group">
                    <label for="zid" class="control-label col-md-3">专业编号</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="zid" id="zid" placeholder="请输入专业编号">
                    </div>
                </div>
<%--学院编号--%>
                    <div class="form-group">
                        <label class="control-label col-md-3">学院编号</label>
                        <div class="col-md-5">
                            <select name="xueyuan.xID" id="xueyuan.xID" class="form-control"></select>
                        </div>
                    </div>

                    <%--专业名称--%>
                    <div class="form-group">
                        <label for="name" class="control-label col-md-3">专业名称</label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" name="zname" id="zname" placeholder="请输入专业名称">
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
<script src="jquery/zhuanye_insert.js"></script>
</body>
</html>
