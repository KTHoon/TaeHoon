<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 (넥스트 IT)</title>
</head>
<body>
	<h1 class="page-header">userIp ${userIp }</h1>
	
	<form:form commandName="loginVo" method="post" action="/session/actionLoginProc.do">
		<table class="table">
			<tr>
				<td>아이디</td>
				<td><form:input path="memId" /></td>
			</tr>

			<tr>
				<td>비밀번호</td>
				<td><form:password path="memPwd" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">로그인</button>
				</td>
			</tr>
		</table>
	</form:form>
	
	<pre>
		<c:forEach var="rs" items="${ipList }">
		key :  ${ rs.key}
		value : ${ rs.value}
	</c:forEach>
	</pre>

</body>
</html>