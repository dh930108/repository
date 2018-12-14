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


/* function httpAjax() {
	var f = document.fomfom;
	var vals = f.searchval.value;
	if(vals == "") {
		alert("조건값을 입력하세요.");
		f.searchval.focus();
		return false;
	}
	else {
		var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		      document.getElementById("resdiv").innerHTML =
		      this.responseText;
		    }
		  };
		  xhttp.open("post", "/emp", true);
		  xhttp.send();
	}
} */

$(document).ready(function(){  //Jquery 시작
	//$("#searchBtn").click(function(){
		$("#searchval").keyup(function(){
	    var searchcol = $("[name = 'searchcol']").val();
		var searchval = $("#searchval").val();
		
		/*var searchcol1 = $("[name = 'searchcol']").val();
		var searchval1 = $("[name = 'searchval']").val();
		
		console.log(searchcol + " : " + searchval);
		console.log(searchcol1 + " : " + searchval1); */
		
		//var prm = $("#myform").serialize();
		//console.log(prm);
		
		var prmjson = {"searchcol":searchcol, "searchval":searchval};
		console.log(prmjson);
		var str = JSON.stringify(prmjson);
		console.log(str);
		$.ajax({
			url : "/emp",
			type : "post",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",//String을 보낸다
			data : "key="+str,
			//dataType:"json",
			//resultType:"",
			//contentType : "application/json; charset=UTF-8",//받으면 JSON dmfh
			//data:JSON.stringify(prmstr),
			
			success : function(jsonObject){
		//		var jsonObject = JSON.parse(resString); //String을  Obj로
				console.log(jsonObject);
				
				/* $.each(jsonObj, function(idx, vv){
					console.log(".each maps : " + vv.empno);
				}); */
				 
				
				var htmlStr = "<ul>";
				$.map(jsonObject, function(vv, idx){
					console.log(".map : " + vv.empno);
					htmlStr += "<li>" + " " + vv.ename + "</li>";
				}); 
			    htmlStr += "</ul>";
				
				$("#resdiv").html(htmlStr);
			}
		});
	});
});


</script>

</head>
<body>
검색구분
<form id="myform">
<table border=1>
<tr><td>
<input type="radio" name="searchcol" class="searchcol" value="ename">이름
</td></tr>
<tr><td>
<input type="radio" name="searchcol" class="searchcol" value="deptno">부서
</td></tr>
<tr><td>
<input type="radio" name="searchcol" class="searchcol" value="job">직업
</td></tr>
</table>
<input type="text" name="searchval" id="searchval">
<!-- <input type="submit" value="검색" onClick="return btnClick()"> -->
<!-- <input type="button" value="일반검색버튼" onClick="httpAjax()"> -->
<input type="button" value="일반검색버튼" id="searchBtn">
<input type="reset" value="리셋">
</form>
<div id="resdiv"></div>

</body>
</html>