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
</head>
<body>
<div class="container">
  <h2>모자</h2>
	<table class="table table-hover">
    <thead>
      <tr>
        <th>제품 이미지</th>
        <th>제품명</th>
        <th>가격</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${list}" var="pro">
	      <tr>
	        <td>
	        	<img alt="제품이미지" src="<c:url value="${pro.pr_thumb_url}"></c:url>" width="150" height="150">
	        </td>
	        <td>
	        	<a href="<c:url value="/product/select?pr_code=${pro.pr_code}"></c:url>">${pro.pr_title}</a>
	        </td>
	        <td>${pro.pr_price}</td>
	      </tr>
      </c:forEach>
    </tbody>
  </table>
<ul class="pagination justify-content-center">
  	<li class="page-item <c:if test="${!pm.prev}">disabled</c:if>">
  		<a class="page-link" href="<c:url value="/list/capList?page=1&search=${pm.cri.search}&pr_ca_name=${pm.cri.pr_ca_name}"></c:url>">처음</a>
  	</li>
  	<li class="page-item <c:if test="${!pm.prev}">disabled</c:if>">
  		<a class="page-link" href="<c:url value="/list/capList?page=${pm.startPage-1}&search=${pm.cri.search}&pr_ca_name=${pm.cri.pr_ca_name}"></c:url>">이전</a>
  	</li>
  	
  	<c:forEach begin="${pm.startPage }" end="${pm.endPage }" var="i">
    	<li class="page-item <c:if test="${pm.cri.page == i}">active</c:if>">
    		<a class="page-link" href="<c:url value="/list/capList?page=${i}&search=${pm.cri.search}&pr_ca_name=${pm.cri.pr_ca_name}"></c:url>">${i}</a>
    	</li>
    </c:forEach>

    <li class="page-item <c:if test="${!pm.next}">disabled</c:if>">
    	<a class="page-link " href="<c:url value="/list/capList?page=${pm.endPage+1}&search=${pm.cri.search}&pr_ca_name=${pm.cri.pr_ca_name}"></c:url>">다음</a>
    </li>
    <li class="page-item <c:if test="${!pm.next}">disabled</c:if>">
    	<a class="page-link" href="<c:url value="/list/capList?page=${pm.finalPage}&search=${pm.cri.search}&pr_ca_name=${pm.cri.pr_ca_name}"></c:url>">마지막</a>
    </li>
  </ul>
  <form>
  	<div class="input-group mb-3">
  		
		  <input type="text" class="form-control" placeholder="제품 제목 또는 제품 코드로 검색하세요." name="search" value="${pm.cri.search}">
		  <div class="input-group-append">
		    <button class="btn btn-success" type="submit">검색</button>
		  </div>
		</div>
  </form>
</div>

</body>
</html>