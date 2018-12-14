<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
$(document).ready(function() {
	
	
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
		$.each($("[name='habit']:checked") , function(){
			console.log("habit   : " + $(this).val());
		});
		
		

	});

});
</script>

</head>
<body>




<form method="post" action="/input_tag_2" name="myform"  >
<input type="text" id="uid" name="uid"><br>
<input type="password" id="upw" name="upw"><br>
<input type="checkbox" class="habit" name="habit" value="book">독서
<input type="checkbox" class="habit" name="habit" value="mount">등산
<input type="checkbox" class="habit" name="habit" value="fish">낚시<br>



<input type="radio" name="gen" class="gen" value="m">남성
<input type="radio" name="gen" class="gen" value="f">여성<br>
<input type="hidden" id="ucid" name="ucid" value="1"><br>

<input type="file" id="ufile" name="ufile" value="첨부파일선택"><br>

<input type="reset" value="리셋"><br>
<input type="button" id="btn" value="버튼"><br>
<input type="image" value="이미지버튼" src="/5.jpg" width="100" height="100"><br>
<input type="submit" onClick="/input_tag_2" value="서브밋버튼"><br>

<!-- /////////////////	-->
<select name="tel" id="tel">
	<option value="011">SKT</option>
	<option value="019">LGT</option>
	<option value="016">KT</option>
</select><br>

<textarea name="content" id="content">여기글씨..</textarea><br>





</form>

</body>
</html>