<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	var test = "${optionList[0].po_name}";
	$("#po_name").val(test).prop("selected", true);
})
</script>
<body>
<form name="form" id="form" class="container" enctype="multipart/form-data" method="post">
	<table>
		<tr>
			<td colspan="2">
			<c:if test="${empty po_num }">
				<select class="form-control" name="po_pr_code">
			  	<option value="0">제품을 선택하세요.</option>
			  	<c:forEach items="${list}" var="pr">
			  		<option value="${pr.pr_code}">${pr.pr_title}</option>
			  	</c:forEach>
			  </select>
			  </c:if>
			  <c:if test="${not empty po_num }">
			  	<input type = "text" class="form-control" name="iPo_pr_title" id="iPo_pr_title" value="${ optionList[0].pr_title }" readonly >
			  	<input type = "hidden" name="po_pr_code" id="po_pr_code" value="${ optionList[0].pr_code }" >
			  	<input type = "hidden" name="po_num" id="po_num" value="${ po_num }" >
			  </c:if>
		  </td>
		  
			<td>
				<select class="form-control" name="po_name" id="po_name">
  				<option value="0">사이즈를 선택하세요.</option>
  				<option value="FREE">FREE</option>
  				<option value="S">S</option>
  				<option value="M">M</option>
  				<option value="L">L</option>
	  			<option value="XL">XL</option>
	  			<option value="2XL">2XL</option>
	  			<option value="3XL">3XL</option>
	  			<option value="4XL">4XL</option>
 				</select>
  		</td>
  		<td>
  			<input type="text" class="form-control" placeholder="수량" name="po_count" id="po_count" value="${ optionList[0].po_count }">
  		</td>
 		</tr>
 		<tr>
	 		<td>
	 			<button type="submit" form="form" class="btn btn-outline-primary" onclick="goSize();">전송</button>
	 			<button type="button" class="btn btn-outline-danger">뒤로가기</button>	 			
	 		</td>
 		</tr>
	</table>
</form>
<script type="text/javascript">
function goSize() {
if($("#po_num").val() == ""){
		form.action = "/maranix/admin/option/insert";
	}else {
		form.action = "/maranix/admin/option/update";
	}
		form.method = "POST";
		form.submit();
}
</script>
</body>
</html>