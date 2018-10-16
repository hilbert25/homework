<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<!-- <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css"> -->
<style>
.bg {
	background: rgba(222, 233, 244, 0.8);
	min-height: 1000px;
	text-align: center;
	padding-top: 100px;
}

.title {
	font-size: 16px;
	color: #070606;
	text-align: center;
	font-weight: 400;
}

.button {
	width: 100px;
	height: 30px;
	background: #4db1e9;
	border: none;
	border-radius: 4px;
	color: #fff;
	margin-top: 30px;
}

.box {
	width: 662px;
	background-color: rgba(255, 255, 255, 0.5);
	padding: 10px;
	box-sizing: border-box;
	margin: 120px auto;
	z-index: 200;
}

.box-content {
	width: 642px;
	min-height: 348px;
	padding: 46px 157px 46px 157px;
	box-sizing: border-box;
	background-color: #fff;
	position: relative;
}

.name {
	display: inline-block;
	position: absolute;
	top: 0;
	left: 0;
	width: 328px;
	height: 44px;
	border: none;
	outline: none;
	padding-left: 16px;
	box-sizing: border-box;
	background-color: rgba(241, 242, 244, 0.8);
	color: #333 !important;
}

.form {
	position: relative;
	margin-top: 20px;
}

.login-box {
	
}

.login-btn {
	display: inline-block;
	width: 328px;
	height: 44px;
	border: none;
	outline: none;
	background-color: #3388FF;
	color: #fff;
	font-size: 16px;
	margin-top: 14px;
	cursor: pointer;
	position: absolute;
	top: 50px;
	left: 0;
}

.info {
	color: #9098A4;
	font-size: 14px;
	margin-top: 10px;
	text-align: left;
	position: absolute;
	top: 150px;
	left: 0;
}
</style>


<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/fingerprintjs2/1.8.1/fingerprint2.min.js"></script>

</head>
<body>
	<div class="bg">
		<div class="box">
			<div class="box-content">
				<div class="title">感谢参与！</div>
			</div>
		</div>
	</div>

</body>
</html>