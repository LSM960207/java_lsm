<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<h1>게시글 등록</h1>
		<form method="post">  
 			<div class="form-group">
  			<label for="bd_title">제목:</label>
  			<input type="text" class="form-control" name="bd_title" id="bd_title">
			</div>
			<div class="form-group">
 		 		<label for="bd_content">내용:</label>
 		 		<textarea class="form-control" rows="10" name="bd_content" id="bd_content"></textarea>
			</div>
			<button class="btn btn-outline-success col-12 mb-5">게시글 등록</button>
		</form>
	</div>
</body>
</html>