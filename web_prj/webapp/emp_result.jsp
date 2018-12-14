<%@page import="com.kosmo.web.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>emp_result</title>
</head>
<body>

<%

ArrayList<EmpVO> resList
= (ArrayList<EmpVO>)request.getAttribute("KEY_LIST");

out.println("조회건수  : " + resList.size());
out.println("<hr>");
for(EmpVO evo : resList) {
	
out.println("사번  : " + evo.getEmpno() + "<Br>");
out.println("이름  : " + evo.getEname() + "<Br>");
out.println("직무  : " + evo.getJob() + "<Br>");
out.println("연봉  : " + evo.getSal() + "<Br>");
out.println("부서  : " + evo.getDeptno() + "<Br>");
out.println("<hr>");
}

%>


</body>
</html>