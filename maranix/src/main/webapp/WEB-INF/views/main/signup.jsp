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
			<h1 class="text-center">회원가입</h1>
			<div class="form-group">
  			<label for="me_id">아이디 : </label>
  			<input type="text" class="form-control col-12" id="me_id" name="me_id">
  			<label id="me_id-error" class="error" for="me_id"></label>
  			<button type="button" class="btn btn-outline-success col-12" id="idCheck">아이디 중복확인</button>
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
  				<input type="text" class="form-control" id="me_name" name="me_name">
			</div>
			<div class="form-group">
  			<label for="me_phone">휴대전화 : </label>
  				<input type="text" class="form-control" id="me_phone" name="me_phone">
			</div>
			<div class="form-group">
  			<label for="me_email">이메일 : </label>
  			<input type="text" class="form-control" id="me_email" name="me_email">
			</div>
			<button class="btn btn-outline-success col-12 mb-5">회원가입</button>
		</form>
	</div>
<script type="text/javascript">
$(function(){
 	$("form").validate({
     rules: {
    	 me_id: 	{	required : true       },
       me_pw: 	{	required : true       },
       me_pw2: 	{
         required : true,
         equalTo : me_pw
       },
       me_name : {
    	   required : true
       },
       me_phone : { required : true},
       me_email: {
         required : true,
         email : true
       }
     },
     //규칙체크 실패시 출력될 메시지
     messages : {
    	 me_id: { required : "필수항목입니다."},
       me_pw: {	  required : "필수항목입니다."      },
       me_pw2: {
     	  required : "필수항목입니다.",
         equalTo : "비밀번호와 비밀번호 확인이 일치하지 않습니다."
       },
       me_name : {
    	   required : "필수항목입니다.",
       },
       me_email: {
     	  required : "필수항목입니다.",
     	  email : "이메일 형식에 맞지 않습니다."
       },
       me_phone: { required : "필수항목입니다."      }
    },
    submitHandler: function(form) {
     	if(!idCheck){
				$('#me_id-error').text('이미 사용중인 아이디입니다.').show();
				$('#me_id').focus();
				return false;
			}  
     	return true;
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

function ajaxPost(async, dataObj, url, success){
	$.ajax({
	  async:async,
	  type:'POST',
	  data:JSON.stringify(dataObj),
	  url:"<%=request.getContextPath()%>"+url,
	  dataType:"json",
	  contentType:"application/json; charset=UTF-8",
	  success : function(data){
		  success(data);
	  }
  });
}

$.ajax({
    async:false,
    type:'POST',
    data: JSON.stringify(obj),
    url: '<%=request.getContextPath()%>/id/check',
    dataType:"json", 
    contentType:"application/json; charset=UTF-8",
    success : function(data){
    	if(data){
    		alert('가입 가능한 아이디입니다.');
    		idCheck = true;
    	}else{
    		alert('이미 사용중이거나 탈퇴한 아이디입니다.');
    	}
    }
    });
	})
	$('[name=me_id]').change(function(){
		idCheck = false;
	})
	
	$('form').submit(function(){
		if(!idCheck){
			alert('아이디 중복 검사를 하세요.');
			return false;
		}
	})
})

let idCheck = false;
</script>
</body>
</html>