<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록 (넥스트 IT)</title>


<script type="text/javascript" defer="defer">
$(document).ready(function(){	
	
	$frm = $('#memberSearchVo');
	// 서브밋 버튼 클릭시   
	$('button[type=submit]', $frm).click(function(e){
		e.preventDefault(); // 이벤트 전파 막기 
		$('input[name=curPage]', $frm).val(1);
		$frm.submit();
	});
	
	// class="goPage" Id 버튼 클릭시
	$(".goPage").click(function() {
		//alert($(this).data("curpage"));
		var curPage = $(this).data("curpage");
		$('input[name=curPage]').val(curPage);
		$frm.submit();
	});
});
</script>
</head>
<body>

	<h1>회원 목록</h1>

	<form id="memberSearchVo" name="memberSearchVo" action="/member/memberList.do" method="post">
	
		<input type="text" name="curPage" value="${memberSearchVo.curPage}">
		<input type="text" name="screenSize" value="${memberSearchVo.screenSize}">
		
		<table class="table">
			<thead>
				<tr>
					<th colspan="4">
						<select name="searchType">
							<option value="mem_id" 
									${param.searchType eq 'mem_id' ? 'selected="selected"': ''}>아이디</option>
							<option value="mem_name" 
									${param.searchType eq 'mem_name' ? 'selected="selected"': ''}>이름</option>
						</select> 
						<input type="text" name="searchText" value="${param.searchText}">
						<button type="submit">검색</button>
						
						<a href="<c:url value="/member/memberInsert.do"/>">회원가입</a>
					</th>
				</tr>
			</thead>

			<thead>
				<tr>
					<th>순번</th>
					<th>아이디</th>
					<th>이름</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="memberVo" items="${memberList }">
					<c:url var="viewUrl" value="/member/memberView.do">
						<c:param name="memId" value="${memberVo.memId}"/>
					</c:url>
					<tr>
						<td>
							<a href="${viewUrl}">
								${memberVo.num }
							</a>
						</td>
						<td>
							<a href="${viewUrl}">
								${memberVo.memId }
							</a>
						</td>
						<td>${memberVo.memName }</td>
						<td>${memberVo.regDate }</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		

			<nav>
		      <ul class="pagination pagination-lg">
		      
				<!-- // 이전버튼  -->
				<c:if test="${memberSearchVo.startPage != 1}">
			        <li>
			          <a href="#" data-curpage="${memberSearchVo.startPage - 1}"
								  class="prev goPage" 
								  aria-label="Previous">
			            <span aria-hidden="true"> << 이전 </span>
			          </a>
			        </li>
				</c:if>
				
				<c:if test="${memberSearchVo.startPage eq 1}">
			        <li>
			          <a aria-label="Previous">
			            <span aria-hidden="true"> << 이전</span>
			          </a>
			        </li>
				</c:if>
				

				<c:forEach var="i" begin="${memberSearchVo.startPage}" 
								   end="${memberSearchVo.endPage}">
					<c:choose>
						<c:when test="${i eq memberSearchVo.curPage}">
							<li class="active"> <a >${i}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="#" data-curpage="${i}" class="goPage">${i}</a></li>
						</c:otherwise>
					</c:choose>
					
				</c:forEach>
				
				
				

				<!-- // 다음버튼  -->
				<c:if test="${memberSearchVo.endPage < memberSearchVo.totalPageCount}">
					<li>
			          <a href="#" data-curpage="${memberSearchVo.endPage + 1}" 
			          			  class="next goPage"  
			          		      aria-label="Next" title="Next">
			            <span aria-hidden="true">다음 »</span>
			          </a>
			        </li>
				</c:if>
				
				<c:if test="${memberSearchVo.endPage >= memberSearchVo.totalPageCount}">
 					<li>
			          <a aria-label="Next" title="Next">
			            <span aria-hidden="true">다음 »</span>
			          </a>
			        </li>
				</c:if>
				
		      </ul>
		    </nav>
	
		
		
		
		
		
	</form>

</body>
</html>






