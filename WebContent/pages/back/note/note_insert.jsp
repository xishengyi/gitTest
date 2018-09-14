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
       <h2 class="h2" style="text-align: center">增加标记</h2>
   </div>
            <form action="<%=basePath%>pages/back/note/note_insert.action" method="post" class="form-horizontal" id="insertForm">
                <%--标记编号
                <div class="form-group">
                    <label for="id" class="control-label col-md-3">标记编号</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="id" id="id" placeholder="请输入标记编号">
                    </div>
                </div>--%>
                <div class="form-group">
                    <label for="name" class="control-label col-md-3">标记名称</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="name" id="name" placeholder="请输入标记名称">
                    </div>
                </div>
                <div class="form-group">
                    <label for="note" class="control-label col-md-3">标记简介</label>
                    <div class="col-md-5">
                       <textarea class="form-control" name="note" id="note" placeholder="请输入标记简介"></textarea>
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
</div>

<jsp:include page="/pages/footer.jsp"/>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/additional-methods.min.js"></script>
<script src="jquery/jquery.metadata.js"></script>
<script src="jquery/Message_zh_CN.js"></script>
<script src="jquery/note_insert.js"></script>
</body>
</html>
