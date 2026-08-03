<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.model.MemberDTO" %>
<%--
	* EL (Expression Language)
	  : request.getAttribute(...) 와 같은 자바 코드를
	    ${표현식} 과 같은 간결한 문장으로 대체해 줌.
 --%>
<%
	request.setAttribute("name", "임수진");
	request.setAttribute("age", 20);
	
	MemberDTO m = new MemberDTO("임수진", 20);
	request.setAttribute("member", m);
	
	java.util.List<String> list = new java.util.ArrayList<>();
	list.add("테스트");
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 문법</h1>
	
	<h3>기존 JSP 문법 vs EL 문법</h3>
	<p>
		표현식 (name) : <%= request.getAttribute("name") %>
	</p>
	<p>
		EL (name) : ${ name }
	</p>
	
	<h3>EL 탐색 범위</h3>
	<h4>
		pageScope -> requestScope -> sessionScope -> applicationScope
	</h4>
	<p>
		${ name } : 범위 지정 없이 특정 값을 검색 시, 순차적으로 찾아서 출력
	</p>
	<p>
		${ sessionScope.name } : 특정 스코프를 명시적으로 지정. 해당 스코프에서만 찾아서 출력
	</p>
	
	<h3>객체에서 필드값에 접근 (getter)</h3>
	<%--
		${ 변수명.필드명 } 작성 시 해당 객체의 get필드명() 처럼 getter를 내부적으로 호출함.
		즉, 필드가 private 이어도 EL로 접근 가능.
	 --%>
	 <p> 이름: ${ member.name } </p>
	 <p> 나이: ${ member.age } </p>
	 
	 <h3>EL 연산자</h3>
	 <p> 산술연산: 1 + 2 = ${ 1 + 2 }</p>
	 <p> 비교연산: 삼항연산자.. 조건식 ? 참일때값 : 거짓일때값 => ${ age >= 20 ? "성인" : "미성년자" }</p>
	 <p>
	 	empty 연산 (리스트에 값이 비어있는지 확인) : ${ empty list }
	 	<%-- 해당 리스트가 비어있거나 null 인 경우 true 반환 --%>
	 </p>
</body>
</html>



