<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet/less" type="text/css" href="/dist/css/index.less">
<link rel="stylesheet" type="text/css" href="/dist/css/bootstrap.css">
<link rel="stylesheet" href="/font-awesome/css/font-awesome.css">
</head>
<body>









	<!-- 左边部分 -->
	<div class="aside">
		<!-- 左上部分 -->
		<div class="profile">
			<div class="avatar">
				<img src="C:/Users/86188/eclipse-workspace/sqldemo/src/main/resources/static/images/1.jpg" class="img-circle">
			</div>
			<h4>模型仓库</h4>
		</div>
		<!-- 左下部分 -->
		<div class="menu">
        <ul>
          <li><a href="javascript:;">查看项目</a></li>
          <li><a href="javascript:;">项目管理</a></li>
        </ul>
    </div>
	
	</div>
	<!-- 右边部分 -->
	<div class="main">
		<!-- 右上部分 -->
		<div class="header">
			<nav class="navbar navbar-default">
        <div class="container-fluid">
          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            
            <a class="navbar-brand" href="#">模型仓库</a>
          </div>

          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            
            
            <ul class="nav navbar-nav navbar-right">
              <li><a href="#"><span class="fa fa-user"></span>个人中心</a></li>
              <li><a href="#"><span class="fa fa-sign-out"></span>退出</a></li>
              
              
            </ul>
          </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
      </nav>

		</div>



		<!-- 右下部分 -->
		<div class="body">
        <!-- 路径导航 -->
       <ol class="breadcrumb">
        <li><a href="#">查看项目</a></li>
        <li>模型列表</li>
        
        </ol>

      <!-- 面板 添加模型-->
    <div class="panel panel-default">
        
        <div class="panel-body">
          <button class="btn btn-success btn-sm pull-right"style="margin-left:20px">导出模型</button>
          <button class="btn btn-success btn-sm pull-right">添加模型</button>
          
          <div class="col-lg-3">
            <div class="input-group input-group-sm">
            <input type="text" class="form-control" placeholder="Search for...">
              <span class="input-group-btn">
                <button class="btn btn-success" type="button">搜索</button>
              </span>
            </div><!-- /input-group -->
          </div><!-- /.col-lg-6 -->
        </div>

    </div>
      <!-- 面板 搜索框 -->
        <div class="panel panel-default">
        
        <table class="table table-bordered">
           <thead>
            <th>At</th>
            <th>Name</th>
            <th>EventID</th>
            <th>FlowtriggerID</th>
            <th>occurrence</th>
            <th>attached</th>
          </thead> 
          <!-- <tbody>
            <tr >
              <td >${list}</td>
              <td>hkkk</td>
              <td>7.8-12.12</td>
              <td>
                <a href="#" class="btn btn-info btn-xs">查看</a>
                <a href="#"class="btn btn-info btn-xs"class="btn btn-info btn-xs">修改</a>
                <a href="#"class="btn btn-warning btn-xs">删除</a>
              </td>
            </tr>
            <tr>
              <td>model storger</td>
              <td>hkkk</td>
              <td>7.8-12.12</td>
              <td>
                <a href="#" class="btn btn-info btn-xs">查看</a>
                <a href="#"class="btn btn-info btn-xs"class="btn btn-info btn-xs">修改</a>
                <a href="#"class="btn btn-warning btn-xs">删除</a>
              </td>
            </tr>
            <tr>
              <td>model storger</td>
              <td>hkkk</td>
              <td>7.8-12.12</td>
              <td>
                <a href="#" class="btn btn-info btn-xs">查看</a>
                <a href="#"class="btn btn-info btn-xs"class="btn btn-info btn-xs">修改</a>
                <a href="#"class="btn btn-warning btn-xs">删除</a>
              </td>
            </tr>
          </tbody> -->
          <c:forEach items="${list}" var="item">
            <tr>
              <td>"${item.at}"</td>
              <td>"${item.name}"</td>
              <td>"${item.eventid}"</td>
              <td>"${item.flowtriggerid}"</td>
              <td>"${item.occurrence}"</td>
              <td>"${item.attached}"</td>
            </tr>
          </c:forEach>
          

        </table>
      </div>

    </div>
	</div>
	<script src="/dist/js/less.js"></script>
</body>
</html>