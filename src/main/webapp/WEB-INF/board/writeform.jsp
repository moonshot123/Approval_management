<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/resources/js/jquery-3.3.1.js"></script>
<!-- 요즘은 jquery로 action을 넣어서 만듬 form에다가 액션을 넣으면 다른곳으로 보내줄때 다시만들어야되서 힘듬 -->
<script type="text/javascript">

	$(function () {  
		$("#wtBtn").click(function(){
			$("#frm").attr("action","/boardwrite");
			$("#frm").attr("method","post");
			$("#frm").submit();
		});
			
		$("#upBtn").click(function(){
			$("#frm").attr("action","/boardupdate");
			$("#frm").attr("method","post");
			$("#frm").submit();
		});		
		 
		$("#deBtn").click(function(){
			$("#frm").attr("action","/boarddel");
			$("#frm").attr("method","post");
			$("#frm").submit();
		});		
						
	}); 

</script>
		
<title>Insert title here</title>
</head>
<body>

writeform

<!-- 
이런식으로 하면 버튼만 추가해서 폼을 여러곳에 보내서 쓸수 있음
<form name="frm" id="frm">
	<table>
		<tr><td>아이디: <input type="text" name="mem_id"> </td></tr>
		<tr><td>작성자: <input type="text" name="mem_name"> </td></tr>
		<tr><td>제목: <input type="text" name="board_subject"> </td></tr>
		<tr><td>내용: <textarea rows="5" cols="25" name="board_content"></textarea> <td></tr>
		<tr><td> <input type="button" name="wtBtn" id="wrBtn" value="제출"> </td></tr>			
	</table>
</form>
 -->
 	
	
<form name="frm" id="frm">		
	<table>			
		<tr><td>아이디: <input type="text" name="mem_id" value="${board.mem_id}"> </td></tr>
		<tr><td>작성자: <input type="text" name="mem_name" value="${board.mem_name}"> </td></tr>
		<tr><td>제목: <input type="text" name="board_subject" value="${board.board_subject}"> </td></tr>
		<tr><td>내용: <textarea rows="5" cols="25" name="board_content" >${board.board_content}</textarea> <td></tr>
		<tr>		
			<td>
				<c:set var="name" value="${board.mem_id}"/>
				<c:if test="${empty name}">
					<input type="button" name="wtBtn" id="wtBtn" value="제출">
				</c:if>
				
				<%--				
				jstl
				태그 몇개는 알아두자.
				<c:choose></c:choose> 한번 써보자 
				eq  =   ==
				--%>
				
				<c:if test="${!empty name}">
				<input type="hidden" name="seq" value="${board.seq}">	
				<input type="button" name="upBtn" id="upBtn" value="수정">
				<!-- <input type="button" name="deBtn" id="deBtn" value="삭제">  -->
				</c:if>
			</td>		
		</tr>			
	</table>	
</form>
</body>
</html>