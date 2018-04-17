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

<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>


<script type="text/javascript">
	
	$(function() {
		
		var flag = 0;
		
		/** 
			중복체크
		*/		
		$("#overlap").click(function() {			
			   $.ajax({
	                type: 'POST',
	                url: 'checkid.sp',
	                dataType :'text',
	                data: {
	                    "mem_id" : $('#mem_id').val()
	                },
	                success: function(data){
	                    if($.trim(data)==0){
	                        $('#checkMsg').html('<p style="color:blue">사용가능</p>');
	                        flag = 1;
	                    }
	                    else{
	                        $('#checkMsg').html('<p style="color:red">사용불가능</p>');
	                    }
	                },error:function(){
	                    alert("에러입니다");
	                }
	            });//ajax사용 
		});//중복체크버튼
		 
		
		
		/** 
			회원가입
		*/
		$("#join").click(function() {
			
			if( $("#mem_id").val() == ""){
				alert("아이디를 입력해주세요.");
			}
			
			if( $("#mem_pw").val() == ""){
				alert("비밀번호를 입력해주세요.");
			}
			
			if($("#mem_name").val() == ""){
				alert("이름을 입력해주세요.");
			}
			
			if(flag == 0){
				alert("아이디검사를 다시하세요.");
			}
			
			if($("#mem_pw").val() != "" && $("#mem_id").val() != "" && $("#mem_name").val() != "" && flag != 0){
				
				$("#joinfmt").attr("action","joinmember.sp");
				$("#joinfmt").attr("method","post");
				$("#joinfmt").submit();
				
			}
			
		});
		
	})
	


</script>

</head>
<body>
joinform

<form name="joinfmt" id="joinfmt">
	
	아이디 : <input type="text" name="mem_id" id="mem_id"> 
	<input type="button" name="overlap" id="overlap" value="아이디중복중복확인"> 
	<div id="checkMsg">  </div>
	<br>
	이름 : <input type="text" name="mem_name" id="mem_name"><br>
	비밀번호 : <input type="text" name="mem_pw" id="mem_pw" placeholder="4~8자리 이하로 입력">
	<br><br>
	<input type="button" name="join" id="join" value="회원가입">

</form>



</body>
</html>