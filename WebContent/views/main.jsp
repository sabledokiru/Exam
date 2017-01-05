<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<jsp:include page="/views/resource.jsp"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/views/catalog.jsp"/>

<jsp:include page="/views/footer.jsp"/>
</body>
</html>



<script>
$(function(){
	$.ajax({
		url:"evaluation/list.do",
		method:"GET",
		success: function(data){
			alert("hi");
			alert(data);
			
		}
	});
});
</script>