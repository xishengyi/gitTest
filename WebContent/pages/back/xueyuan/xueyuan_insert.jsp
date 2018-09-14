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
       <h2 class="h2" style="text-align: center">增加学院</h2>
   </div>
            <form action="<%=basePath%>pages/back/xueyuan/xueyuan_insert.action" method="post" class="form-horizontal" id="insertForm">
                <div class="form-group">
                    <label for="xname" class="control-label col-md-3">学院名称</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="xname" id="xname" placeholder="请输入学院名称">
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
<script src="jquery/xueyuan_insert.js"></script>
</body>
</html>
