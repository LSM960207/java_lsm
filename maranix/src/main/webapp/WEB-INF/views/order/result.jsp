<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
<div class="container mt-3" style="text-align: center">
	<h3>주문이 완료되었습니다.</h3>
	<table class="table">
		<thead>
			<tr>
				<th colspan="2" style="text-align: center !important;">상품명</th>
				<th>가격</th>
				<th>수량</th>
				<th>옵션</th>
				<th>결제금액</th>
				</tr>
		</thead>
		<tbody style="text-align: left; vertical-align: middle;">
			<tr>
				<td style="text-align: center;">
					<img id="preview" width="250" height="250" src="<c:url value="${p.pr_thumb_url}"></c:url>">
<%-- 					<input type="hidden" value="" name="" id=""> --%>
				</td>
				<td>${p.pr_title}<br>${p.pr_content}</td>
				<td>${total} 원</td>
				<td>${amount}</td>
				<td>${optionList[0].po_name}</td>
				<td><span>${total} 원</span></td>
			</tr>
		</tbody>
	</table>
	<table class="table">
		<thead>
			<tr>
				<th>주문자</th>
				<th>배송지</th>
				<th>전화번호</th>
				<th>배송상태</th>
				<th>요청사항</th>
			</tr>
		</thead>
		<tbody style="text-align: left;">
			<tr>
				<td></td>
				<td><br></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
</body>
</html>