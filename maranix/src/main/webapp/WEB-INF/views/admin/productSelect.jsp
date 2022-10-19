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

	<h2 class="clearfix">
		<i class="fa-regular fa-heart float-right likes <c:if test="${li != null }">display-none</c:if>"></i>
		<i class="fa-solid fa-heart float-right likes likes-ok <c:if test="${li == null }">display-none</c:if>"></i>
	</h2>
	<div class="clearfix">
		<div class="float-left" style="width:auto; height: auto">
			<img id="preview" width="300" height="300" src="<c:url value="${p.pr_thumb_url}"></c:url>">
		</div>
		<div class="float-right" style="width:calc(100% - 300px - 200px)">
			<div class="form-group">
	  		<input type="text" class="form-control" value="${p.pr_title }" readonly>
	  		<input type = "hidden" name="pr_code" id="pr_code" value="${p.pr_code }">
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" value="제품종류 : ${p.pr_ca_name }" readonly>
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" value="제품번호 : ${p.pr_code }" readonly>
			</div>
			<div class="form-group">
			  <input type="text" class="form-control" id="pr_price" name="pr_price" value="${p.pr_price}" readonly>
			</div>
		</div>
		<table class="table">
				<thead>
					<tr align="center">
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
	      		</tr>
      		</c:forEach>
				</tbody>
			</table>
	</div>
	<div class="form-group">
	  <div class="form-control" style="height:auto">${p.pr_content}</div>
	</div>
<script type="text/javascript">
</script>
</body>
</html>