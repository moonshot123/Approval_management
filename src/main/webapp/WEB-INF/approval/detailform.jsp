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

<script type="text/javascript">

$(function () {
		
	$("#appBtn").click(function(){
		$("#appline").attr("action","approve.ap");
		$("#appline").attr("method","get");
		$("#appline").submit();
	});
	
	
	
})


</script>

</head>
<body>

<form>
		<table border="1px">
			<tr>
				<td width="70">결재요청</td>
				<td width="70">과장</td>
				<td width="70">부장</td>
			</tr>
			<tr>
				<td><input type="checkbox" disabled="true"></td>
				<td><input type="checkbox" disabled="true"></td>
				<td><input type="checkbox" disabled="true"></td>
			</tr>
		</table>
		<br>
	</form>



	<form id="appline" name="appline">	
	<table border="1px">
		<tr>
			<td>번호</td>
			<td><input type="text" name="" id="" value="${detail.DOMSEQ}" readonly></td>
		</tr>
	
		<tr>
			<td>작성자</td>
			<td><input type="text" name="" id="" value="${sessionEMPNAME}" readonly></td>
		</tr>
	
		<tr>
			<td>제목</td>
			<td><input type="text" name="" id="" value="${detail.DOMSUB}" readonly></td>
		</tr>
		
		<tr>
			<td>내용</td>
			<td>
				<textarea rows="10" cols="30" name="" id="" readonly>${detail.DOMCONT}</textarea>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				
				<c:set var="GRADE" value="${sessionEMPGRADE}" />

				<c:if test="${GRADE eq '사원'}">
					<input type="button" value="결재" name="appBtn" id="appBtn">
				</c:if>
				
				<c:if test="${GRADE eq '대리'}">
					<input type="button" value="결재" name="appBtn" id="appBtn">
				</c:if>
				
				<c:if test="${GRADE eq '과장'}">
					<input type="button" value="반려">
					<input type="button" value="결재" name="appBtn" id="appBtn">
				</c:if>
				
				<c:if test="${GRADE eq '부장'}">
					<input type="button" value="반려">
					<input type="button" value="결재" name="appBtn" id="appBtn">
				</c:if>
				<input type="hidden" name="DOMSEQ" id="DOMSEQ" value="${detail.DOMSEQ}">
				<input type="hidden" name="APPROVALSTATUS" id="APPROVALSTATUS" value="${detail.APPROVALSTATUS}">
				<input type="hidden" name="EMPID" id="EMPID" value="${detail.EMPID}">  
			</td>
		</tr>
	</table>
	
	
	
	</form>
	

</body>
</html>