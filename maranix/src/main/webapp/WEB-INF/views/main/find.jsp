<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.alert{
	position:fixed; top:0; left:0; right:0; bottom:0; 
	background:rgba(0,0,0,0.5); line-height: 100vh; font-size: 40px;
	text-align: center; color:#fff
}
</style>
</head>
<body>
<div class="container">
  <br>
  <h2>아이디 / 비밀번호 찾기</h2>
  <ul class="nav nav-tabs" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" data-toggle="tab" href="#id">아이디찾기</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="tab" href="#pw">비밀번호찾기</a>
    </li>
  </ul>
  <div class="tab-content">
    <div id="id" class="container tab-pane active"><br>
      <h3>아이디 찾기</h3>
      <div class="form-group">
      	<input type="text" name="me_name" class="form-control" placeholder="이름을 입력하세요.">
      </div>
      <div class="form-group">
      	<input type="text" name="me_phone" class="form-control" placeholder="휴대전화번호를 입력하세요.">
      </div>
      <button class="btn btn-success col-12 btn-find-id">확인</button>
    </div>
    <div id="pw" class="container tab-pane fade"><br>
      <h3>비밀번호 찾기</h3>
      <div class="form-group">
      	<input type="text" name="me_id" class="form-control" placeholder="아이디를 입력하세요.">
      </div>
      <div class="form-group">
      	<input type="text" name="me_name" class="form-control" placeholder="이름을 입력하세요.">
      </div>
      <div class="form-group">
      	<input type="text" name="me_email" class="form-control" placeholder="이메일을 입력하세요.">
      </div>
      <button class="btn btn-success col-12 btn-find-pw">확인</button>
    </div>
  </div>
</div>

<script type="text/javascript">
$(function(){
	let type = '${type}';
	$('[href="#'+type+'"]').click();
	
	$('.btn-find-id').click(function(){
		let me_name = $('#id [name=me_name]').val();
		let me_phone = $('#id [name=me_phone]').val();
		let obj = {
				me_name : me_name,
				me_phone : me_phone
		}
		
		if(me_name.trim() == ''){
			alert('이름을 입력하세요.');
			$('#id [name=me_name]').focus();
			return;
		}
		if(me_phone.trim() == ''){
			alert('휴대전화번호를 입력하세요.');
			$('#id [name=me_phone]').focus();
			return;
		}
		$.ajax({
      async:true,
      type:'POST',
      data: JSON.stringify(obj),
      url: '<%=request.getContextPath()%>/find/id',
      dataType:"json", 
      contentType:"application/json; charset=UTF-8",
      success : function(data){
    	  if(data.idList.length == 0){
    		  alert('존재하지 않는 사용자입니다.')
    		  return;
    	  }
    	  let str = '회원님의 아이디는 다음과 같습니다.\n';
      	for(id of data.idList){
      		str += id +'\n';
      	}
      	alert(str);
      }
    });
	})	
	$('.btn-find-pw').click(function(){
		let me_id = $('#pw [name=me_id]').val();
		let me_name = $('#pw [name=me_name]').val();
		let me_email = $('#pw [name=me_email]').val();
		let obj = {
				me_id : me_id,
				me_name : me_name,
				me_email : me_email
		}
		
		if(me_id.trim() == ''){
			alert('아이디를 입력하세요.');
			$('#pw [name=me_id]').focus();
			return;
		}
		if(me_name.trim() == ''){
			alert('이름을 입력하세요.');
			$('#pw [name=me_name]').focus();
			return;
		}
		if(me_email.trim() == ''){
			alert('이메일을 입력하세요.');
			$('#pw [name=me_email]').focus();
			return;
		}
		var str = '<div class="alert" >확인중입니다.</div>';
		$('.container').after(str);
		$.ajax({
      async:true,
      type:'POST',
      data: JSON.stringify(obj),
      url: '<%=request.getContextPath()%>/find/pw',
      dataType:"json", 
      contentType:"application/json; charset=UTF-8",
      success : function(data){
    	  $('.alert').remove();
    	  setTimeout(() => {
	    	  if(data.res){
	    		  alert('메일로 새 비밀번호를 전송했습니다. 확인하세요.');
	    	  }else{
	    		  alert('입력한 정보가 잘못됐거나 없는 회원 정보입니다.');
	    	  }
	    	  if(data.exception){
	    		  alert('서버 문제입니다. 전화로 문의해주세요.')
	    	  }
				}, 100);
      }
    });
	})
})
</script>
</body>
</html>