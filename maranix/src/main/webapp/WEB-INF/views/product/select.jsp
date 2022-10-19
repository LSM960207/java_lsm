<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
[name=file]{
	display: none;
}
.box-thumb{
	width: 400px; height: 400px; border:1px solid red;
	text-align: center; font-size : 50px; line-height: 148px;
	cursor: pointer; box-sizing: border-box;
}
.fa-regular{
	line-height: 1;
}
.display-none{
	display: none;
}
.likes{
	color : red; cursor: pointer;
}
.table {
	margin-bottom: 10px;
}
.option {
	margin-bottom: 10px;
}

</style>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
<div class="container">
	<div class="clearfix">
		<div class="float-left" style="width:auto; height: auto">
			<img id="preview" width="400" height="400" src="<c:url value="${p.pr_thumb_url}"></c:url>">
		</div>
		<div class="float-right" style="width:calc(100% - 400px - 10px)">
			<div class="form-group">
	  		<input type="text" class="form-control" value="${p.pr_title }" readonly>
	  		<input type = "hidden" name="pr_code" id="pr_code" value="${p.pr_code }">
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" id="pr_price" name="pr_price" value="${p.pr_price}" readonly>
			</div>
			<table class="table">
				<thead>
					<tr>
		       	<th>국내/해외배송</th>
		       	<th>국내배송</th>
		     	</tr>
				</thead>
				<tbody>
					<tr>
		        <td>배송방법</td>
		        <td>택배</td>
		      </tr>
		      <tr>
		        <td>배송비</td>
		        <td>3,000원</td>
		      </tr>
				</tbody>
			</table>
				<select class="form-control option" name="po_name" id="po_name">
			  		<option value="0">- [필수] 옵션을 선택하세요. -</option>
			  			<c:forEach items="${optionList}" var="po">
			  				<option value="${po.po_num}">${po.po_name}</option>
			  			</c:forEach>
			  	</select>
			  	<input type="number" class="form-control mb-3" id="od_amount" name="od_amount" value="0">
		</div>
		<form name="form" id="form" class="container" enctype="multipart/form-data" method="post">
			<button type="button" form="form" class="btn btn-outline-success col-7" onclick="goSize();">바로구매</button>
			<input type = "hidden" name="pr_code" id="pr_code" value="${p.pr_code}">
		</form>
	</div>
	<div class="form-group">
	  <div class="form-control" style="height:auto">${p.pr_content}</div>
	</div>
	<div class="box-qna">
		<h2>QnA</h2>
		<table class="table table-hover">
	    <thead>
	      <tr>
	        <th>제목</th>
	        <th>작성자</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td class="box-qna">
	        	<a href="<%=request.getContextPath()%>/board/select?bd_num=14" data-secret="1" class="link-qna">
	        		<i class="fa-solid fa-lock"></i><span>제목</span>
	        	</a>
	        </td>
	        <td>작성자</td>
	      </tr>
	    </tbody>
	  </table>
	  <ul class="pagination justify-content-center">
	  	<li class="page-item <c:if test="${!pm.prev}">disabled</c:if>">
	  		<a class="page-link" href="<c:url value="/board/list?page=1&search=${pm.cri.search}&bd_type=${bd_type}"></c:url>">처음</a>
	  	</li>
	  	<li class="page-item <c:if test="${!pm.prev}">disabled</c:if>">
	  		<a class="page-link" href="<c:url value="/board/list?page=${pm.startPage-1}&search=${pm.cri.search}&bd_type=${bd_type}"></c:url>">이전</a>
	  	</li>
	  	
	  	<c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="i">
	    	<li class="page-item <c:if test="${pm.cri.page == i}">active</c:if>">
	    		<a class="page-link" href="<c:url value="/board/list?page=${i}&search=${pm.cri.search}&bd_type=${bd_type}"></c:url>">${i}</a>
	    	</li>
	    </c:forEach>
	
	    <li class="page-item <c:if test="${!pm.next}">disabled</c:if>">
	    	<a class="page-link " href="<c:url value="/board/list?page=${pm.endPage+1}&search=${pm.cri.search}&bd_type=${bd_type}"></c:url>">다음</a>
	    </li>
	    <li class="page-item <c:if test="${!pm.next}">disabled</c:if>">
	    	<a class="page-link" href="<c:url value="/board/list?page=${pm.finalPage}&search=${pm.cri.search}&bd_type=${bd_type}"></c:url>">마지막</a>
	    </li>
	  </ul>
	  <a href="<c:url value="/board/insert?bd_type=QNA&bd_pr_code=${p.pr_code}"></c:url>" class="btn btn-outline-success">QnA 등록</a>
	</div>
</div>
<script type="text/javascript">
$(function(){
	$('.likes').click(function(){
		let li_me_id = '${user.me_id}';
		if(li_me_id == ''){
			alert('로그인이 필요한 서비스입니다.');
			return;
		}
		let li_pr_code = '${p.pr_code}';
		let likes = {
				li_me_id : li_me_id,
				li_pr_code : li_pr_code
		}
		ajaxPost(false, likes, '/likes', function(data){
			if(data.res == 0){
				$('.likes').removeClass('display-none');
				$('.likes-ok').addClass('display-none');
				alert('찜한 제품을 취소했습니다.')
			}else if(data.res == 1){
				$('.likes').addClass('display-none');
				$('.likes-ok').removeClass('display-none');
				alert('해당 제품을 찜했습니다.');
			}else{
				alert('잘못된 접근입니다.')
			}
		})
	})
	$(document).on('click','.link-qna',function(e){
		if($(this).data('secret') == 1 && $(this).parent().siblings().text() != '${user.me_id}'){
			alert('비밀문의는 작성자와 관리자만 확인할 수 있습니다.');
			e.preventDefault();
		}
	})
	$(document).on('click','.pagination .page-link',function(){
		cri.page = $(this).data('page');
		loadQNA(cri);
	})
	loadQNA(cri);
})
let page = 1;
let cri = {
		page : page,
		perPageNum : 2,
		search : '${p.pr_code}'
}
function loadQNA(cri){
	ajaxPost(false, cri, '/qna/list', function(data){
		
		createQNAList(data.list, '.box-qna tbody');
		createPagination(data.pm, '.pagination');
		
	})
}
function createQNAList(list, target){
	let str = '';
	for(b of list){
		str += '<tr>'
  str +=   '<td class="box-qna">'
  str += 	   '<a href="<%=request.getContextPath()%>/board/select?bd_num='+b.bd_num+'" data-secret="'+b.bd_secret+'" class="link-qna">'
  if(b.bd_secret == '1')
		str +=     '<i class="fa-solid fa-lock"></i>'
  str +=		   '<span>'+b.bd_title+'</span>'
  str +=	   '</a>'
  str +=   '</td>'
  str +=   '<td>'+b.bd_me_email+'</td>'
	str += '</tr>'
	}
	$(target).html(str);
}
function createPagination(pm, target){
	let str = '';
	let prev = pm.prev ? '' : 'disabled';
  str +=	'<li class="page-item '+prev+'">'
  str +=		'<a class="page-link" href="javascript:0;" data-page="1">처음</a>'
  str +=	'</li>'
  str +=	'<li class="page-item '+prev+'">'
  str +=		'<a class="page-link" href="javascript:0;" data-page="'+(pm.startPage-1)+'">이전</a>'
	str +=	'</li>'
  for(i = pm.startPage; i<= pm.endPage; i++){
	  let active = pm.cri.page == i?'active':'';
  	str +='<li class="page-item '+active+'">'
  	str +=	'<a class="page-link" href="javascript:0;" data-page="'+i+'">'+i+'</a>' 		
  	str +='</li>'
  }
	let next = pm.next ? '' : 'disabled';
	str +=	'<li class="page-item '+next+'">'
  str +=		'<a class="page-link" href="javascript:0;" data-page="'+(pm.endPage+1)+'">다음</a>'
  str +=	'</li>'
  str +=	'<li class="page-item '+next+'">'
  str +=		'<a class="page-link" href="javascript:0;" data-page="'+pm.finalPage+'">마지막</a>'
	str +=	'</li>'
  
  $(target).html(str);
}
function goSize() {
			if($("#po_name").val() == "0"){
				alert('제품을 선택하세요');
				return false;
			}
			form.action = "/maranix/order/form?pr_price="+$("#pr_price").val()+"&od_amount="+$("#od_amount").val();
			form.method = "POST";
			form.submit();
	}
</script>
</body>
</html>