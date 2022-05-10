<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록</title>
<link href="css/main.css" rel="stylesheet">
</head>
<body>
	<div id="wrap" align="center">
		<h1>영화 등록</h1>
		<form method="post" name="frm" action="moviewrite.do" enctype="multipart/form-data">
			<table>
				<tr>
					<th> 제 목 </th>
					<td><input type="text" name="title" size="60"></td>
				</tr>
				<tr>
					<th> 가 격 </th>
					<td><input type="text" name="price" size="60"> 원</td>
				</tr>
				<tr>
					<th> 감 독 </th>
					<td><input type="text" name="director" size="60"></td>
				</tr>
				<tr>
					<th> 설 명 </th>
					<td><textarea cols="70" rows="10" name="synopsis"></textarea></td>
				</tr>
				<tr>
					<th> 포스터 </th>
					<td><input type="file" name="poster"></td>
				</tr>
			</table>
			<hr>
			<input type="submit" value="확인">
			<input type="reset" value="초기화">
			<input type="button" value="목록" onclick="location.href='movieList.do'">
		</form>
	</div>
</body>
</html>