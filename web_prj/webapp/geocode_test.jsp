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
	$("#btn").click(function(){
		
		
		$.ajax({
			url : "https://maps.googleapis.com/maps/api/geocode/json",
			type : "get",
			data : "address=%EB%8F%85%EC%82%B0%EB%8F%99&key=AIzaSyCuNEZy0_FkEG11zaMzQS02JYxYDpV_i54",
			resulttype : "json",
			//dataType:"json",
			//contentType : "application/json; charset=UTF-8",//받으면 JSON dmfh
			//data:JSON.stringify(prmstr),
			
			success : function(jsonObject){
		//		var jsonObject = JSON.parse(resString); //String을  Obj로
				console.log(jsonObject);
				
				var htmlStr = "<ul>";
				$.map(jsonObject.results, function(vv, idx){
					console.log("주소 : " + vv.formatted_address);
					htmlStr += "<li>" + " " + vv.formatted_address + "</li>";
				}); 
				$.map(jsonObject.results, function(vv, idx){
					console.log("주소2 : " + vv.geometry.location.lat);
					htmlStr += "<li>" + " " + vv.geometry.location.lat + "</li>";
				}); 
				$.map(jsonObject.results, function(vv, idx){
					console.log("주소3 : " + vv.geometry.location.lng);
					htmlStr += "<li>" + " " + vv.geometry.location.lng + "</li>";
					if(idx<1){
						  return false;
					}
				}); 
				$("#resdiv").html(htmlStr);
				
			}
		
			
			});
		
});
});
</script>
</head>
<body>
<input type='button' id='btn' value='geocode'><br>
<div id = "resdiv">
</div>
</body>
</html>