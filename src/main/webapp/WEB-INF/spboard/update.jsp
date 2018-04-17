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


</head>
<body>

<form name="wrfmt" id="wrfmt" enctype="multipart/form-data">
<table border="1px">
	
	<tr>
		<td>작성자</td>
		<td>
			<input type="text" name="mem_name" id="mem_name" value="${list.mem_id}">
		</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>
			<input type="text" name="board_subject" id="board_subject" value="${list.board_subject}">
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<textarea rows="7" cols="30" name="board_content" id="board_content">${list.board_content}</textarea>
		</td>
	</tr>
	<tr>
		<td>파일다운로드</td>
		<td>
			<input type="file" name="fileName" id="fileName"  value="${list.file_name}" >
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" name="writebtn" id="writebtn" value="글쓰기">
			<input type="hidden" name="mem_id" id="mem_id" value="${sessionVO.mem_id}">
		</td>		
	</tr>
	
</table>
</form>

</body>
</html>