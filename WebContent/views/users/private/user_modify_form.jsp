<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<jsp:include page="/views/resource.jsp"/>
<html>
<style>
	.container{
		width:30%;
	}
	#idCheck{
		float:right;
		margin:5px 0;
	}
</style>
<head>
<meta charset="UTF-8"/>
<jsp:include page="/views/catalog.jsp"/>
<title>회원가입 페이지</title>
</head>
<body>
<div class="container">
	<h3>회원가입</h3>
	<form action="" method="post">
		<div class="form-group">
			<label class="control-label" for="userId">아이디:</label>
			<input class="form-control" type="text" id="userId" value="${id}" disabled="disabled"/>
		</div>
		<div class="form-group">
			<label class="control-label" for="userPwd">비밀번호:</label>
			<input class="form-control" type="text" id="userPwd" name="userPwd" value=/>
		</div>
		<div class="form-group">
			<label class="control-label" for="userEmail">이메일:</label>
			<input class="form-control" type="text" id="userEmail" name="userEmail"/>
		</div>
		<div class="form-group">
			<label class="control-label" for="userPhone">전화번호:</label>
			<input class="form-control" type="text" id="userPhone" name="userPhone"/>
		</div>
		<div class="form-group">
			<label class="control-label" for="userAddr">주소:</label>
			<input class="form-control" type="text" id="userAddr" name="userAddr"/>
		</div>
		<button class="btn btn-success" type="button" id="submitBtn">가입</button>
		<button class="btn btn-danger" type="button">취소</button>
	</form>
</div>
</body>
</html>

<script>
    /* 회원가입  */
 	$("#submitBtn").click(function(){
 		var id = $("#userId").val();
 		var pwd = $("#userPwd").val();
 		var email = $("#userEmail").val();
 		var phone = $("#userPhone").val();
 		var addr = $("#userAddr").val();
		if($("#userId").val() == ""){
			alert("아이디를 입력해 주세요.");
		}else if(isCheck == false){	
			alert("아이디를 증복 확인을 해주세요.");
		}else if($("#userPwd").val() == ""){	
			alert("비밀번호를 입력해 주세요.");
		}else if($("#userEmail").val() == ""){		
			alert("이메일을 입력해 주세요.");
		}else if($("#userPhone").val() == ""){
			alert("핸드폰 번호를 입력해 주세요.");
		}else if($("#userAddr").val() == ""){
			alert("주소를 입력해주세요.");
		}
 		else{
	 		$.ajax({  
	 			url: "signup.do",
	 			type: "POST",
	 			data : {"id":id,"pwd":pwd,"email":email,"phone":phone,"addr":addr},
	 			success: function(data){
	 				if(data.isSuccess == true){
	 					alert("회원 가입 되었습니다.");
	 					location.href="${pageContext.request.contextPath}/index.jsp"
	 				}
	 				else{
	 					alert("회원 가입에 실패 하였습니다.");
	 				}
	 			}  
	 		});
 		}	 
 	});
</script>