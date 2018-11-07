<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here (넥스트 IT)</title>

<script type="text/javascript"  defer="defer">
	// 로그인 체크 유무 : default=false;
	var idCheckState = false;

	$(document).ready(function() {

		$("#joinfrm").on("submit", function(e) {
			//e.preventDefault();
			
			if (idCheckState){
				var inputState = true;				
				if ($("input[name=memId]").val() == "" ){
					alert("아이디 값이 누락 되었습니다.");
					inputState = false;
				} 
				if ($("input[name=memName]").val() == "" ){
					alert("이름을 입력 하세요..");
					inputState = false;
				} 
				
// 				if ($("input[name=memId]").val() != $("input[name=memIdCheck]").val() ){
// 					alert("인증 받은후 변경은 불가능 합니다.");
// 					inputState = false;
// 				} 
				
				if (inputState){
					alert("회원 가입이 진행 됨니다.");
					return true;	
				} else {
					alert("누락된값을 다시 확인 하세용.");
					return false;
				}
				
			} else{
				alert("아이디 중복 체크를 해주세요.");
				  return false;
			}
			
			
		});

		
		$("#btnIdCheck").on("click", function(e) {
			e.preventDefault();
			alert("아이디 중복 체크");
			alert($("#joinfrm").serialize());
			console.log($("#joinfrm").serialize());
			$.ajax('<c:url value="/member/idcheck.do"/>', {
				method : "POST",
				dataType : 'json',
				data : $("#joinfrm").serialize(),
				success : function(data, status, xhr) {
					console.log(data);
					//alert(JSON.stringify(data));
					alert(data.message);
					idCheckState = data.state;	
					if (data.state){
						$("input[name=memIdCheck]").val($("input[name=memId]").val());
					}
				},
				error : function(jqXhr, textStatus, errorMessage) {
					console.log(jqXhr);
					console.log(textStatus);
					console.log(errorMessage);
				}
			});
		});
	});
</script>

</head>

<body>

	<h1>회원 가입 (폼)</h1>

	<form id="joinfrm"
		action="<c:url value="/member/memberinsertProc.do"/>" method="post" enctype="multipart/form-data">

		<input type="hidden" name="memIdCheck"> 숨겨주세용
		 
		<table class="table">
			<tbody>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="memId"
						value="${memberItem.memId}">
						<button id="btnIdCheck" class="btnIdCheck" type="button">아이디
							중복 체크</button></td>
				</tr>
				<tr>
					<td>사진선택</td>
					<td><input type="file" name="attachFiles"></td>
				</tr>
				
				<tr>
					<td>이름</td>
					<td><input type="text" name="memName"
						value="${memberItem.memName}"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="memPwd"
						value="${memberItem.memPwd}"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="memPhone"
						value="${memberItem.memPhone}"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="memEmail"
						value="${memberItem.memEmail}"></td>
				</tr>
				<tr>
					<td>가입일</td>
					<td>${memberItem.regDate}</td>
				</tr>
				<tr>
					<td colspan="2">

						<button type="submit" name="btnSave">저장</button>

					</td>

				</tr>
			</tbody>
		</table>
	</form>




</body>
</html>