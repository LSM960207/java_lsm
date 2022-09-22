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
		<form method="post">
				<h2 class="text-center">Login</h2>
				<div class="form-group">
					<label for="me_email">아이디 : </label>
  				<input type="text" class="form-control" name="me_id" placeholder="아이디">
				</div>
				<div class="form-group">
				<label for="me_pw">비밀번호 : </label>
  				<input type="password" class="form-control" name="me_pw" placeholder="비밀번호">
				</div>
				<div class="form-check">
			  <label class="form-check-label">
			    <input type="checkbox" class="form-check-input" value="true" name="autoLogin">자동로그인
			  </label>
				</div>
				<button class="btn btn-outline-success col-12 mb-3">로그인</button>
			</form>
			<a href="<c:url value="/find?type=id"></c:url>">아이디 찾기</a>/
			<a href="<c:url value="/find?type=pw"></c:url>">비밀번호 찾기</a>
		</div>
</body>
</html>