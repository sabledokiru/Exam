<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
   .writeBox{
   	width: 50%;
   	margin-left:25%;
   }
   .replyAtag{
	   margin-top:5px;
	   float:right;
	   font-color:red;
	   text-decoration: none;
   }
   .replyAtag:ACTIVE, .replyAtag:HOVER , .replyAtag:AFTER , .replyAtag:FOCUS{
		font-color:red;
   }
   .writeBox{
   	display:none;
   }
   .contentTR{
   	display:none;
   }
</style>
<div class="container">
   <table class="table table-hover">
      <p><strong style="font-size:30px">상품평 등록</strong></p>
      <thead>
         <tr>
         	<th style="width:10%">글 번호</th>
            <th style="width:50%">제목</th>
            <th style="width:20%"><strong>작성자</strong></th>
            <th>등록일</th>
         </tr>
      </thead>
      <tbody>
         <c:forEach var="tmp" items="${list}">
         <tr class="qnaTitle warning">
         	<td>${tmp.evaNum}</td>
            <td class="viewContent" onclick="showcontent(${tmp.evaNum})">${tmp.evaTitle }</td>
            <td>${tmp.evaWriter }</td>
            <td>${tmp.regdate }</td>
         </tr>
         <tr class="contentTR showContent${tmp.evaNum}">
         	<td colspan="4"><span>내용 :</span> ${tmp.evaContent} <a class="replyAtag">답글 달기</a>
         		<div>
			        <form action="${pageContext.request.contextPath}/views/evaluation/insert.do" method="post">
						<div class="form-group">
							<p  style="margin-top:10px;font-size:18px"><strong>댓글 달기</strong></p>
							<textarea class="form-control" name="content" id="content" style="width:85%"></textarea>
						</div>
						<button class="btn btn-default" type="submit">작성</button>
					</form>
				</div>
         	</td>
         </tr>
         </c:forEach>
      </tbody>
   </table>
   
	<button type="submit" class="btn btn-info write_eval_Btn" style="float:right">글쓰기</button>
	
	<!-- 글 등록 form  -->
	<div class="writeBox form-group">
		<form action="${pageContext.request.contextPath}/views/evaluation/insert.do" method="post">
		<div class="form-group">
			<input type="hidden" name="productNum" value="${productNum}"/>
			<label class="control-label" for="title">제목:</label>
			<input class="form-control" type="text" name="title" id="title"/>
		<div class="form-group">
			<label class="control-label" for="writerDetailquestion">후기:</label>
			<textarea class="form-control" name="content" id="content" cols="30" rows="10"></textarea>
		</div>
			<button class="btn btn-default" type="submit">작성</button>
		</form>
	</div>
<!--pagenation  시작-->
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
	function showcontent(data){
		$(".showContent"+data).toggle();
	};
	$(".write_eval_Btn").click(function(){
		$(".writeBox").toggle();
	});
</script>