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
       <h2 class="h2" style="text-align: center">增加验收标准</h2>
   </div>
            <form action="<%=basePath%>pages/back/yanshou/yanshou_insert.action" method="post" class="form-horizontal" id="insertForm">
                <%--验收标准编号--%>
                <div class="form-group">
                    <label for="ysid" class="control-label col-md-3">验收标准编号</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="ysid" id="ysid" placeholder="请输入验收标准编号">
                    </div>
                </div>
<%--毕业要求编号--%>
                    <div class="form-group">
                        <label class="control-label col-md-3">毕业要求编号</label>
                        <div class="col-md-5">
                            <select name="biye.byid" id="biye.byid" class="form-control"></select>
                        </div>
                    </div>

                    <%--标准层级--%>
                    <div class="form-group">
                        <label for="bzcj" class="control-label col-md-3">标准层级</label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" name="bzcj" id="bzcj" placeholder="请输入标准层级">
                        </div>
                    </div>

					<%--层内编号--%>
                    <div class="form-group">
                        <label for="cnbh" class="control-label col-md-3">层内编号</label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" name="cnbh" id="cnbh" placeholder="请输入层内编号">
                        </div>
                    </div>
                    <%--标准内容--%>
                    <div class="form-group">
                        <label for="bznr" class="control-label col-md-3">标准内容</label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" name="bznr" id="bznr" placeholder="请输入标准内容">
                        </div>
                    </div>
                    <%--上一层级ID--%>
                    <div class="form-group">
                        <label for="sjid" class="control-label col-md-3">上一层级编号</label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" name="sjid" id="sjid" placeholder="请输入上一层级编号">
                        </div>
                    </div>
                    <%--掌握程度--%>
                    <div class="form-group">
                        <label for="zwcd" class="control-label col-md-3">掌握程度</label>
                        <div class="col-md-5">
                            <input type="text" class="form-control" name="zwcd" id="zwcd" placeholder="请输入掌握程度">
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
<script src="jquery/yanshou_insert.js"></script>
</body>
</html>
