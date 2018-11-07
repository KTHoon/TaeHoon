<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here (넥스트 IT)</title>


</head>
<body>


	<h1>회원 수정 (폼)</h1>
	
	<form action="<c:url value="/member/memberUpdateProc.do"/>" method="post">
	
		<table class="table">
			<tbody>
				<tr>
					<td>아이디</td>
					<td><input type="text" readonly="readonly" name="memId"
						value="${memberItem.memId}"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="memName"
						value="${memberItem.memName}"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="memPwd" value="${memberItem.memPwd}"></td>
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

						<button type="submit">저장</button>

					</td>

				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>