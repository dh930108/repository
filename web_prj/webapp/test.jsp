<!--  지시어 : page Directive -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<table border="2" width="300" height="150">
<tr>
<td colspan="3" align="center">제품코드(4) 입력</td>
</tr>
<tr>
<td>제품코드</td>
<td colspan="2"><input type="text"></td>
</tr>
<tr>
<td colspan="3" align="center"><input type="submit" value="확인"></td>
</tr>
</table>


<a target="blank" href="/abc?uid=한글&upw=2233"><img width="200" height="200" src="https://s-i.huffpost.com/gen/2311614/images/n-POOH-628x314.jpg"></a><br>



<form method="post" action="/abc">
  <input type="text" name="uid">
  <input type="text" name="upw">
  <input type="submit" value="누르지마시오">
</form>
</body>
</html>