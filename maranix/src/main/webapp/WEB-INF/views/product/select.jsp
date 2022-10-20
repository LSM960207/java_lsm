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
<div class="container mt-3">
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
				<select class="form-control option" name="od_po_num" id="po_name">
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
</div>
<script type="text/javascript">

function goSize() {
			if($("#po_name").val() == "0"){
				alert('제품을 선택하세요');
				return false;
			}
			form.action = "/maranix/orders/form?pr_price="+$("#pr_price").val()+"&od_amount="+$("#od_amount").val();
			form.method = "POST";
			form.submit();
	}
</script>
</body>
</html>