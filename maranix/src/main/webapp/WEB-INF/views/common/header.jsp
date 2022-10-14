<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
	   <ul class="navbar-nav">
	    	<c:if test="${user == null}">
		      <li class="nav-item">
		       	<a class="nav-link" href="<c:url value="/login"></c:url>">로그인</a>
		      </li>
		      <li class="nav-item">
		       	<a class="nav-link" href="<c:url value="/signup"></c:url>">회원가입</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="<c:url value="/cart"></c:url>">장바구니</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="<c:url value="/orderIn"></c:url>">주문조회</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="<c:url value="/myPage"></c:url>">마이페이지</a>
		      </li>
		    </c:if>
		    <c:if test="${user != null}">
		      <li class="nav-item">
		       	<a class="nav-link" href="<c:url value="/logout"></c:url>">로그아웃</a>
		      </li>
		      <li class="nav-item">
		       	<a class="nav-link" href="<c:url value="/update"></c:url>">정보수정</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="<c:url value="/cart"></c:url>">장바구니</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="<c:url value="/orderIn"></c:url>">주문조회</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="<c:url value="/myPage"></c:url>">마이페이지</a>
		      </li>
		    </c:if>
		    <c:if test="${user.me_authority == 10 }">
	      <li class="nav-item">
	        <a class="nav-link" href="<c:url value="/admin"></c:url>">관리자</a>
	      </li>
     	</c:if>
	   </ul>
	</div>
</nav>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
	   <ul class="navbar-nav">
	   		<li class="nav-item">
	        <a class="nav-link" href="<c:url value="/list/clothList"></c:url>">의류</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="<c:url value="/list/capList"></c:url>">모자</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="<c:url value="/list/spgList"></c:url>">스포츠용품</a>
	      </li>
	   </ul>
	</div> 
</nav>