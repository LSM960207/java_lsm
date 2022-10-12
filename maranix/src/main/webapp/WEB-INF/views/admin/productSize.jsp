<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.btn-del{
	padding : 0; border: none; background-color: transparent; color : #ffc107;
}
form.btn:hover .btn-del{
	color : #fff;
}
form.btn{
	margin-bottom: 0;
}
</style>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<h2>제품 사이즈 등록</h2>
	<div class="clearfix">
		<div class="float-left">
			<div class="form-group">
				<table>
					<colgroup>
						<col width="40%"/>
						<col width="auto"/>
					</colgroup>
						<tr>
							<td colspan="2">
								<select class="form-control" name="iPr_title">
							  	<option value="0">제품을 선택하세요.</option>
							  	<c:forEach items="${list}" var="pr">
							  		<option value="${pr.pr_code}">${pr.pr_title}</option>
							  	</c:forEach>
							  </select>
						  </td>
						  <td>
						  </td>
				  		<td align = "right">
				  			<a href="<c:url value="/admin/option/info"></c:url>">
				  			<button class="btn btn-outline-primary">신규</button>
				  			</a>
				  		</td>
						</tr>
				</table>
			</div>
		</div>
	</div>
<div class="container">
	<table border="1">
		<colgroup>
			<col width="7%"/>
			<col width="15%"/>
			<col width="30%"/>
			<col width="15%"/>
			<col width="15%"/>
		</colgroup>
			<thead>
				<tr>
					<th>옵션번호</th>
					<th>제품코드</th>
					<th>제품명</th>
					<th>제품사이즈</th>
					<th>수량</th>
				</tr>
				</thead>
       <tbody>
       <c:forEach items="${oList}" var="po">
	      <tr>
	        <td class='text-center'>${po.po_num}</td>
	        <td class='text-center'>${po.po_pr_code}</td>
	        <td class='text-center'>${po.pr_title}</td>
	        <td class='text-center'>${po.po_name}</td>
	        <td class='text-center'>${po.po_count}</td>
	        <td>
	        	<a class="btn btn-outline-warning" href="<c:url value="/admin/option/info?po_num=${po.po_num}"></c:url>">수정</a>
	        	<form class="btn btn-outline-danger" action="<c:url value="/admin/option/delete"></c:url>" method="post">
	        		<button class="btn-del">삭제</button>
	        		<input type="hidden" name="po_num" value="${po.po_num}">
	        	</form>
	        </td>
	      </tr>
      </c:forEach>
       </tbody>
	</table>
	</div>
<script type="text/javascript">
$(function(){
	$('form').submit(function(){
		let pr_ca_name = $('[name=pr_ca_name]').val();
		if(pr_ca_name == '0'){
			alert('제품 종류를 선택하세요.');
			$('[name=pr_ca_name]').focus();
			return false;
		}
	});
})

</script>


<!-- 	$('[name=pr_ca_name]').change(function(){
		$('[name=pr_code]').val($(this).val());
	}) -->