<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
 <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>
<div class="container">
		<form method="post">
			<h1 class="text-center">회원가입</h1>
			<div class="form-group">
  			<label for="me_id">아이디:</label>
  			<input type="text" class="form-control" id="me_id" name="me_id">
			</div>
			<div class="form-group">
  			<label for="me_pw">비밀번호:</label>
  			<input type="password" class="form-control" id="me_pw" name="me_pw">
			</div>
			<div class="form-group">
  			<label for="me_pw2">비밀번호 확인:</label>
  			<input type="password" class="form-control" id="me_pw2" name="me_pw2">
			</div>
		<div class="form-group">
			<label>성별:</label>
		</div>
			<div class="form-group">
				<div class="form-check-inline">
  				<label class="form-check-label">
    				<input type="radio" class="form-check-input" name="me_gender" value="M">남성
  				</label>
				</div>
				<div class="form-check-inline">
  				<label class="form-check-label">
    				<input type="radio" class="form-check-input" name="me_gender" value="F">여성
  				</label>
				</div>
			</div>
			<div class="form-group">
  			<label for="me_email">이메일:</label>
  				<input type="text" class="form-control" id="me_email" name="me_email">
			</div>
			<div class="form-group">
  			<label for="me_birth">생년월일:</label>
  				<input type="text" class="form-control" id="me_birth" name="me_birth">
			</div>
			<button class="btn btn-outline-success col-12 mb-5">회원가입</button>
		</form>
	</div>

