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
	.adminWrite{
		border-top:1px solid;
	}
	.glyphicon-question-sign{
		font-size:25px;
		color:red;
	}
	.glyphicon-text-color{
		font-size:25px;
		color:#73FAFF;
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
			<tr class="qnaTitle warning">
				<td>하나씩 들어가요 여기다가 달러 넣으시면 됩니다</td>
				<td>개미는뜐뜐</td>
				<td>2222-10-22</td>
			</tr>
			<tr class="qnaBox">
				<td colspan="3">
					<div class="qnaContent"><span class="glyphicon glyphicon-question-sign "></span>여기는 Q&A Content영역 Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eos quo voluptate repellendus quibusdam incidunt sit</div><br/>
					<div class="adminWrite">
						<form action="" method="post">
							<span class="glyphicon glyphicon-text-color"></span>
							<textarea name="" id="" cols="100" rows="10"></textarea>
							<button type="submit">등록</button>
						</form>
					</div>
				</td>
			</tr>
			<%-- </c:forEach> --%>
		</tbody>
	</table>
	
	<form action="" method="post">
		<button type="submit" class="btn btn-info" style="float:right">글쓰기</button>
	</form>
	<br/>
	<br/>
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