<%--
	 JSP 지시어
	 
	 : <%@ ... %> 형태로 작성
	 : 실행 코드가 아니라 페이지 자체의 설정을 지정
 --%>
<%-- page 지시어: 응답 타입, 인코딩 형식을 지정 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 지시어</h1>
	
	<h3>1) page 지시어로 import</h3>
	<p>
		현재 시각: <%= new Date() %>
	</p>
	
	<h3>2) include 지시어로 공통 헤더/푸터 포함하기</h3>
	<p>
		include 지시어는 컴파일 시점에 파일 내용을 그대로 해당 영역에 붙여넣는 방식
	</p>
	<%@ include file="/common/header.jsp" %>
	<p> 여기는 본문 내용입니다 ~ </p>
	<%@ include file="/common/footer.jsp" %>
	
	<h3>3) taglib 지시어</h3>
	<p>
		taglib 지시어는 다른 라이브러리를 연결하고자 할 때 사용. <br>
		prefix (prefix="c") 를 설정하면, c:태그명과 같이 jsp 코드를 작성할 수 있음.
	</p>
	
	<a href="/jsp">첫 페이지로 이동...</a>
</body>
</html>




