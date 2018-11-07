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

<title>파일 업로드 테스트 (넥스트 IT)</title>
<script type="text/javascript" defer="defer">
	$(document).ready(function(){
		$(".btn_file_new").on("click",function(){
			var fileView="";
			fileView +='<div>';
			fileView +=	'<input type="file" name="attachFiles">';
			fileView += '<button type="button"';
			fileView += 'class="btn_file_remove form-control">삭제</button>';
			fileView += '</div>';
			
			$(".file_area").append(fileView);
		});
		
		//신규 파일 삭제
		$(".file_area").on("click",".btn_file_remove",function(){
			$(this).parent().remove();
		});
		
		
		//폼(submit) 이벤트
		$("#fileVo").on("submit",function(event){
			event.preventDefault();
			$(this).ajaxSubmit({
				type : 'post',
				url : '/attach/ajaxSubmitProc.json',
				data : $('#fileVo').serialize(),
				sucess:function(msg){
					alert(JSON.stringfy(msg));
				},
				error : function(jqXhr,textStatus,errorMessage){
					alert(errorMessage);
				}
			});
		});
	});

</script>
</head>
<body>

	<h1>파일 업로드 Old</h1>

	<form:form commandName="attachVo" action="/attach/uploadProc.do"
		method="post" enctype="multipart/form-data">
		<input type="text" name="serviceType" value="test">
		<table class="table">
			<tbody>
				<tr>
					<td>첨부파일</td>
					<td><input type="file" name="attachFiles"> <input
						type="file" name="attachFiles"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">파일 전송</button>
					</td>
				</tr>
			</tbody>
		</table>

	</form:form>

	<hr>

	<h1>파일 업로드 new(ajaxSubmit)</h1>
	<c:url var="frmAction" value="/attach/uploadProc.do" />
	<form id="fileVo" name="fileVo" method="post"
		enctype="multipart/form-data">
		<input type="text" name="serviceType" value="notice">

		<table class="table">
			<tbody>
				<tr>
					<td>제목</td>
					<td><input type="text" name="boTitle" size="60"></td>
				</tr>

				<tr>
					<td>작성자</td>
					<td><input type="text" name="boWriter" size="15"></td>
				</tr>

				<tr>
					<th>첨부파일</th>
					<td>
						<div class="file_area">
							<div>
								<button type="button" class="btn_file_new form-control">추가</button>
							</div>
						</div>
						<div>
							<div>
								<input type="file" name="attachFiles">
								<button type="button" class="btn_file_remove form-control">삭제</button>
							</div>
						</div>
					</td>
					<!-- <td><input type="file" name="attachFiles"></td> -->
				</tr>

				<tr>
					<td colspan="2">
						<button type="submit" id="btn_submit">저장</button>
					</td>
				</tr>
			</tbody>
		</table>

	</form>




</body>
</html>