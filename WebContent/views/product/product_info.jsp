<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/views/resource.jsp"/>
<title>상품정보</title>
<style>
	.imgBox{
		float:left;	
	}
	.contentBox{
		float:left;
		margin-left:10%;
		margin-top:70px;
	}
	.content{
		clear:both;
	}
	.glyphicon-triangle-top{
		position:relative;
		cursor:pointer;
		top:-5px;
		left:3px;
	}
	.glyphicon-triangle-bottom{
		position: relative;
		cursor:pointer;
		top:5px;
		left:-15px;	
	}
	.buyBtn{
		float:right;
	}
</style>
</head>
<body>
<div class="container">
	<header>
		<jsp:include page="/views/catalog.jsp"/>
	</header>
	<div class="product_main">
		<hr/>
		<div class="productName"><strong>$ 상품명</strong></div>
		<hr/>
		<div class="imgBox">
			<img src="${pageContext.request.contextPath }/upload/test1.jpg" alt="그림1" />
		</div>
		<div class="contentBox">
			<div class="brand">브랜드 : 브랜드 나올곳</div></br>
			<div class="regdate">등록 일자 : 나올곳</div></br>
			<p>배송정보 : 무료배송 | 퀵서비스 | 직접수령 | VIP배송</p></br>
			<div class="count">
				<p>주문수량 :
					<input type="text" id="count" value="1" style="width:30px;"/>
					<span class="glyphicon glyphicon-triangle-top" id="countUp"></span>
					<span class="glyphicon glyphicon-triangle-bottom" id="countDown"></span>
				</p>
			</div>
			<div class="price"><strong>가 격 :$ 여기 가격</strong></div>
			<hr/>
			<span>총 가격 : <span id="totalPrice"> 계산 가격</span></span>
			<button class="btn btn-success buyBtn">구매하기</button>
		</div>
		<hr/>	
		<div class="content">네이버 툴 나올곳 모야..</div>	
	</div>
	</center>
	<footer>
		<jsp:include page="/views/footer.jsp"/>
	</footer>
</div>
</body>
</html>
<script>
	$("#countUp").click(function(){
		var count = $("#count").val();
		count ++;
		$("#count").val(count);
		$("#totalPrice").text(count*1000);
	});
	$("#countDown").click(function(){
		var count = $("#count").val();
		if(count == 1){
			return;
		}
		count --;
		$("#count").val(count);
		$("#totalPrice").text(count*1000);
	});
</script>