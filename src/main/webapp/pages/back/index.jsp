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
    当前管理员ID:<%=request.getSession().getAttribute("email")%>
    上次登录日期:<%=request.getSession().getAttribute("lastdate")%>
</div>

<jsp:include page="/pages/footer.jsp"/>
</body>
</html>
