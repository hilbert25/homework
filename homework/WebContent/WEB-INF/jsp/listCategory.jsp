<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table align='center' border='1' cellspacing='0'>
	<tr>
		<td>id</td>
		<td>name</td>
	</tr>
	<c:forEach items="${cs}" var="c" varStatus="st">
		<tr>
			<td>${c.stuId}</td>
			<td>${c.stuName}</td>

		</tr>
	</c:forEach>
</table>
<form action="uploadFile" method="post" enctype="multipart/form-data">
	选择图片:<input type="file" name="image"
		accept="application/msword,application/pdf,application/vnd.openxmlformats-officedocument.wordprocessingml.document" />
	<br> <input type="submit" value="上传"> 姓名： <input
		type="text" name="stuName"></input> 学号：<input type="text" name="stuId"></input>
</form>