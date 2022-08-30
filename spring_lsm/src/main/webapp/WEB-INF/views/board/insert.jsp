<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<div class="container">
		<form method="post" class="mt-5" enctype="multipart/form-data">
			<h1>게시글 등록</h1>
			<div class="form-group">
  				<input type="text" class="form-control" name="bd_title" placeholder="제목">
			</div>
			<div class="form-group">
  				<textarea class="form-control" rows="10" name="bd_content" placeholder="내용" id="sn"></textarea>
			</div>
			<div class="form-group">
				<label>첨부파일(최대 3개 선택)</label>
				<input type="file" class="form-control" name="files">
				<input type="file" class="form-control" name="files">
				<input type="file" class="form-control" name="files">
			</div>
			<button class="btn btn-outline-primary col-12 mb-3">게시글 등록</button>
		</form>
	</div>
<script>
//써머노트 -> 이렇게 하지않으면 이미지 용량이 커져서 데이터베이스 용량문제 & 로딩 오래 걸림
$('#sn').summernote({
  placeholder: 'Hello Bootstrap 4',
  tabsize: 2,
  height: 400,
  callbacks: {
	  onImageUpload: function(files) {
		  console.log(files);
	  	let data = new FormData();
	  	data.append('file', files[0]);
	  	let thisObj = $(this)
	  	$.ajax({
	  		data : data,
	  		type : 'POST',
	  		url : '<%=request.getContextPath()%>/board/img/upload',
	  		contentType : false,
	  		processData : false,
	  		dataType : "json",
	  		success : function(data){
	  			let url = '<%=request.getContextPath()%>/simg' + data.url;
	  			thisObj.summernote('insertImage', url);
	  		}
	  	})
	  }
	}
});
</script>
</body>
</html>