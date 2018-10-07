<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- [if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif] -->
<!-- [if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif] -->
<!-- [if IE 8]>         <html class="no-js lt-ie9"> <![endif] -->
<!-- [if gt IE 8]><! -->
<html class="no-js">
<!-- <![endif] -->

<head>
<meta charset="utf-8">
</meta>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
</meta>

<title></title>

<meta name="description" content="">
</meta>

<meta name="viewport" content="width=device-width, initial-scale=1">
</meta>
<base href=" <%=basePath%>">
<link rel="stylesheet" href="./page/assets/css/style.css">
<script src="./page/assets/js/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</head>

<body>
	<!-- [if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="#">upgrade your browser</a> to improve your experience.</p>
        <![endif] -->

	<div class="wrap">

		<div class="title">信息安全工程 课程作业查询</div>

		<div class="content">
			<form action="searchMyHomeWork" method="post"
				enctype="multipart/form-data">
				<div class="module">
					姓名：<input type="text" placeholder="请输入姓名" name="stuName">
				</div>
				<div class="module">
					学号：<input type="text" placeholder="请输入学号" name="stuId">
				</div>
				<div class="module">
					<button type="submit">提交</button>
				</div>
			</form>
		</div>

	</div>
	<table align='center' border='1' cellspacing='0' class="table">
		<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>标题</td>
			<td>提交时间</td>
		</tr>
		<c:forEach items="${cs}" var="c" varStatus="st">
			<c:choose>
				<c:when test="${st.index%2 == 0}">
					<tr class="success">
						<td>${c.stuId}</td>
						<td>${c.stuName}</td>
						<td>${c.homeWorkTitle}</td>
						<td>${c.homeWorkSubmitTime}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr class="info">
						<td>${c.stuId}</td>
						<td>${c.stuName}</td>
						<td>${c.homeWorkTitle}</td>
						<td>${c.homeWorkSubmitTime}</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table>
	<script>
		$(document)
				.ready(
						function() {
							$(".myFileUpload").change(function() {
								var arrs = $(this).val().split('\\');
								var filename = arrs[arrs.length - 1];
								$(".show").html(filename);
							});
							$(function() {
								$(".search input[type=text]")
										.change(
												function() {
													var searchText = $(this)
															.val(); //获取输入的搜索内容
													var $searchLi = ""; //预备对象，用于存储匹配出的li

													if (searchText != "") {

														//获取所有匹配的li
														$searchLi = $(
																"#content_news_list")
																.find(
																		'a:contains('
																				+ searchText
																				+ ')')
																.parent();
														//将内容清空
														$("#content_news_list")
																.html("");
													}

													//将获取的元素追加到列表中
													$("#content_news_list")
															.html($searchLi)
															.clone();

													//判断搜索内容是否有效，若无效，输出not find
													if ($searchLi.length <= 0) {
														$("#content_news_list")
																.html(
																		"<li>not find</li>")
													}
												})

								$("input[type=submit]").click(function() {
									$("searchText").change();
								})
							})
						})
	</script>
</body>

</html>