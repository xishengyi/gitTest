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
        <table class="table table-bordered table-hover" id="xueyuanTable">
            <tr>
            	<th class="text-center"><input type="checkbox" name="selall2" id="selall2"></th>
                <th width="100" class="text-center">学院编号</th>
                <th width="100" class="text-center">学院名称</th>
                
                <th class="text-center">操作</th>
            </tr>
        </table>
    <button class="btn btn-danger btn-sm" id="deleteBtn2">批量删除</button>
        <div class="text-right">
            <ul class="pagination pagination-sm" id="pagecontrol"></ul>
        </div>
        <div class="alert alert-success" id="alertDiv1" style="display: none">
            <button class="close" data-dismiss="alert">&times;</button>
            <span id="alertText1"></span>
        </div>
    </div>

<div class="modal" id="xueyInfo">
        <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-header">
                  <button class="close" data-dismiss="modal">&times;</button>
                  <h3 class="modal-title">修改学院信息</h3>
              </div>
              <div class="modal-body">
                  <form method="post" class="form-horizontal" id="updateForm">
                      <%--学院编号--%>
                      <div class="form-group">
                          <label class="control-label col-md-3">学院编号</label>
                          <div class="col-md-5">
                              <span id="xID"></span>
                          </div>
                      </div>
                      

                      <%--学院名称--%>
                      <div class="form-group">
                          <label for="xname" class="control-label col-md-3">学院名称</label>
                          <div class="col-md-5">
                              <input type="text" class="form-control" name="xname" id="xname" placeholder="请输入学院名称">
                          </div>
                      </div>


                      

                     

                      <div class="form-group">
                          <div class="col-md-4 col-md-offset-6">
                            
                              <button type="submit" class="btn btn-success btn-sm">修改</button>
                          </div>
                      </div>
                  </form>
              </div>
              <div class="modal-footer">
                  <button class="btn btn-success btn-sm" data-dismiss="modal">关闭编辑窗口</button>
              </div>
          </div>
        </div>
    </div>
</div>



<jsp:include page="/pages/footer.jsp"/>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/additional-methods.min.js"></script>
<script src="jquery/jquery.metadata.js"></script>
<script src="jquery/Message_zh_CN.js"></script>
<script src="jquery/util.js"></script>
<script src="jquery/xueyuan_list.js"></script>
</body>
</html>
