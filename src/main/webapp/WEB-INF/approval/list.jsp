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

<<<<<<< HEAD
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>

=======
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
 function logout() {
	 alert("로그아웃");	 
	 location.href="logout.ap";
}

function gowrite(){
	location.href="writeform.ap?EMPID=${EMPID}";	
} 
 
function detail(chk) {
<<<<<<< HEAD
	location.href="detailform.ap?DOMSEQ="+chk;
}



$(function () {
	$("#stdate").datepicker({		
		 dateFormat: "yy-mm-dd"
	});
	
	$("#endate").datepicker({		
		 dateFormat: "yy-mm-dd"
	});
	
		
=======
	location.href="detailform.ap?DOMSEQ="+chk+"";
}

$(function () {
	$("#stdate").datepicker({		
	});
	
	$("#endate").datepicker({		
	});
	
	
	
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
	$("#serchBtn").click(function () {
		$("#docufmt").attr("action","list.ap");
		$("#docufmt").attr("method","post");
		$("#docufmt").submit();
<<<<<<< HEAD
	});
	
	$("#statusfmt").on('change',function () {
		$("#statusfmt").attr("action","list.ap");
		$("#statusfmt").attr("method","post");
		$("#statusfmt").submit();
	});
})





=======
	})
	
	
	
	
})

>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
</script>
</head>
<body>

<<<<<<< HEAD
 ${sessionEMPNAME}(${sessionEMPGRADE})님 환영합니다. 
 <input type="button" value="로그아웃" onclick="logout()" class="btn btn-primary">
=======
 ${sessionEMPNAME}(${sessionEMPGRADE})님 환영합니다. <input type="button" value="로그아웃" onclick="logout()">
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
	
	<div>
		<c:set var="EMPGRADE" value="${sessionEMPGRADE}"></c:set>
		<c:if test="${EMPGRADE eq '사원' || EMPGRADE eq '대리'}">
<<<<<<< HEAD
			<input type="button" value="글쓰기" onclick="gowrite()" class="btn btn-primary">					
		</c:if>	
		
=======
			<input type="button" value="글쓰기" onclick="gowrite()">					
		</c:if>	
	
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
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
<<<<<<< HEAD
			<input type="button" value="검색" name="serchBtn" id="serchBtn" class="btn btn-primary">
			<input type="hidden" name="EMPID" id="EMPID" value="${EMPID}"> 			
		</form>
			
		<form name="statusfmt" id="statusfmt" >
			<select name="appserchtype" id="appserchtype" >
=======
			<input type="button" value="검색" name="serchBtn" id="serchBtn">
			<input type="hidden" name="EMPID" id="EMPID" value="${EMPID}"> 
			
		</form>	
		<form name="statusfmt" id="statusfmt">
			<select name="serchtype" id="serchtype">
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
				<option value="status">결재상태</option>
				<option value="temp">임시저장</option>
				<option value="wait">결재대기</option>
				<option value="app">결재중</option>
				<option value="done">결재완료</option>
<<<<<<< HEAD
				<option value="ban">반려</option>
			</select>
			<input type="hidden" name="EMPID" id="EMPID" value="${EMPID}">
=======
			</select>
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
		</form>
		<br>
	</div>
	
<<<<<<< HEAD
	 <table class="table table-hover">
=======
	<table border="1px">
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>작성일</td>
			<td>결재일</td>
			<td>결재자</td>
			<td>결재상태</td>			
<<<<<<< HEAD
		</tr>		
=======
		</tr>

>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
	<c:forEach items="${list}" var="document">	
		<tr id="doc" onclick="detail(${document.DOMSEQ})">
			<td>${document.DOMSEQ}</td>
			<td>${document.EMPNAME}</td>
			<td>${document.DOMSUB}</td>
			<td><fmt:formatDate value="${document.DOMREGDATE}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
			<td><fmt:formatDate value="${document.APPROVALDATE}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
			<td>${document.APPROVALEMP}</td>
			
			<c:set var="status" value="${document.APPROVALSTATUS}" /> 
			<td>
			<c:if test="${status eq 'temp' }">임시저장</c:if>
			
			<c:if test="${status eq 'wait' }">결재대기</c:if>
			
			<c:if test="${status eq 'app' }">결재중</c:if>
			
			<c:if test="${status eq 'done' }">결재완료</c:if>
			
			<c:if test="${status eq 'ban' }">반려</c:if>
			
			</td>
		</tr>	
	</c:forEach>	
			
	</table>
	
<<<<<<< HEAD
=======
	
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
	<div>
		
	</div>
	
</body>
</html>