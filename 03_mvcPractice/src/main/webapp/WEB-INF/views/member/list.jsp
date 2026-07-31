<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.kh.mvc.model.MemberDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원 목록 </h1>
	
	<a href="/mvc/member/insert.html">회원 등록</a>
	
	<table border="1">
		<thead>
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
					<a href="#">삭제</a>
				</td>
			</tr>
			
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>


