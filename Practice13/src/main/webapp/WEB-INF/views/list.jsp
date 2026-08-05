<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Music Manager</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5 mb-5">
		<h1> My Music List </h1>
		
		<table class="table table-hover mt-5">
			<thead>
				<tr>
					<th>No</th>
					<th>곡명</th>
					<th>가수명</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${ empty musicList }">
					<tr>
						<td colspan="3">저장된 곡 정보가 없습니다.</td>
					</tr>
				</c:if>
				
				<c:forEach var="music" items="${ musicList }" varStatus="status">
					<tr>
						<td>${ status.count }</td>
						<td>${ music.title }</td>
						<td>${ music.singer }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>