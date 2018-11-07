<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<title>인덱스 메인 (/index.do)</title>
</head>
<body>
	<h1 class="page-header">userIp ${userIp }</h1>
	<h1 class="page-header">인덱스 메인 (/index.do)</h1>

	<pre>
	${name }
	${param.name2 }
	========================================
	${testTitle }
	
	<spring:message code="fail.common.sql" arguments="9999, 오타 일까" />
	<spring:message code="fail.common.sql" arguments="8888|| 나도 몰라.."
			argumentSeparator="||" />
	<spring:message code="info.nodata.msg" />
	
	
	<c:forEach var="rs" items="${ipList }">
		key :  ${ rs.key}
		value : ${ rs.value}
	</c:forEach>
</pre>
</body>
</html>










