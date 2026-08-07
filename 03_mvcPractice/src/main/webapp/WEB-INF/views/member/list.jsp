<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.kh.mvc.model.MemberDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

</head>
<body>
	<div class="container mt-5">
		<h1> 회원 목록 </h1>
		
		<a href="/mvc/member/insert.html" class="btn btn-primary float-end mb-3">회원 등록</a>
		
		<table border="1" class="table table-striped table-hover">
			<thead class="table-info">
				<tr>
					<th>회원 번호</th>
					<th>이름</th>
					<th>이메일</th>
					<th>나이</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<%-- 조회 결과는 request 영역에 memberList 이름으로 저장되어 있음! --%>
				<%
					List<MemberDTO> list = (List<MemberDTO>)request.getAttribute("memberList");
					for(MemberDTO m : list) {
				%>
				
				<tr>
					<td><%= m.getId() %></td>
					<td><%= m.getName() %></td>
					<td><%= m.getEmail() %></td>
					<td><%= m.getAge() %></td>
					<%-- 
						TODO: 삭제 기능 
							- 요청 주소: /member/delete
							- 요청 파라미터: id=회원번호
					--%>
					<td>
						<a href="/mvc/member/delete?id=<%= m.getId() %>">삭제</a>
					</td>
				</tr>
				
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>


