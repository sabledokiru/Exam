<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
   <a href="${pageContext.request.contextPath}/views/users/signin_form.do?uri=${pageContext.request.requestURI}">로그인</a>
   <a href="${pageContext.request.contextPath}/views/users/signup_form.do">회원가입</a>
</div>
<hr />