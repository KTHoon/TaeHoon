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

	<h1>회원 상세정보</h1>


	<table class="table">
		<tbody>
			<tr>
				<td>사진</td>
				<td><img alt="" src="/attach/download/${memberItem.seqNo}"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>${memberItem.memId}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${memberItem.memName}</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${memberItem.memPhone}</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${memberItem.memEmail}</td>
			</tr>
			<tr>
				<td>가입일</td>
				<td>${memberItem.regDate}</td>
			</tr>
			<tr>
				<td colspan="2"><c:url var="updateUrl"
						value="/member/memberUpdate.do">
						<c:param name="memId" value="${memberItem.memId }" />
					</c:url> <a href="${updateUrl}">수정</a> <c:url var="deleteUrl"
						value="/member/memberDelete.do">
						<c:param name="memId" value="${memberItem.memId }" />
					</c:url> <a href="${deleteUrl }">삭제</a> <a
					href="<c:url value="/member/memberList.do"/>"> 목록</a></td>

			</tr>
		</tbody>
	</table>
</body>
</html>