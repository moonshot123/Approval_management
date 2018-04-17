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
	
	$(function () {
		var flag = '${flag}';
		
		var logincheck = '${logincheck}';
		
		if(logincheck ==1){
			alert("아이디가 잘못되었습니다.");
		}
		if(logincheck ==2){
			alert("비번이 잘못되었습니다.");
		}
		if(flag == 1){
			alert("회원가입이 완료되었습니다.");
		}
		
		/** 
			로그인 
		*/
		$("#logbtn").click(function () {
			if( $("#mem_id").val() == ""){
				alert("아이디를 입력해주세요.");
			}
			
			if( $("#mem_pw").val() == ""){
				alert("비밀번호를 입력해주세요.");
			}
			
			if($("#mem_pw").val() != "" && $("#mem_id").val() != ""){
				
				$("#logfmt").attr("action","login.sp");
				$("#logfmt").attr("method","post");
				$("#logfmt").submit();
				
			}
			
		});
		
		
		/** 
			회원가입으로이동
		*/
		$("#joinbtn").click(function () {
			location.href="gotojoinform.sp";
		});
		
		
		
	})
	
</script>

</head>
<body>
login페이지입니다.

<div>
	<form name="logfmt" id="logfmt">
		
		<table>
			<tr>
				<td>아이디  :</td>
				<td><input type="text" name="mem_id" id="mem_id" placeholder="아이디를 입력하세쇼"> </td>
			</tr>
		
			<tr>
				<td>비밀번호:</td>
				<td><input type="text" name="mem_pw" id="mem_pw" placeholder="비밀번호를 입력하세쇼"> </td>
			</tr>
		</table>
		
				
		<input type="button" name="logbtn" id="logbtn" value="로그인">
		<input type="button" name="joinbtn" id="joinbtn" value="회원가입">
		
	</form>

</div>


<div>
 할일 
 //회원가입 ajax
 //로그인   
 리스트 (페이징)
 //글쓰기 (파일업로드포함) 
 상세보기및 수정하기 (내가보면:파일수정,다운로드  다른사람: 파일다운로드 ), 삭제하기
 검색하기 (날짜, 제목, 사람)
 //로그아웃
 //회원탈퇴
 
</div>


</body>
</html>