<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title><sitemesh:write property='title' /></title>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="<c:url value="/css/bootstrap.css"/>">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="<c:url value="/css/bootstrap-theme.css"/>">
<link rel="stylesheet" href="<c:url value="/css/dashboard.css"/>">


<script src="<c:url value="/js/jquery-3.3.1.js"/>"></script>
<script src="<c:url value="/js/jquery.form.js"/>"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="<c:url value="/js/bootstrap.js"/>"></script>


<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="<c:url value="/js/holder.js" />"></script>


<sitemesh:write property='head' />


<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value="/" />">김태훈 Project</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<c:url value="/test/index.do" />">test
							SiteMesh</a></li>
					<li><a href="#">Settings</a></li>
					<li><a href="#">Profile</a></li>
					
					<c:choose>
						<c:when test="${loginInfo !=null }">
							<c:url var="loginUrl" value="/session/actionLogOut.do" />
							<li>
								
								<a href="${loginUrl }">${loginInfo.memName}로그아웃</a>
							</li>
						</c:when>
						
						<c:otherwise>
							<c:url var="loginUrl" value="/session/actionLoginForm.do" />
							<li><a href="${loginUrl }">로그인</a></li>
							<c:url var="joinUrl" value="/member/memberInsert.do" />
							<li><a href="${joinUrl }">회원가입</a></li>
						</c:otherwise>
					</c:choose>
					

					<c:url var="koUrl" value="/messagesource.do">
						<c:param name="language" value="ko" />
					</c:url>
					<li><a href="${koUrl}">한글</a></li>

					<c:url var="enUrl" value="/messagesource.do">
						<c:param name="language" value="en" />
					</c:url>
					<li><a href="${enUrl}">영어</a></li>

				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav>




	<div class="container-fluid">


		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="<c:url value="/" />">Overview <span
							class="sr-only">(current)</span></a></li>

					<li class="active"><a
						href='<c:url value="/member/memberList.do"/>'>회원관리</a></li>

					<li><a href="<c:url value="/jsonTest" />">json Test</a></li>
					<li><a href="<c:url value="/messagesource.do"/>">message
							Source</a></li>
					<li><a href="<c:url value="/propertyService.do"/>">property
							Service</a></li>

				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="<c:url value="/attach/uploadForm.do"/>">파일
							업로드 Test</a></li>
					<li><a href="">Nav item again</a></li>
					<li><a href="">One more nav</a></li>
					<li><a href="">Another nav item</a></li>
					<li><a href="">More navigation</a></li>
				</ul>
			</div>


			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<sitemesh:write property='body' />
			</div>


		</div>

	</div>

</body>
</html>
