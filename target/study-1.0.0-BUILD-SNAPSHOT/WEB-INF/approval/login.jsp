<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/jquery-ui-1.12.1/jquery-ui.css">
<script src="/resources/js/jquery-3.3.1.js"></script>
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>

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
			}
				
			if($("#EMPPW").val().trim() == ""){
				alert("비밀번호를 입력하세요.");
			}
			
			if($("#EMPID").val() != "" && $("#EMPID").val() != ""){				
				
				$("#logfmt").attr("action","login.ap");
				$("#logfmt").attr("method","post");
				$("#logfmt").submit();
				
			}	
						
		});
		
				
	})

</script>

</head>
<body>
login
<form id="logfmt" name="logfmt">
	아이디:<input type="text" name="EMPID" id="EMPID" placeholder="아이디를 입력하세요."><br>
	비밀번호:<input type="password" name="EMPPW" id="EMPPW" placeholder="비밀번호를 입력하세요."><br>
	<input type="button" name="logBtn" id="logBtn" value="로그인">	
</form>

</body>
</html>