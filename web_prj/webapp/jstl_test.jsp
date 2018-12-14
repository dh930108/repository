<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.kosmo.web.EmpVO"
    %>
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
	function loopTest() {
		for(var i=0; i<5; i++) {
			console.log(i);
		}
	}
</script>
<script>
$(document).ready(function() {
	var arr = ['aaa','bbb','ccc','ddd','eee'];
	
	//function --> java에서 lamda , 콜벡메서드 , 이름없이 1회용 메서드
	$.each(arr,function(i, v){
		console.log(i +" : "+ v);
	});
	
	$(arr).each(function(idx, vv){
		console.log(idx +" : "+ vv);
	});
	
	$(arr).each(myfunc);
	
	
	//---------------------------------------------
	
	var map = {"uid":"kim", "upw":"111"};
	console.log(map);
	var marr = $.makeArray( map );
	console.log(marr);
	//-------------------------------------------
	var maps = [
				{"uid":"kim", "upw":"111"},
				{"uid":"lee", "upw":"222"},
				{"uid":"park", "upw":"333"}
			   ];
	console.log(maps[0].uid);
	console.log(maps[1].uid);
	
	$(maps).each(function(idx, vv){
		console.log("$each maps : "+idx +" : "+ vv.uid);
	});
	$.map(maps, function(vv, idx){
		console.log("$map maps  : "+idx +" : "+ vv.uid);
	});
	
	//--------------------------------------------
	
	for( idx in maps ){
	//for(var idx=0; idx<maps.length; idx++){
		console.log(maps[idx].uid);
	}
	
	
});

function myfunc(idx, vv){
	console.log(idx +" : "+ vv);
};
</script>
</head>
<body onLoad="loopTest()">



el로 받은값 : ${param.uid} <br>



<%
for(int i = 0; i<10 ; i++){
}
%>

<c:forEach var="i" begin="0" end="9" step="1">
 ${i}
</c:forEach>

<%if(10>9){%>
크다.
<%} %>



</body>
</html>