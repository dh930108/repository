<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
$(document).ready(function(){  //Jquery 시작

	
//	$(".yb").click(function(){
//});
});
</script>
<link rel="stylesheet" href="/my.css">
</head>
<body>
<table class="steelBlueCols">
<thead>
<tr>
<th>empno</th>
<th>ename</th>
<th>job</th>
<th>hiredate</th>
</tr>
</thead>
<tbody>
<c:forEach items="${KEY_LIST}" var="vovo">
 <tr>
  <td>${vovo.empno}</td>
  <td>${vovo.ename}</td>
  <td>${vovo.job}</td>
  <td>${vovo.hiredate }</td>
 </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>