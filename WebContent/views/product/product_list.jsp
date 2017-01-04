<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 list</title>
<style>
	html,body { height: 100%; margin: 0; padding: 0; }
	.product_main{
		width:100%;
	}
	.product_main ul li{
		width:20%;
		height: 400px;
		float:left;
		list-style-type:none;
		border:1px solid red;
		margin : 0 auto;
		text-align: center
	}
	img{
		width:100%;
	}
	.imgBox{
		width:220px;
		background-color:#cecece;
	}
	.price{
		color:red;
	}
	.productName{
		font-size:25px;
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
			<%-- <c:forEach var="" items="">   여기 for문 돌려서 list 뽑아내는거야 --%>	
				<li>
					<div class="imgBox"><img src="${pageContext.request.contextPath }/upload/test1.jpg" alt="그림1" /></div>
					<div class="productName"><strong>$ 상품명</strong></div>
					<div class="brand">$</div>
					<div class="regdate">$</div>
					<div class="content">Lorem numquam quritatis commodi odit sint doloremque ad reiciendis consequatur alias!</div>	
					<div class="price"><strong>$ 여기 가격</strong></div>
				</li>			
			<%-- </c:forEach> --%>	
		</ul>
		<ul>
			<%-- <c:forEach var="" items="">   여기 for문 돌려서 list 뽑아내는거야 --%>	
				<li>
					<div class="imgBox"><img src="" alt="그림1" /></div>
					<div class="productName"><strong>$ 상품명</strong></div>
					<div class="brand">$</div>
					<div class="regdate">$</div>
					<div class="content"> 여기 내용</div>
					<div class="price"><strong>$ 여기 가격</strong></div>
				</li>			
			<%-- </c:forEach> --%>	
		</ul>
		<ul>
			<%-- <c:forEach var="" items="">   여기 for문 돌려서 list 뽑아내는거야 --%>	
				<li>
					<div class="imgBox"><img src="" alt="그림1" /></div>
					<div class="productName"><strong>$ 상품명</strong></div>
					<div class="brand">$</div>
					<div class="regdate">$</div>
					<div class="content"> 여기 내용</div>
					<div class="price"><strong>$ 여기 가격</strong></div>
				</li>			
			<%-- </c:forEach> --%>	
		</ul>
		<ul>
			<%-- <c:forEach var="" items="">   여기 for문 돌려서 list 뽑아내는거야 --%>	
				<li>
					<div class="imgBox"><img src="" alt="그림1" /></div>
					<div class="productName"><strong>$ 상품명</strong></div>
					<div class="brand">$</div>
					<div class="regdate">$</div>
					<div class="content"> 여기 내용</div>
					<div class="price"><strong>$ 여기 가격</strong></div>
				</li>			
			<%-- </c:forEach> --%>	
		</ul>
		<ul>
			<%-- <c:forEach var="" items="">   여기 for문 돌려서 list 뽑아내는거야 --%>	
				<li>
					<div class="imgBox"><img src="" alt="그림1" /></div>
					<div class="productName"><strong>$ 상품명</strong></div>
					<div class="brand">$</div>
					<div class="regdate">$</div>
					<div class="content"> 여기 내용</div>
					<div class="price"><strong>$ 여기 가격</strong></div>
				</li>			
			<%-- </c:forEach> --%>	
		</ul>
		
	</div>
	<!-- pagination 요기요기 -->
	
	<div class="page_display">
	<center>
		<ul class="pagination">
		<c:choose>
			<c:when test="">
				<li><a href="">&laquo;</a></li>
			</c:when>
			<c:otherwise>
				<li class="disabled"><a class="muted" href="javascript:">&laquo;</a></li>
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
			<c:choose>
				<c:when test="">
					<li class="active"><a href="list.do?pageNum=${i }">${i }</a></li>	
				</c:when>
				<c:otherwise>
					<li><a href="list.do?pageNum=${i }&&list_num=${listNum}">${i }</a></li>
				</c:otherwise>
			</c:choose>    
		</c:forEach>
		<c:choose>
			<c:when test="">
				<li><a href="">&raquo;</a></li>
			</c:when>
			<c:otherwise>
				<li class="disabled"><a class="muted" href="javascript:">&raquo;</a></li>
			</c:otherwise>
		</c:choose>
		</ul>
	</div>
	</center>
	<footer>
		<jsp:include page="/views/footer.jsp"/>
	</footer>
</div>
</body>
</html>