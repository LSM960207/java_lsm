<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
.error{
	color: red;
}
</style>
</head>
<body>
	<div class="container">
		<form action="<%=request.getContextPath()%>/signup" method="post">
			<h1 class="text-center">회원 정보 수정</h1>
			<div class="form-group">
  			<label for="me_id">아이디 : </label>
  			<input type="text" class="form-control" id="me_id" name="me_id" readonly>
			</div>
			<div class="form-group">
  			<label for="me_pw">비밀번호 : </label>
  			<input type="password" class="form-control" id="me_pw" name="me_pw">
			</div>
			<div class="form-group">
  			<label for="me_pw2">비밀번호 확인 : </label>
  			<input type="password" class="form-control" id="me_pw2" name="me_pw2">
			</div>
			<div class="form-group">
  			<label for="me_name">이름 : </label>
  				<input type="text" class="form-control" id="me_name" name="me_name" readonly>
			</div>
			<div class="form-group">
  			<label for="me_phone">휴대전화 : </label>
  				<input type="text" class="form-control" id="me_phone" name="me_phone">
			</div>
			<div class="form-group">
				<div class="form-check-inline">
  				<label class="form-check-label">
    				<input type="radio" class="form-check-input"  value="Y">수신함
  				</label>
				</div>
				<div class="form-check-inline">
  				<label class="form-check-label">
    				<input type="radio" class="form-check-input"  value="N">수신안함
  				</label>
				</div>
			</div>
			<div class="form-group">
  			<label for="me_email">이메일 : </label>
  			<input type="text" class="form-control" id="me_email" name="me_email">
  			<label id="me_email-error" class="error" for="me_email"></label>
			</div>
			<div class="form-group">
				<div class="form-check-inline">
  				<label class="form-check-label">
    				<input type="radio" class="form-check-input"  value="Y">수신함
  				</label>
				</div>
				<div class="form-check-inline">
  				<label class="form-check-label">
    				<input type="radio" class="form-check-input"  value="N">수신안함
  				</label>
				</div>
			</div>
			<button class="btn btn-outline-success col-12 mb-5">회원 정보 수정</button>
		</form>
	</div>
</body>
</html>