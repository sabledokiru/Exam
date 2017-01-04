<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q&A</title>
<jsp:include page="/views/resource.jsp"/>
</head>
<style>

	.qnaBox{
		display:none;
		border:2px solid orange;
		height:100%;
	}
	
	.qnaContent{
		height: 50%;
	}
</style>
<body>
<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th style="font-size:30px"><strong>Q&A 무엇이든 물어보세요</strong></th>
				<th><strong>작성자</strong></th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<%--<c:forEach var="" items="">        지금 for문 null이라 주석으로 달아놨음  --%>
			<tr class="qnaTitle">
				<td>하나씩 들어가요</td>
				<td>개미는뜐뜐</td>
				<td>2222-10-22</td>
			</tr>
			<tr class="qnaBox">
				<td colspan="3">
					<div class="qnaContent">여기는 Q&A Content영역 Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eos quo voluptate repellendus quibusdam incidunt sit dolores aliquid quae facere rem dolorum repudiandae eius laboriosam quas pariatur ad id facilis magni?</div>
					<div>
						<textarea name="" id="" cols="100" rows="10"></textarea>
						<button type="submit">등록</button>
					</div>
				</td>
			</tr>
			
			<%-- </c:forEach> --%>
		</tbody>
	</table>
	
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
</div>
<script>
	$(".qnaTitle").on("click",function(){
		$(this).next("tr.qnaBox").toggle();
	});
</script>
</body>
</html>