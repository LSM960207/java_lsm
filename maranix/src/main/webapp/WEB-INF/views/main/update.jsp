<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>
<style>
.error{
	color:red;
}
</style>

</head>
<body>
	<div class="container">
		<form action="<%=request.getContextPath()%>/update" method="post">
			<h1 class="text-center">회원정보수정</h1>
			<div class="form-group">
			  <label for="me_id">아이디:</label>
			  <input type="text" class="form-control" id="me_id" name="me_id" value="${user.me_id }" readonly>
			</div>
			<div class="form-group">
			  <label for="me_pw">비밀번호:</label>
			  <input type="password" class="form-control" id="me_pw" name="me_pw" value="">
			</div>
			<div class="form-group">
			  <label for="me_pw2">비밀번호 확인:</label>
			  <input type="password" class="form-control" id="me_pw2" name="me_pw2" value="">
			</div>
			<div class="form-group">
			  <label for="me_name">이름</label>
			  <input type="text" class="form-control" id="me_name" name="me_name" value="${user.me_name }">
			</div>
			<div class="form-group">
			  <label for="me_birth">휴대전화</label>
			  <input type="text" class="form-control" id="me_phone" name="me_phone" value="${user.me_phone }">
			</div>
			<div class="form-group">
			  <label for="me_email">이메일</label>
			  <input type="text" class="form-control" id="me_email" name="me_email" value="${user.me_email }">
			</div>
			<button class="btn btn-outline-success col-12 mb-5">회원정수정</button>
		</form>
	</div>
	<script type="text/javascript">	
		$(function(){
    	$("form").validate({
        rules: {
          me_id: {
          },
          me_pw: {
          },
          me_pw2: {
            equalTo : me_pw
          },
          me_name: {
            required : true
          },
          me_phone: {
        	  required : true
          },
          me_email: {
            required : true,
            email : true
          }
        },
        //규칙체크 실패시 출력될 메시지
        messages : {
          me_id: {
          },
          me_pw: {
          },
          me_pw2: {
            equalTo : "비밀번호와 비밀번호 확인이 일치하지 않습니다."
          },
          me_name: {
        	  required : "필수항목입니다."
          },
          me_phone: {
        	  required : "필수항목입니다."
          },
          me_email: {
        	  required : "필수항목입니다.",
        	  email : "이메일 형식에 맞지 않습니다."
          }
        },
        submitHandler: function(form) {
        	let pw = $('[name=me_pw]').val();
        	if(pw != '')
        		return true;
        	if(confirm('비밀번호를 입력하지 않으면 기존 비밀번호가 유지됩니다. 회원정보를 수정하겠습니까?')){
        		return true;
        	}
        	$('[name=me_pw]').focus();
          return false;
        }
    	});
		})
		$.validator.addMethod(
	    "regex",
	    function(value, element, regexp) {
	        var re = new RegExp(regexp);
	        return this.optional(element) || re.test(value);
	    },
	    "Please check your input."
		);
		
	</script>
</body>
</html>