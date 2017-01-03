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
	<div class="right">
	<c:choose>
		<c:when test="${empty id}">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/views/users/signin_form.do?uri=${pageContext.request.requestURI}">로그인</a>
		</c:when>
		<c:otherwise>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/views/users/">로그아웃</a>
		</c:otherwise>
	</c:choose>   
		<a class="navbar-brand" href="${pageContext.request.contextPath}/views/users/signup_form.do">회원가입</a>
	</div>
</div>