<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here (넥스트 IT)</title>

<script type="text/javascript">
	$(document).ready(function() {

		// button/input : id 명으로 이벤트 처리 (#이름)
		$("#btnJsonTest").on("click", function(e) {
			alert("button Id click");
		})

		// button/input : class 명으로 이벤트 처리 (.이름)
		$(".btnJsonTest").on("click", function(e) {
			alert("class Id click");
		})

		$("#btnJsonTestMap").on("click", function(e) {
			e.preventDefault(); // 이벤트 전파 막기 
			$.ajax('/json/responseEntity.json', {
				method : "POST",
				dataType : 'json', // type of response data
				data : {
					key : "value"
				},
				success : function(data, status, xhr) { // success callback function
					console.log(data);
					//alert(data);  // object
					alert(JSON.stringify(data)); // Object to String:Json 포멧

					$("#testDisplay").empty();
					$.each(data, function(key, value) {
						console.log(value);
						var rs = "";
						rs += '<tr>';
						rs += '	<th> ' + key + '  </th>';
						rs += '	<th> ' + value + '</th>';
						rs += '</tr>';
						$("#testDisplay").append(rs);
					});

				},
				error : function(jqXhr, textStatus, errorMessage) { // error callback 
					console.log(jqXhr);
					console.log(textStatus);
					console.log(errorMessage);
				}
			});
		});

		$("#btnJsonTestList").on("click", function(e) {
			e.preventDefault(); // 이벤트 전파 막기 
			$.ajax('/json/responseEntity2.json', {
				method : "POST",
				dataType : 'json', // type of response data
				data : {
					key : "value"
				},
				success : function(data, status, xhr) { // success callback function
					console.log(data);
					//alert(data);  // object
					alert(JSON.stringify(data)); // Object to String:Json 포멧
					$("#testDisplay").empty();

					$.each(data, function(key, value) { // List 객체에서 map 객체를 0 번지 값을 가지고옴
						console.log(value);
						alert(key);
						alert(JSON.stringify(value));
						$.each(value, function(idx, item) { // map 객체에서 Key, Value 값을 가지고옴.
							var rs = "";
							rs += '<tr>';
							rs += '	<th> ' + idx + '  </th>';
							rs += '	<th> ' + item + '</th>';
							rs += '</tr>';
							$("#testDisplay").append(rs);
						});

					});

				},
				error : function(jqXhr, textStatus, errorMessage) { // error callback 
					console.log(jqXhr);
					console.log(textStatus);
					console.log(errorMessage);
				}
			});
		});

		$("#btnJsonTestList2").on("click", function(e) {
			e.preventDefault(); // 이벤트 전파 막기 
			$.ajax('/json/responseEntity2.json', {
				method : "POST",
				dataType : 'json', // type of response data
				data : {
					key : "value"
				},
				success : function(data, status, xhr) { // success callback function
					console.log(data);
					//alert(data);  // object
					alert(JSON.stringify(data)); // Object to String:Json 포멧
					$("#testDisplay").empty();

					$.each(data, function(key, value) { // List 객체에서 map 객체를 0 번지 값을 가지고옴
						console.log(value);
						alert(key);
						alert(JSON.stringify(value));
						var rs = "";
						rs += '<tr>';
						rs += '	<th> 순번 : ' + key + '  </th>';
						rs += '	<th> ' + value.name1 + '</th>';
						rs += '	<th> ' + value.name2 + '</th>';
						rs += '	<th> ' + value.name3 + '</th>';
						rs += '</tr>';
						$("#testDisplay").append(rs);

					});

				},
				error : function(jqXhr, textStatus, errorMessage) { // error callback 
					console.log(jqXhr);
					console.log(textStatus);
					console.log(errorMessage);
				}
			});
		});

		$("#btnJsonTestList3").on("click", function(e) {
			e.preventDefault(); // 이벤트 전파 막기 
			$.ajax('/json/responseEntity4.json', {
				method : "POST",
				dataType : 'json', // type of response data
				data : {
					key : "value"
				},
				success : function(data, status, xhr) { // success callback function
					console.log(data);
					if (data.state) {
						
						$("#testDisplay").empty();
						$.each(data.memberList, function(key, value) { 
							console.log(value);

							var rs = "";
							rs += '<tr>';
							rs += '	<th> 순번 : ' + value.num + '  </th>';
							rs += '	<th> ' + value.memId + '</th>';
							rs += '	<th> ' + value.memName + '</th>';
							rs += '	<th> ' + value.memPhone + '</th>';
							rs += '	<th> ' + value.memEmail + '</th>';
							rs += '	<th> ' + value.regDate + '</th>';
							rs += '</tr>';
							$("#testDisplay").append(rs);

						});
					} else {
						// 에러가 발생 했을 경우.
						alert(data.message);
					}

				},
				error : function(jqXhr, textStatus, errorMessage) { // error callback 
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
	<a href="<c:url value="/json/responseEntity.json"/>" target="_blank">responseEntity
		Test1</a>
	<a href="<c:url value="/json/responseEntity2.json"/>" target="_blank">responseEntity
		Test2</a>
	<a href="<c:url value="/json/responseEntity3.json"/>" target="_blank">responseEntity
		Test3</a>
	<a href="<c:url value="/json/responseEntity4.json"/>" target="_blank">responseEntity
		Test4</a>


	<table class="table">
		<tbody>
			<tr>
				<th>
					<button id="btnJsonTest">button Id Click</button>
					<button class="btnJsonTest">css class click</button>
				</th>
			</tr>
			<tr>
				<th>
					<button id="btnJsonTestMap">Map return</button>
				</th>
				<th>
					<button id="btnJsonTestList">List return</button>
				</th>
				<th>
					<button id="btnJsonTestList2">List return 2</button>
				</th>
				<th>
					<button id="btnJsonTestList3">List return 3</button>
				</th>
			</tr>
		</tbody>
	</table>






	<table class="table">
		<tbody id="testDisplay">

		</tbody>
	</table>

















</body>
</html>