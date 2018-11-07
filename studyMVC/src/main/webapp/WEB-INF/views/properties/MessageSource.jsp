<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:url var="koUrl" value="/messagesource.do">
	<c:param name="Language" value="ko" />
</c:url>
<a href="${koUrl}">한글</a>

<c:url var="enUrl" value="/messagesource.do">
	<c:param name="Language" value="en" />
</c:url>
<a href="${enUrl}">영어</a>


	<pre>
	
		fail.common.sql=sql 에러가 발생했습니다! error code: {0}, error msg: {1}
		<spring:message code="fail.common.sql" arguments="9999, 오타 일까요" />
		<spring:message code="fail.common.sql" arguments="9999 || 오타 일까요" argumentSeparator="||" />
		
		info.nodata.msg=해당 데이터가 없습니다.
		<spring:message code="info.nodata.msg" />
	</pre>
</body>
</html>