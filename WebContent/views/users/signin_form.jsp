<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<jsp:include page="/views/resource.jsp"/>
<html>
<style>
	.container{
		width:30%;
	}
</style>
<jsp:include page="/views/catalog.jsp"/>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h3>로그인</h3>
	<form action="signin.do" method="post">
		<div class="form-group">
			<label class="control-label" for="id">아이디:</label>
			<input class="form-control" type="text" id="userId" name="userId"/>
		</div>
		<div class="form-group">
			<label class="control-label" for="pwd">비밀번호:</label>
			<input class="form-control" type="text" id="userPwd" name="userPwd"/>
		</div>
		<button class="btn btn-default" type="submit" id="submitBtn">가입</button>
		<button class="btn btn-danger" type="button">취소</button>
	</form>
</div>
</body>
</html>