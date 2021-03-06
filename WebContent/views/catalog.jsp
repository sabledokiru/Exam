<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
 .right{
 	float:right;
 }
</style>
<div class="navbar navbar-inverse">
	<a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Main</a>
	<a class="navbar-brand" href="${pageContext.request.contextPath}/views/product/list.do">컴퓨터</a>
	<a href="${pageContext.request.contextPath}/views/product/qna_list.do">sdf</a>
	<div class="right">
	<c:choose>
		<c:when test="${empty id}">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/views/users/signin_form.do?uri=${pageContext.request.requestURI}">로그인</a>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/views/users/signup_form.do">회원가입</a>
		</c:when>
		<c:otherwise>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/views/users/logout.do">로그아웃</a>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/views/users/private/update_form.do">정보수정</a>
		</c:otherwise>
	</c:choose>   
	</div>
</div>