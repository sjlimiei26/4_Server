<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	* jsp:include
		- include 지시어와 유사하지만 동작 시점이 다름 (컴파일 시점에 코드가 합쳐지는 방식, 정적)
		- 액션태그 include : 요청이 들어올 때마다 해당 페이지를 실행한 결과를 삽입 (동적)
				=> 페이지의 로직이 매 요청마다 실행되므로 변동 데이터 표시에 적합
				
	* jsp:forward
		- 서버 내부에서 다른 jsp 페이지로 제어를 넘기는 방식
		- 클라이언트 모르게 서버에서만 처리 페이지가 바뀜 => 브라우저 URL은 바뀌지 않음
			--> request 객체가 그대로 유지되므로 파라미터는 전달됨! 
 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 액션 태그</h1>
	
	<h3> 액션태그 include </h3>
	
	<jsp:include page="/common/header.jsp" />
	<%--  <jsp:include page="/common/header.jsp"></jsp:include> --%>
	<p> 여기는 본문 내용 영역 입니다 ~~~~ </p>
	<jsp:include page="/common/footer.jsp" />
	
	<h3> 액션태그 forward </h3>
	<p>
		<a href="05_action_tags.jsp?go=true">여기</a>를 클릭 시 forward 됨.
	</p>
	<%
		String go = request.getParameter("go");
	
		if (go != null && go.equals("true")) {
	%>
		<jsp:forward page="/02_script_elements.jsp" />
	<% } %>
</body>
</html>


