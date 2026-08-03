<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList" %>    
<%@ page import="com.kh.model.MemberDTO" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL Core Library</h1>
	
	<%-- ================= 변수 ================= --%>
	<h3> 변수 (c:set / c:remove / c:out)</h3>
	<%--
		* c:set
			- EL 변수를 선언하고 값을 저장
			- 내부적으로 pageContext.setAttribute("변수명", 값) 와 동일하게 동작
			  => scope 지정하지 않으면 기본값으로 page 영역에 저장
	 --%>
	<c:set var="num1" value="10" />
	num1 : ${ num1 } <br>
	
	<c:set var="num2" value="20" scope="request" />
	<%-- scope : page / request / session / application --%>
	num2 : ${ num2 } <br>
	
	<%-- TODO: result 변수를 session 영역에 저장 (num1과 num2의 합) --%>
	<c:set var="result" scope="session" value="${ num1 + num2 }" />
	result : ${ result } <br>
	
	<%--
		* c:remove
			- EL 변수를 삭제
			- scope 를 지정하면 해당 범위의 변수만 삭제되고,
				scope 를 지정하지 않으면 모든 범위(page, request, session, application)에서 삭제됨.
	 --%>
	<c:remove var="num2" scope="request" />
	num2 : ${ num2 } <br>
	
	<%-- TODO: request 영역의 result 변수 삭제 --%>
	<c:remove var="result" scope="request" />
	result : ${ result } <br>
	
	<c:remove var="result" />  <%-- 모든 영역에서 result 변수 삭제 --%>
	result : ${ result } <br>
	
	<%--
		* c:out
			- EL 표현식으로 값을 출력
			- default 속성 : 값이 null 이거나 없을 때 기본값으로 출력
	 --%>
	result (c:out) : <c:out value="${ result }" /> <br>
	result (c:out + default) : <c:out value="${ result }" default="없음" /> <br>
	
	<hr>
	
	<%-- ============ 조건문 =============== --%>
	<h3> 조건문 - if (c:if test="조건식") </h3>
	
	<%-- 기존 스크립틀릿 --%>
	<% if (10 > 20) {  %>
		<strong>10이 20보다 큽니다.</strong>
	<% } %>
	
	<%-- jstl core lib --%>
	<c:if test="${ 10 > 20 }">
		<strong>10이 20보다 큽니다.</strong>
	</c:if>
	
	<%-- 조건이 true일 때만 내부 태그를 출력. (else 구문이 없음) --%>
	<c:set var="n1" value="10"/>
	<c:set var="n2" value="20"/>
	
	<c:if test="${ n1 > n2 }">
		<p>n1이 n2보다 큽니다</p>
	</c:if>
	
	<c:if test="${ n1 < n2 }">
		<p>n2가 n1보다 큽니다.</p>
	</c:if>
	
	<c:set var="color" value="red" />
	Java: color == "red" (x) --> color.equals("red")
	<c:if test="${ color == 'red' }">
		<p style="color:${ color }" >${ color }</p>
	</c:if>
	<%-- Java 에서는 문자열 비교 시 .equals() 를 사용해야 비교가 되었는데,
		 EL 에서는 == 연산자로 문자열 비교가 가능! 
	--%>
	
	<h3> 조건문 - 다중 분기 (c:choose / c:when / c:otherwise)</h3>
	<%--
		* c:choose
			- Java에서 if ~ else if ~ else 또는 switch~case 에 해당. (전체를 감싸는 태그)
		* c:when
			- 조건을 작성하며, 각 조건이 true 인 블록만 실행 (처음으로 true인 블록이 있으면 해당 블록만 실행)
		* c:otherwise
			- 모든 c:when 이 false 일 때 실행되는 기본값 블록 ( else, default 과 유사 )
	 --%>
	<c:choose>
	
		<c:when test="${ n1 > 30 }">
			<p> n1이 30보다 큽니다. </p>
		</c:when>
		
		<c:when test="${ n1 > 20 }">
			<p> n1이 20보다 큽니다. </p>
		</c:when>
		
		<c:when test="${ n1 > 9 }">
			<p> n1이 9보다 큽니다 </p>
		</c:when>
		
		<c:otherwise>
			<p> 모든 조건에 해당되지 않습니다 </p>		
		</c:otherwise>
	
	</c:choose>
	
	<%-- =============== 반복문 ================== --%>
	<h3> 반복문 - c:forEach</h3>
	<p>
		- 횟수만큼 반복 (begin / end / step) <br>
		- 배열, 컬렉션 반복 (items)
	</p>
	
	<%-- 1부터 시작해서 10까지 반복 (간격은 2씩 증가) => 1, 3, 5, 7, 9 --%>
	<c:forEach var="i" begin="1" end="10" step="2">
		* 반복: ${ i } <br>
	</c:forEach>
	
	<%-- 제목태그(h_)를 반복문으로 생성 --%>
	<c:forEach var="i" begin="1" end="6">
		<h${ i }> h${ i } 제목 태그  </h${ i }>		
	</c:forEach>
	
	<%-- MemberDTO 객체를 리스트에 추가 --%>
	<%
		List<MemberDTO> list = new ArrayList<>();
	
		list.add( new MemberDTO(1, "임수진", "sj___@gmail.com", 20) );
		list.add( new MemberDTO(2, "박수진", "wewe@gmail.com", 30) );
		list.add( new MemberDTO(3, "홍수진", "aaa@gmail.com", 40) );
	%>
	
	<%-- request scope 에 memberList 라는 이름으로 저장 --%>
	<c:set var="memberList" scope="request" value="<%= list %>" />
	
	<table border="1">
		<thead>
			<tr>
				<th>회원 번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>나이</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="m" items="${ memberList }">
				<tr>
					<td>${ m.id }</td>
					<td>${ m.name }</td>
					<td>${ m.email }</td>
					<td>${ m.age }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>













