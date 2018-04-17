<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/jquery-ui-1.12.1/jquery-ui.css">
<script src="/resources/js/jquery-3.3.1.js"></script>
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>

<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>



<script type="text/javascript">
	var checkloginid = '${ID}';
	var checkloginpw = '${PW}';
	
	$(function () {
			
	if(checkloginid == "fail"){
		alert("아이디가 잘못되었습니다.");
	}
	if(checkloginpw == "fail"){
		alert("비밀번호가 잘못되었습니다.");
	}
		
		$("#logBtn").click(function () {
			
			if($("#EMPID").val() == ""){
				alert("아이디입력하세요.");
				$("#EMPID").focus();
				return false;
			}
				
			if($("#EMPPW").val().trim() == ""){
				$("#EMPPW").focus();
				alert("비밀번호를 입력하세요.");
				return false;
			}
			
			if($("#EMPID").val() != "" && $("#EMPID").val() != ""){								
				$("#logfmt").attr("action","login.ap");
				$("#logfmt").attr("method","post");
				$("#logfmt").submit();				
			}	
						
		});
				
		$("#upbtn").click(function (){
			$("#upfmt").attr("enctype","multipart/form-data");
			$("#upfmt").attr("action","upload.ap");
			$("#upfmt").attr("method","post");
			$("#upfmt").submit();
		});
		
				
		var fileindex = 0; 		
		$("#addbtn").click(function (){
			$("#addform").append("<input type='file' name='fileup"+fileindex+" id='fileup"+fileindex+"><br><br>");			
			fileindex++;
		});
		
		
	})

</script>

</head>
<body>
login
<form id="logfmt" name="logfmt">
	아이디:<input type="text" name="EMPID" id="EMPID" placeholder="아이디를 입력하세요."><br>
	비밀번호:<input type="password" name="EMPPW" id="EMPPW" placeholder="비밀번호를 입력하세요."><br>
	<input type="button" name="logBtn" id="logBtn" value="로그인" class="btn btn-primary">	
</form>
<br><br>
<table border="1px">
	<tr>
		<td>이름</td>
		<td>직함</td>
		<td>아이디</td>
		<td>비번</td>
	</tr>
	<tr>
		<td>김길동</td>
		<td>사원</td>
		<td>kim1</td>
		<td>123</td>
	</tr>	
	<tr>
		<td>박명수</td>
		<td>사원</td>
		<td>p1</td>
		<td>123</td>
	</tr>
	<tr>
		<td>아이유</td>
		<td>대리</td>
		<td>a1</td>
		<td>123</td>
	</tr>
	<tr>
		<td>김과장</td>
		<td>과장</td>
		<td>k1</td>
		<td>123</td>
	</tr>
	<tr>
		<td>문재인</td>
		<td>부장</td>
		<td>m1</td>
		<td>123</td>
	</tr>
</table>


<br><br>
<form id="upfmt" name="upfmt">
		
	<div id="addform">
		<input type="file" name="fileup" id="fileup">
		<br><br>	
	</div>
	
	<input type="button" name="upbtn" id="upbtn" value="이미지저장"> 
	<input type="button" name="addbtn" id="addbtn" value="추가"> 
</form>

	<!-- 
		MBR_USER_ID: 컨트롤 + 쉬프트 + y 소문자로 바뀜, 대문자도 있음			
	-->

</body>
</html>