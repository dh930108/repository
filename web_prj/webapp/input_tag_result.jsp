<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
forward 결과페이지...<hr>

redirect === http://localhost:8088/input_tag_result.jsp
forward  === http://localhost:8080/input_tag.jsp



<%
ArrayList<String> resMList
	= (ArrayList<String>)request.getAttribute("KEY_MLIST");
for(String str : resMList) {
	out.println(str + "<Br>");
}
ArrayList<String> resCList
	= (ArrayList<String>)request.getAttribute("KEY_CLIST");
for(String str : resCList) {
	out.println(str + "<Br>");
}
%>



</body>
</html>