<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 list</title>
<style>
	html,body { height: 100%; margin: 0; padding: 0; }
	.product_main{
		width:100%;
		clear:both;
	}
	.product_main ul li{
		width:20%;
		height: 400px;
		float:left;
		list-style-type:none;
		margin : 0 auto;
		text-align: center;
	}
	img{
		width:100%;
	}
	.imgBox{
		width:300px;
		background-color:#cecece;
	}
	.productName{
		font-size:20px;
		clear:left;
	}
	.search_form form{
		text-align:center;
	}
	#condition{
		height:25px;
		top:5px;
	}
	.contentBox{
		float:left;
		width:33%;
		margin-top:50px;	
	}
	.price{
		float:right;
		margin-right:75px;
		color:black;
		font-size:18px;
	}
	.serchAndPage{
		clear:both;
		width:100%;
	}
	.writeBtn{
		float:right;
		margin-right:80px;
	}
</style>
<jsp:include page="/views/resource.jsp"/>
</head>
<body>
<jsp:include page="/views/catalog.jsp"/>
<div class="container">
	<button class="btn btn-default writeBtn">글쓰기</button>
	<div class="product_main">
		<c:forEach var="tmp" items="${list}">
			<div class="contentBox">
				<div class="imgBox" onclick="detailView(${tmp.productNum})"><img src="${pageContext.request.contextPath }/upload/${tmp.saveFileName}"/></div>
				<div class="productName"><strong>상품명: (${tmp.brand}) ${tmp.productName } </strong></div>
				<div>등록일 ${tmp.regdate}</div>
				<div>조회수 ${tmp.viewCount }</div>
				<div class="price"><strong>가격 :<span><fmt:formatNumber value="${tmp.price}" type="number"/>원</span></strong></div>

			</div>			
		</c:forEach>
	</div>
</div>
	<!-- pagination 요기요기 -->
	<div class="serchAndPage">
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
		<!-- 검색기능 -->
		<!-- 검색어 관련 form -->
		<div class="search_form">
			<form action="" method="post" id="keywordForm">
				<label for="condition"></label>
				<select name="condition" id="condition">
					<option value="productName" <c:if test="${condition eq 'productName' }">selected</c:if>>상품</option>
					<option value="brand" <c:if test="${condition eq 'brand' }">selected</c:if>>제조사</option>
				</select>
				<input type="text" name="keyword" placeholder="검색어" 
					value="${keyword }"/>
				<button type="submit">검색</button>
			</form>
		</div>
		<jsp:include page="/views/footer.jsp"/>
	</div>
	</center>
	<div>
	<c:forEach var="tmp" items="${list2}" begin="1" end="5">
		<div class="imgBox" onclick="detailView(${tmp.productNum})"><img src="${pageContext.request.contextPath }/upload/${tmp.saveFileName}"/></div>
		<div class="productName"><strong>상품명: (${tmp.brand}) ${tmp.productName } </strong></div>
		<div class="price"><strong>가격 :<span><fmt:formatNumber value="${tmp.price}" type="number"/>원</span></strong></div>
	</c:forEach>
	</div>
</body>
<script>
	$(".writeBtn").click(function(){
		location.href="${pageContext.request.contextPath}/views/product/private/insertform.do";
	});
	
	function detailView(data){
		location.href="${pageContext.request.contextPath}/views/product/product_info.do?productNum="+data;
	}
</script>
</html>