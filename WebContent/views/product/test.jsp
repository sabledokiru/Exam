<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/views/resource.jsp"/>
<script>
	$(function(){
		$.ajax({
			url:"${pageContext.request.d}/views/evaluation/list.do",
			method:"get",
			success : function(data){
				alert("hi");
			}
		});
	});
</script>