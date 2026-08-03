<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 내장 객체</h1>
	<%--
		request, response, session, application, out, ...
		JSP 에서 별도로 선언하지 않아도 자동으로 사용 가능한 내장 객체
		
		* request : 클라이언트의 요청 정보를 담은 객체.
					1번의 요청마다 새로운 request 객체가 생성되고, 요청이 끝나면 사라짐.
					
		* session : 같은 브라우저를 사용하는 사용자만의 저장 공간.
					브라우저를 닫거나 세션 만료시까지 유지됨. (주로 로그인 정보 저장 용도)
					
		* application : 서버 실행 중 모든 사용자가 공유하는 저장 공간.
					    서버를 재시작하면 초기화됨.
	 --%>
	 <%
	 	String name = request.getParameter("name");
	 	if (name == null || name.isEmpty()) {
	 		name = "게스트";
	 	}
	 %>
	 <h3>request - 요청 파라미터</h3>
	 <p> name : <%= name %> </p>
	 
	 <%
	 	session.setAttribute("userName", name);
	 %>
	 <h3>session - 사용자별 분리된 저장소</h3>
	 <p> userName : <%= session.getAttribute("userName") %> </p>
	 
	 <%
	 	Integer visitCount = (Integer)application.getAttribute("visitCount");
	 
	 	// 서버 시작 후 처음에는 null 값일 것임 => 0으로 초기화
	 	if (visitCount == null) {
	 		visitCount = 0;
	 	}
	 	
	 	visitCount++;
	 	application.setAttribute("visitCount", visitCount);
	 %>
	 <h3>application - 모든 사용자가 공유하는 저장소</h3>
	 <p> visitCount : <%= visitCount %> </p>
	 
	 <a href="/jsp">첫 페이지로 이동...</a>
</body>
</html>




