<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 list</title>
<style>
	.product_main{
		width:100%;
	}
	li{
		width:20%;
		height: 400px;
		float:left;
		list-style-type:none;
		border:1px solid red;
		background-color:#cecece;
	}
	
</style>
<jsp:include page="/views/resource.jsp"/>
</head>
<body>
<div class="container">
	<header>
		<jsp:include page="/views/catalog.jsp"/>
	</header>
	<div class="product_main">
		<ul>
			<a href=""><li>여기그림1</li></a>
			<a href=""><li>여기그림2</li></a>
			<a href=""><li>여기그림3</li></a>
			<a href=""><li>여기그림4</li></a>
			<a href=""><li>여기그림5</li></a>
		</ul>
	</div>
	<footer>
		
	</footer>
</div>
</body>
</html>