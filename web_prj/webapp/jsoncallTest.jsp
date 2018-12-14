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

$("#listbtn").click(function(){
	
	
	$.ajax({
		url : "/list",
		type : "post",
		//dataType:"json",
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

$("#viewbtn").click(function(){
	
	/* var prm = $("#myform").serialize();
	console.log(prm); */
	
	var prm = $("#search").val();
	console.log(prm);
	$.ajax({
		url : "/view",
		type : "post",
		contentType : "application/x-www-form-urlencoded; charset=UTF-8",//String을 보낸다
		data : "searchval="+prm,
		//dataType:"json",
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
<!--버튼 2개
버튼 1 : listBtn
버튼 2 : viewBtn
버튼 1 : -> /list 서브릿
버튼 2 : -> /view 서브릿     서브릿 1개쓰려면  hidden으로 구분할것
resdiv
버튼 1 : 회원목록
버튼 2 : 개인회원목록

검색조건은 empno

input type text empno

오가는 데이터타입은 제한없이
-->
<form id="myform">
<b>회원번호검색</b><br>
<input type="text" id="search"><br>
<input type="button" id="listbtn" value="list버튼">
<input type="button" id="viewbtn" value="view버튼">
<div id="resdiv">
</div>

</form>


</body>
</html>