<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList" %>    
<%! 
	/*
		* 선언부
		  : 변환된 서블릿 클래스의 "필드/메소드 영역"에 해당됨.
		  
		  [주의] 이 영역의 변수는 모든 사용자의 요청에서 공유됨.
		        멀티 스레드 환경에서 동시 요청 시 값이 꼬일 수 있으므로 주의해야 함.
		        (거의.. 사용하지 않음)
	*/
	private int callCount = 0;

	private int add(int n1, int n2) {
		return n1 + n2;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 스크립트 요소</h1>
	
	<h3>1) 선언부 &lt;%! ... %&gt;</h3>
	<h3>2) 스크립틀릿 &lt;% ... %&gt;</h3>
	<%
		/*
			* 스크립틀릿
			  : 서블릿의 service() 메소드 내부에 삽입되는 자바 코드 작성 영역.
			  : 요청이 들어올 때 마다 실행됨.
		*/
		callCount++;
	%>
	<h3>3) 표현식 &lt;%= ... %&gt;</h3>
	<p>누적 호출 횟수: <%= callCount %></p>
	<p> 3 + 4 = <%= add(3, 4) %></p>
	
	<%
		List<String> fruits = new ArrayList<>();
	
		fruits.add("복숭아");
		fruits.add("귤");
		fruits.add("포도");
		fruits.add("수박");
		fruits.add("딸기");
	%>

	<ul>
		<% for(String f : fruits) { %>
		
		<li><%= f %></li>
		
		<% } %>
	</ul>	
	
	<h3>4) 주석 &lt;%-- ... --%&gt;</h3>
	<%-- JSP 주석은 서버에서 처리되므로 최종 HTML에는 포함되지 않음 (브라우저의 개발자도구로 확인 불가) --%>
	<!-- HTML 주석은 브라우저로 전송되므로 개발자 도구에서 확인 가능 -->
	
	<a href="/jsp">첫 페이지로 이동...</a>
</body>
</html>








