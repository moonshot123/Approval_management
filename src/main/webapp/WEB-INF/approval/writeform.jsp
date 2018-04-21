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

<<<<<<< HEAD
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>

=======
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
<script type="text/javascript">

$(function () {
	
	$("#tempBtn").click(function(){
<<<<<<< HEAD
		$("#APPROVALSTATUS").attr('value','temp');
=======
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
		$("#wrfmt").attr("action","writedo.ap");
		$("#wrfmt").attr("method","get");
		$("#wrfmt").submit();
	});
	
<<<<<<< HEAD
	$("#appBtn").click(function(){
		$("#APPROVALSTATUS").attr("value",'wait');
		$("#wrfmt").attr("action","writedo.ap");
		$("#wrfmt").attr("method","get");
		$("#wrfmt").submit();
	});
=======
	
	
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
	
	
})


</script>
</head>
<body>
	<form>
<<<<<<< HEAD
		<table class="table table-hover">
=======
		<table border="1px">
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
			<tr>
				<td width="70">결재요청</td>
				<td width="70">과장</td>
				<td width="70">부장</td>
			</tr>
			<tr>
<<<<<<< HEAD
				<td><input type="checkbox" disabled="disabled"></td>
				<td><input type="checkbox" disabled="true"></td>
				<td><input type="checkbox" disabled="true"></td>
=======
				<td><input type="checkbox" disabled="true"></td>
				<td><input type="checkbox" disabled=true></td>
				<td><input type="checkbox" disabled=true></td>
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
			</tr>
		</table>
		<br>
	</form>


	<form id="wrfmt" name="wrfmt">
	
<<<<<<< HEAD
	<table class="table table-hover" >
=======
	<table border="1px">
		<!-- 
		<tr>
			<td>번호</td>
			<td><input type="text" name="DOMSEQ" id="DOMSEQ" ></td>
		</tr> 
		-->
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
		
		<tr>
			<td>작성자</td>
			<td><input type="text" name="EMPNAME" id="EMPNAME" value="${Employee.EMPNAME}" readonly></td>
		</tr>
	
		<tr>
			<td>제목</td>
			<td><input type="text" name="DOMSUB" id="DOMSUB"  ></td>
		</tr>
<<<<<<< HEAD
		<tr>
			<td>파일업로드</td>
			<td><input type="file" name="DOMFILE" id="DOMFILE"></td>
		</tr>	
=======
		
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
		<tr>
			<td>내용</td>
			<td>
				<textarea rows="10" cols="30" name="DOMCONT" id="DOMCONT" ></textarea>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="hidden" name="EMPID" id="EMPID" value="${Employee.EMPID}">
<<<<<<< HEAD
				<input type="hidden" name="APPROVALSTATUS" id="APPROVALSTATUS" >						
					<input type="button" value="임시저장" name="tempBtn" id="tempBtn" class="btn btn-primary">											
					<input type="button" value="결재" name="appBtn" id="appBtn" class="btn btn-primary">									 
			</td>
		</tr>
			
	</table>
	
	</form>
	
=======
					
					<input type="button" value="임시저장" name="tempBtn" id="tempBtn">											
					<!-- <input type="button" value="결재" name="appBtn" id="appBtn"> -->					
				 
			</td>
		</tr>
	</table>
	
	
	
	</form>
	
	
	
>>>>>>> 9c4572edbe00ea94482a76c956f2cc587eb636ad
</body>
</html>