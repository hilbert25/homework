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
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->

<link rel="stylesheet" href="./page/assets/css/style.css">
<script src="./page/assets/js/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/fingerprintjs2/1.8.1/fingerprint2.min.js"></script>
</head>
<body>
	<!-- [if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="#">upgrade your browser</a> to improve your experience.</p>
        <![endif] -->

	<div>

		<div class="title">
			信息安全工程第<font size="30" color="red">${courseIndex}</font>次课程作业提交 <br>本次作业的内容是：<font
				size="30" color="black">${courseHomeWork}</font>
		</div>
		<br></br>
		<div class="content">
			<form action="uploadFile" method="post" enctype="multipart/form-data">
				<div class="module">
					姓名：<input type="text" placeholder="请输入姓名" name="stuName">
				</div>
				<div class="module">
					学号：<input type="text" placeholder="请输入学号" name="stuId">
				</div>
				<div class="upload ">
					<a href='javascript:void(0);' class="blueButton">选择文件</a> <input
						type="file" class="myFileUpload" name="image"
						accept="application/msword,application/pdf,application/vnd.openxmlformats-officedocument.wordprocessingml.document" />
					<p class="upload_info"
						style="position: absolute; top: 10%; left: 40%; font-size: 18px;">(仅限doc
						docx pdf)</p>
					<div class="show"></div>
				</div>
				<div class="module">
					<input type="text" value="123" name="fingerPrint" id="fingerPrint">
				</div>
				<div class="module">
					<button type="submit">提交</button>
					<div class="warnning">作业提交截止时间是:</div>
					<a class="warnning" href="search">查询我的提交记录</a>
				</div>
			</form>
		</div>

	</div>

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

		if (window.requestIdleCallback) {
			requestIdleCallback(function() {
				new Fingerprint2().get(function(result, components) {
					fingerPrint = JSON.stringify(components);
					//console.log(typeof (result)) // a hash, representing your device fingerprint
					//console.log(JSON.stringify(components)) // an array of FP components
					//console.log(fingerPrint);
					console.log(fingerPrint);
					document.getElementById("fingerPrint").value = fingerPrint;
					senFingerPrint(fingerPrint);
				})
			})
		} else {
			setTimeout(function() {
				new Fingerprint2().get(function(result, components) {

				})
			}, 500)
		}
		function senFingerPrint(fingerPrint) {
			$.ajax({
				url : "http://localhost:8080/homework/test",
				type : "POST",
				dataType : "json",
				data : {
					"fingerPrint" : fingerPrint
				},
				async : false,
				success : function(data) {
					//alert("success");
					//$.each(data, function(index, element) {
					//alert(element.a);
					//alert(element.b);
					//alert(element.c);
					//});
				},
				error : function() {

				}
			});
		}
	</script>
</body>

</html>