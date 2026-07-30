<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- HTML 주석 -->
<%--
	JSP 주석
	
	JSP(Java Server Page) : HTML 안에 Java 코드를 작성할 수 있는 서버 사이드 템플릿
							서버에서 Java 코드가 실행된 결과(HTML)가 브라우저로 전송됨
							
	* 주요 문법 *
	1. <%-- 내용 --\%>   : JSP 주석. 서버에서만 처리되고 클라이언트에 전송되지 않음.
	2. <!-- 내용 -->     : HTML 주석. 브라우저 개발자 도구(요소)에서 보여짐.
	
	3. <%= 표현식 %>		: 값을 출력하는 표현식. response.getWriter().println() 와 동일하게 동작.
	4. <% 코드 %>		: Java 코드를 그대로 실행하는 스크립틀릿. 
	5. <%@ 지시자 %>		: 페이지 속성 설정. 현재 문서의 최상단에 page 지시자.
 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>포워드/리다이렉트 결과 페이지</h1>
	
	<h3>전달 받은 message: <%= request.getAttribute("message") %> </h3>
	<p>forward로 응답된 경우, message 값이 정상적으로 출력됨</p>
</body>
</html>