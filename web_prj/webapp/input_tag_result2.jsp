<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
$(document).ready(function() {
	
	var haarr = new Array();
	
	<c:forEach var="str" items="${habit}" >
	 haarr.push("${str}");
	</c:forEach>
	0
	
	
	$.each(haarr, function(i, v){
		$("[name=habit][value='" + v + "']").atrr("checked","checked");
	});
	
	
	
	
	 $("#btn").click(function() { 
		/*if($("#uid").text() == ""){
			alert("아이디?");
			$("#uid").focus();
			return false;
		}; */
		
		console.log("uid     : " +$("#uid").val());
		console.log("upw     : " +$("#upw").val());
		console.log("ufile   : " +$("#ufile").val());
		console.log("tel     : " +$("#tel option:selected").val());
		console.log("content : " +$("#content").val());
		console.log("gen     : " +$(".gen:checked").val());
		console.log("habit   : " +<%=request.getAttribute("habit")%>);
		

	});
});
</script>

</head>
<body>



<a href="http://www.naver.com">네이버</a>

<form method="post" action="/input_tag" onSubmit="return btnClick1()" name="myform"  >
<input type="text" id="uid" name="uid" value="<%=request.getParameter("uid")%>"><br>
<input type="password" id="upw" name="upw" value="<%=request.getParameter("upw")%>" ><br>
<input type="checkbox" class="habit" name="habit" value="book">독서
<input type="checkbox" class="habit" name="habit" value="mount">등산
<input type="checkbox" class="habit" name="habit" value="fish">낚시<br>



<input type="radio" name="gen" class="gen" value="m" <% if(request.getParameter("gen").equals("m")){%> checked<% } %>>남성
<input type="radio" name="gen" class="gen" value="f" <% if(request.getParameter("gen").equals("f")){%> checked<% } %>>여성<br>
<input type="hidden" id="ucid" name="ucid" value="1"><br>

<input type="file" id="ufile" name="ufile" value="첨부파일선택"><br>

<input type="reset" value="리셋"><br>
<input type="button" id="btn" value="버튼"><br>
<input type="image" value="이미지버튼" src="/5.jpg" width="100" height="100"><br>
<input type="submit" onClick="return btnClick1()" value="서브밋버튼"><br>

<!-- /////////////////	-->
<select name="tel" id="tel">
	<option value="011"<%if(request.getParameter("tel").equals("011")){ %> selected <% } %>>SKT</option>
	<option value="019"<%if(request.getParameter("tel").equals("019")){ %> selected <% } %>>LGT</option>
	<option value="016"<%if(request.getParameter("tel").equals("016")){ %> selected <% } %>>KT</option>
</select><br>

<textarea name="content" id="content"><%=request.getParameter("content")%></textarea><br>





</form>

</body>
</html>