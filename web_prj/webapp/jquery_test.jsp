<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
$(document).ready(function(){  //Jquery 시작
	
	/* $("#lunBtn").click(function(){
		 alert("lunBtn이야!");
	}); */
	
	$(".yb").click(function(){
		
		$("#btndiv").removeAttr();
	    var str = "";
	    str += "<input type ='button' class='xb' value = 'aa'>"
	    str += "<input type ='button' class='xb' value = 'bb'>"
	    str += "<input type ='button' class='xb' value = 'cc'>"
	    
	    $("#btndiv").html(str);
	});  
	
	$(".xb").on("click", function(){
	    alert("난 동적이야");
	}); //안먹는다
	
	$(document).on("click",".xb", function(){
		alert("난 동적이야2");
	});
	
});                           //Jquery 끝


function calltest(){
	
}

</script>
<script>
function scriptFunc() {
	
	
}
</script>
</head>
<body>
<form name="myform" method="post">
<input type="text" id="uid" class="uid" name="uid"><br>
<input type="password" name="upw"><br>

<input type="button" onClick="scriptFunc()" id="lunBtn" class="yb" name="lunBtn" value="누르시오">
<input type="button" onClick="scriptFunc()" id="runBtn" class="yb" name="runBtn" value="누르지마시오">

<div id="btndiv">


</div>

</form>
</body>
</html>