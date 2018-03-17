<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="/resources/jquery-ui-1.12.1/jquery-ui.css">
<script src="/resources/js/jquery-3.3.1.js"></script>
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
 function logout() {
	 alert("로그아웃");	 
	 location.href="logout.ap";
}

function gowrite(){
	location.href="writeform.ap?EMPID=${ID}";	
} 
 
function detail(chk) {
	location.href="detailform.ap?DOMSEQ="+chk+"";
}

$(function () {
	$("#stdate").datepicker({		
	});
	
	$("#endate").datepicker({		
	});
	
	
	
	$("#serchBtn").click(function () {
		$("#docufmt").attr("action","list.ap");
		$("#docufmt").attr("method","post");
		$("#docufmt").submit();
	})
	
	
	
	
})

</script>
</head>
<body>

 ${sessionEMPNAME}(${sessionEMPGRADE})님 환영합니다. <input type="button" value="로그아웃" onclick="logout()">
	
	<div>
	<input type="button" value="글쓰기" onclick="gowrite()">
		<form name="docufmt" id="docufmt">
			<select name="serchtype" id="serchtype">
				<option value="all">선택</option>
				<option value="EMPNAME" id="EMPNAME">작성자</option>
				<option value="DOMSUB" id="DOMSUB">제목</option>
				<option value="APPROVALEMP" id="APPROVALEMP">결재자</option>
			</select>
			<input type="text" name="serchtext" id="serchtext">					
			<br>
			<input type="text" name="stdate" id="stdate">~
			<input type="text" name="endate" id="endate">
			<input type="button" value="검색" name="serchBtn" id="serchBtn">
			<input type="hidden" name="EMPID" id="EMPID" value="${ID}"> 
		</form>	
		<form name="statusfmt" id="statusfmt">
			<select name="serchtype" id="serchtype">
				<option value="status">결재상태</option>
				<option value="temp">임시저장</option>
				<option value="wait">결재대기</option>
				<option value="app">결재중</option>
				<option value="done">결재완료</option>
			</select>
		</form>
		<br>
	</div>
	
	<table border="1px">
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>작성일</td>
			<td>결재일</td>
			<td>결재자</td>
			<td>결재상태</td>			
		</tr>

	<c:forEach items="${list}" var="document">	
		<tr id="doc" onclick="detail(${document.DOMSEQ})">
			<td>${document.DOMSEQ}</td>
			<td>${sessionEMPNAME}</td>
			<td>${document.DOMSUB}</td>
			<td><fmt:formatDate value="${document.DOMREGDATE}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
			<td><fmt:formatDate value="${document.APPROVALDATE}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
			<td>${document.APPROVALEMP}</td>
			<td>${document.APPROVALSTATUS}</td>
		</tr>	
	</c:forEach>	
			
	</table>
	
	
	<div>
		
	</div>
	
</body>
</html>