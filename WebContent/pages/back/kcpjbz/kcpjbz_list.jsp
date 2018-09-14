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
        <table class="table table-bordered table-hover" id="kcpjbzTable">
            <tr>
            	<th class="text-center"><input type="checkbox" name="selall2" id="selall2"></th>
                <th width="100" class="text-center">单元编号</th>
                <th width="100" class="text-center">单元名称</th>
               <th width="100" class="text-center">单元目标</th>
               <th width="100" class="text-center">学习目标</th>
               <th width="100" class="text-center">考核方式</th>
               <th width="100" class="text-center">评价标准</th>
               <th width="100" class="text-center">权重</th>
               <th width="100" class="text-center">实际达成度</th>
      
                <th class="text-center">操作</th>
            </tr>
        </table>
    <button class="btn btn-danger btn-sm" id="deleteBtn12">批量删除</button>
        <div class="text-right">
            <ul class="pagination pagination-sm" id="pagecontrol"></ul>
        </div>
        <div class="alert alert-success" id="alertDiv0" style="display: none">
            <button class="close" data-dismiss="alert">&times;</button>
            <span id="alertText0"></span>
        </div>
    </div>

<div class="modal" id="kcpjbzInfo">
        <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-header">
                  <button class="close" data-dismiss="modal">&times;</button>
                  <h3 class="modal-title">修改课程评价标准</h3>
              </div>
              <div class="modal-body">
                  <form method="post" class="form-horizontal" id="updateForm">
                       <%--教师编号--%>
                <div class="form-group">
                    <label for="uid" class="control-label col-md-3">单元编号</label>
                    <div class="col-md-5">
                        <span id="uuid"></span>
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




	<div id="chaxun" class="form-group">
		<label for="uname">查询单元名称</label>
		<input type="text" class="form-control" name="uname" id="keyword" placeholder="请输入要查询的单元名称">
	</div>
	<button  class="btn btn-success btn-sm" id="query" name="query">查询</button>

</div>




<jsp:include page="/pages/footer.jsp"/>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/additional-methods.min.js"></script>
<script src="jquery/jquery.metadata.js"></script>
<script src="jquery/Message_zh_CN.js"></script>
<script src="jquery/util.js"></script>
<script src="jquery/kcpjbz_list.js"></script>
</body>
</html>
