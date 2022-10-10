<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="form" id="form" class="container" enctype="multipart/form-data">
	<table>
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
		  <input type="text" class="form-control" name="po_pr_code" id="po_pr_code" readonly>
		  </td>
			<td>
				<select class="form-control" name="po_count" id="po_count">
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
  			<input type="text" class="form-control" placeholder="수량" name="po_name" id="po_name">
  		</td>
 		</tr>
 		<tr>
	 		<td>
	 			<button type="submit" form="form" class="btn btn-outline-primary">전송</button>
	 			<button type="button" class="btn btn-outline-danger">뒤로가기</button>	 			
	 		</td>
 		</tr>
	</table>
</form>
<script type="text/javascript">
	$('form').submit(function(){
		let iPr_title = $('[name=iPr_title]').val();
		if(iPr_title == '0'){
			alert('제품을 선택하세요.');
			$('[name=iPr_title]').focus();
			return false;
		}
		let iPo_name = $('[name=iPo_name]').val();
		if(iPo_name == '0'){
			alert('사이즈를 선택 하세요.');
			$('[name=iPo_name]').focus();
			return false;
		}
		let iPo_count = $('[name=iPo_count]').val();
		if(iPo_count == ''){
			alert('수량을 입력하세요');
			$('[name=iPo_count]').focus();
			return false;
		}
	});
	$('[name=iPr_title]').change(function(){
		$('[name=po_pr_code]').val($(this).val());
	})
</script>
</body>
</html>