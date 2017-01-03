<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>

<title>회원가입 페이지</title>
</head>
<body>
<div class="container">
	<h3>회원가입</h3>
	<form action="" method="post">
		<div class="form-group has-feedback">
			<label class="control-label" for="userId">아이디:</label>
			<input class="form-control" type="text" 
				id="userId" name="userId"/>
			<p class="help-block">사용할 수 없는 아이디 입니다.</p>
			<span class="glyphicon form-control-feedback"></span>
		</div>
		<div class="form-group">
			<label class="control-label" for="userPwd">비밀번호:</label>
			<input class="form-control" type="text" 
				id="userPwd" name="userPwd"/>
		</div>1
		<div class="form-group">
			<label class="control-label" for="userEmail">이메일:</label>
			<input class="form-control" type="text" 
				id="userEmail" name="userEmail"/>
		</div>
		<div class="form-group">
			<label class="control-label" for="userPhone">전화번호:</label>
			<input class="form-control" type="text" 
				id="userPhone" name="userPhone"/>
		</div>
		<div class="form-group">
			<label class="control-label" for="userAddr">주소:</label>
			<input class="form-control" type="text" 
				id="userAddr" name="userAddr"/>
		</div>
		
		<button type="submit">가입</button>
	</form>
</div>

<script src="${pageContext.request.contextPath }/resource/js/jquery-3.1.1.js"></script>
<script>
	//아이디 입력란에 keyup 이벤트가 발생했을때 실행할 함수 등록 
	$("#id").on("keyup", function(){
		//입력한 아이디 읽어오기
		var inputId=$("#id").val();
		//ajax 요청을 이용해서 서버에 전송
		$.ajax({
			url:"checkid.do",
			method:"get",
			data:{inputId:inputId},
			
			success:function(data){
				console.log(data);
				$("#id").parent()
				.removeClass("has-success has-error");
				if(data.canUse){
					$("#id")
					.parent()
					.addClass("has-success")
					.find(".help-block")
					.hide()
					.parent()
					.find(".glyphicon")
					.removeClass("glyphicon-remove")
					.addClass("glyphicon-ok");
				}else{
					$("#id")
					.parent()
					.addClass("has-error")
					.find(".help-block")
					.show()
					.parent()
					.find(".glyphicon")
					.removeClass("glyphicon-ok")
					.addClass("glyphicon-remove");
				}
			}
		});
	});
</script>
</body>
</html>