<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
%>
<html lang="zh">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>优乐在线教育学生管理系统（WWW.YLCTO.CN）</title>
    <link href="js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="js/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="js/dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="js/morrisjs/morris.css" rel="stylesheet">
    <link href="js/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>

<div id="wrapper">
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">学生管理系统</a>
        </div>
       
        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> 用户信息</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> 设置</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="<%=basePath%>pages/back/admin_logout.action"><i class="fa fa-sign-out fa-fw"></i> 注销</a>
                    </li>
                </ul>
            </li>
        </ul>
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="<%=basePath%>pages/back/index.jsp"><i class="fa fa-dashboard fa-fw"></i> 优乐在线教育</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 班级管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="<%=basePath%>pages/back/classes/classes_insert.jsp">增加班级</a>
                            </li>
                            <li>
                                <a href="<%=basePath%>pages/back/classes/classes_list.jsp">班级列表</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-edit fa-fw"></i> 学生管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="<%=basePath%>pages/back/student/student_insert.jsp">增加学生</a>
                            </li>
                            <li>
                                <a href="<%=basePath%>pages/back/student/student_list.jsp">学生列表</a>
                            </li>
                        </ul>
                    </li>
                     <li>
                        <a href="#"><i class="fa fa-edit fa-fw"></i> 标记管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="<%=basePath%>pages/back/note/note_insert.jsp">增加标记</a>
                            </li>
                            <li>
                                <a href="<%=basePath%>pages/back/note/note_list.jsp">标记列表</a>
                            </li>
                        </ul>
                    </li>
                     <li>
                        <a href="#"><i class="fa fa-edit fa-fw"></i> 学院管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="<%=basePath%>pages/back/xueyuan/xueyuan_insert.jsp">增加学院</a>
                            </li>
                            <li>
                                <a href="<%=basePath%>pages/back/xueyuan/xueyuan_list.jsp">学院列表</a>
                            </li>
                        </ul>
                    </li>
                     <li>
                        <a href="#"><i class="fa fa-edit fa-fw"></i> 专业管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="<%=basePath%>pages/back/zhuanye/zhuanye_insert.jsp">增加专业</a>
                            </li>
                            <li>
                                <a href="<%=basePath%>pages/back/zhuanye/zhuanye_list.jsp">专业列表</a>
                            </li>
                        </ul>
                    </li>
                     <li>
                        <a href="#"><i class="fa fa-edit fa-fw"></i> 毕业要求管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="<%=basePath%>pages/back/biye/biye_insert.jsp">增加毕业要求</a>
                            </li>
                            <li>
                                <a href="<%=basePath%>pages/back/biye/biye_list.jsp">毕业要求列表</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-edit fa-fw"></i> 验收标准管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="<%=basePath%>pages/back/yanshou/yanshou_insert.jsp">增加验收标准</a>
                            </li>
                            <li>
                                <a href="<%=basePath%>pages/back/yanshou/yanshou_list.jsp">验收标准列表</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-edit fa-fw"></i> 教师信息管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="<%=basePath%>pages/back/teacher/teacher_insert.jsp">增加教师信息</a>
                            </li>
                            <li>
                                <a href="<%=basePath%>pages/back/teacher/teacher_list.jsp">教师信息列表</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-edit fa-fw"></i> 课程信息管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="<%=basePath%>pages/back/course/course_insert.jsp">增加课程信息</a>
                            </li>
                            <li>
                                <a href="<%=basePath%>pages/back/course/course_list.jsp">课程信息列表</a>
                            </li>
                        </ul>
                    </li>
                     <li>
                        <a href="#"><i class="fa fa-edit fa-fw"></i> 课程评价标准管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="<%=basePath%>pages/back/kcpjbz/kcpjbz_insert.jsp">增加课程评价标准</a>
                            </li>
                            <li>
                                <a href="<%=basePath%>pages/back/kcpjbz/kcpjbz_list.jsp">课程评价标准列表</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        
    </nav></div>