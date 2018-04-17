<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
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
		
		$("#stdate").datepicker({
			dateFormat: "yy-mm-dd"		
		});
		$("#endate").datepicker({
			dateFormat: "yy-mm-dd"
		});
				
		$("#wrbtn").click(function () {
			location.href="gowrform.sp"
		});
		
		$("#outbtn").click(function () {
			location.href="logout.sp"
		});
		
		
		
		
	})

function conclick(chk) {
	
	location.href="upform.sp?SEQ="+chk;	
		
}

function withdraw(chk) {
		
	location.href="withdraw.sp?mem_id="+chk;	
			
}
	
</script>

</head>
<body>
list
<br>
${sessionVO.mem_name}님 안녕하세요.
<input type="button" id="outbtn" name="outbtn" value="로그아웃">
<br><br>
<form name="fmt" id="fmt">


<input type="text" name="stdate" id="stdate">~<input type="text" name="endate" id="endate"><br>

<select name="serchoption" id="serchoption">
	<option id="all">전체</option>
	<option id="id">아이디</option>
	<option id="sub">제목</option>	
</select>

<input type="text" name="serchtxt" id="serchtxt">
<input type="button" name="serbtn" id="serbtn" value="검색">

</form>




<input type="button" name="wrbtn" id="wrbtn" value="글쓰기">


<table border="1px">
	<tr>
		<td>글번호</td>
		<td>아이디</td>
		<td>제목</td>
		<td>등록일(등록일 클릭하면 최신순서대로 ajax)</td>
		<td>수정일</td>
		<td>조회수(조회수클릭하면 높은순서대로 ajax)</td> 		
	</tr>
	
	<c:forEach items="${list}" var="row">
	
	<tr id="listrow" onclick="conclick(${row.seq})">
		 
		<td>${row.seq}</td>
		<td>${row.mem_id}</td>
		<td>${row.board_subject}</td>
		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${row.reg_date}" ></fmt:formatDate> </td>
		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${row.upt_date}" ></fmt:formatDate></td>
		<td>${row.view_cnt}</td>
		
	</tr>
	
	</c:forEach>
	
</table>

<input type="button" name="withdrawbtn" id="withdrawbtn" value="탈퇴하기" onclick="withdraw(${sessionVO.mem_id})">

</body>
</html>