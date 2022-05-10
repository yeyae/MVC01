<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 정보 수정</title>
<link href="css/main.css" rel="stylesheet">
</head>
<body>
<div id="wrap" align="center">
	<h1>정보 수정</h1>
	<form method="post" action="movieupdate.do" enctype="multipart/form-data">
		<input type="hidden" name="code" value="${movie.code }">
		<table>
			<tr>
				<td>
					<c:choose>
					<c:when test="${empty movie.poster}">
						<img src="images/noimage.gif"><%-- 이미지가 없음 --%>					
					</c:when>
					<c:otherwise>
						<img src="images/${movie.poster }" width="200" height="300"><%-- 이미지가 있음 --%>
					</c:otherwise>
					</c:choose>
				</td>
				<td>
					<table>
						<tr>
							<th style="width:80px">제목</th>
							<td><input type="text" name="title" value="${movie.title }" size="80"></td>
						</tr>
						<tr>
							<th>가격</th>
							<td><input type="text" name="price" value="${movie.price }" > 원</td>
						</tr>
						<tr>
							<th>감독</th>
							<td><input type="text" name="director" value="${movie.director }" size="80"></td>
						</tr>
						<tr>
							<th>시놉시스</th>
							<td><textarea cols="70" rows="10" name="synopsis">${movie.synopsis }</textarea></td>
						</tr>
						<tr>
							<th>사진</th>
							<td>
								<input type="file" name="poster"><br>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<hr>
		<input type="submit" value="수정">
		<input type="button" value="목록" onclick="location.href='movieList.do'">
	</form>
</div>
</body>
</html>