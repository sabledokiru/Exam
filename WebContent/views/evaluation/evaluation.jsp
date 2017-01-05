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
</style>
<div class="container">
   <table class="table table-hover">
      <thead>
         <tr>
            <th style="font-size:30px"><strong>상품평 등록</strong></th>
            <th><strong>작성자</strong></th>
            <th>등록일</th>
         </tr>
      </thead>
      <tbody>
         <c:forEach var="tmp" items="${list}">
         <tr class="qnaTitle warning">
            <td>${tmp.evaTitle }</td>
            <td>${tmp.evaWriter }</td>
            <td>${tmp.regdate }</td>
         </tr>
         <tr class="qnaBox">
            <td colspan="3">
               <div class="qnaContent"><span class="glyphicon glyphicon-question-sign "></span></div><br/>
               <div class="adminWrite">
                  <form action="" method="post">
                     <span class="glyphicon glyphicon-text-color"></span>
                     <input type="hidden" value="" />
                     <textarea name="" id="" cols="100" rows="10"></textarea>
                     <c:choose>
                        <c:when test="${id == admin }">
                           <button class="btn btn-default" id="qnaBtn" type="submit">등록</button>
                        </c:when>
                        <c:otherwise>
                        </c:otherwise>
                     </c:choose>
                  </form>
               </div>
            </td>
         </tr>
         </c:forEach>
      </tbody>
   </table>
   
   <form action="${pageContext.request.contextPath}/views/evaluation/private/insertform.do" method="get">
      <button type="submit" class="btn btn-info" style="float:right">글쓰기</button>
   </form>
   
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
