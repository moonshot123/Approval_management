<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/resources/jquery-ui-1.12.1/jquery-ui.css">
<script src="/resources/js/jquery-3.3.1.js"></script>
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

$(function () {
	$("#sdate").datepicker({
		/* dateFormat: 'yymmdd',
		changeMonth: true, //월변경가능
	    changeYear: true, //년변경가능
		showMonthAfterYear: true, //년 뒤에 월 표시	 */			
	});
		
	
	$("#ndate").datepicker({
		/* dateFormat: 'yymmdd',
		changeMonth: true, //월변경가능
	    changeYear: true, //년변경가능
		showMonthAfterYear: true, //년 뒤에 월 표시 */
	});
	
	//serialize를 사용해야됨 이거 쓰면 따로따로 한개씩 보내줄 필요가 없음?
	$("#ser").click(function(){
		
		$.ajax({
			data:$("#serfrm").serialize(),
	        type : "post",
	        url : "boardlist.ajax",
	        error : function() {
	            alert('통신실패!!');
	        },
	        success : function(data) {
	        	alert('통신성공!!');
	        	$("#selectdata").html(data);
	        }	 
	    });				
	});
	//curPage="+page+"&sel=${sel}"+"&serch=${serch}"
	$("#boardnum a").click(function list(page){
		$.ajax({
			data:$("#numfmt").serialize(),
	        type : "post",
	        url : "boardlist.ajax",
	        error : function() {
	            alert('통신실패!!');
	        },
	        success : function(data) {
	        	alert('통신성공!!');
	        	$("#boardnum").html(data);
	        }	 
	    });		
	});
	
	
	
	
	
})


function gowrite() {
	
	location.href ="/writeform";
		
	}

	
function delboard() {
		alert("삭제하러감");
		$("#delcheck").attr("action","/boarddel");
		$("#delcheck").attr("method","get");
		$("#delcheck").submit();
		//alert("이거보면넘어감");
	}

function checkboard(chk){
	//alert("check"+chk);		
}

// **원하는 페이지로 이동시 검색조건, 키워드 값을 유지하기 위해 
 /* function list(page){
    location.href="/boardlist?curPage="+page+"&sel=${sel}"+"&serch=${serch}";
} */
 

</script>

</head>
<body>
boardlist<br>
<input type="button" onclick="gowrite()" value="글쓰기">
<input type="button" onclick="delboard()" value="삭제하기">

<!-- action="/boardlist" -->
<form  name="serfrm" id="serfrm">
<select name="sel" id="sel">
	<option value="all">선택</option>
	<option value="mem_id" id="mem_id" <c:if test="${mapvalue.sel eq 'mem_id'}">selected</c:if>>작성자</option>
	<option value="board_subject" id="board_subject" <c:if test="${mapvalue.sel eq 'board_subject'}">selected</c:if>>제목</option>
	<option value="board_sc" id="board_sc" <c:if test="${mapvalue.board_sc eq 'board_sc'}"></c:if> >제목+내용</option>
</select>
	<input type="text" name="serch" id="serch" value="${mapvalue.serch}">
	<input type="button" name="ser" id="ser" value="검색" >
	등록일:<input type="text" name="sdate" id="sdate" value="${mapvalue.sdate}">
	~<input type="text" name="ndate" id="ndate" value="${mapvalue.ndate}">
</form>	
     			
<form name="delcheck" id="delcheck">
<table border="1px">
	<thead>
	<tr>
		<th>선택</th>
		<th>글번호</th>
		<th>작성자</th>
		<th>제목</th>		
		<th>등록일</th>
		<th>수정일</th>
		<th>조회수</th>		
	</tr>
	</thead>
	<tbody id="selectdata">
	<c:forEach var="row" items="${list}">
 		<tr> 
 			<td> <input type="checkbox"  name="check" onclick="checkboard(this)" value="${row.seq}">  </td>	
 			<td>${row.seq}</td>
 			<td>${row.mem_id}(${row.mem_name})</td>
 			<td><a href="boarddatail?num=<c:out value="${row.seq}"/>"> ${row.board_subject}</a></td>
 			<td><fmt:formatDate value="${row.reg_date}" pattern="yyyy.MM.dd"/></td>
 			<td><fmt:formatDate value="${row.upt_date}" pattern="yyyy.MM.dd"/></td>
 			<td>${row.view_cnt}</td>	
 		</tr>	
 	</c:forEach>
	</tbody>	
	<%-- 
	<c:forEach var="row" items="${list}" varStatus="num" 이거사용해서 할수 있음>
 		<tr> 
 			<td> <input type="checkbox"  name="check" id="" onclick="checkboard(this)" value="${row.seq}">  </td>	
 			<td>${row.seq}</td>
 			<td>${row.mem_id}(${row.mem_name})</td>
 			<td><a href="boarddatail?num=<c:out value="${row.seq}"/>"> ${row.board_subject}</a></td>
 			<td><fmt:formatDate value="${row.reg_date}" pattern="yyyy.MM.dd"/></td>
 			<td><fmt:formatDate value="${row.upt_date}" pattern="yyyy.MM.dd"/></td>
 			<td>${row.view_cnt}</td>	
 		</tr>	
 	</c:forEach>
	 --%>
			 	 
</table>
</form>	
<form id="numfmt">
	<div id="boardnum" >
		<!-- 
		<a href="/boardlist?pageNo=1">1</a>
		<a href="/boardlist?pageNo=2">2</a>
		<a href="/boardlist?pageNo=3">3</a> 
		 -->
		
	  <!-- **처음페이지로 이동 : 현재 페이지가 1보다 크면  [처음]하이퍼링크를 화면에 출력-->
             <c:if test="${paging.curBlock > 1}">
                  <a href="javascript:list('1')">[처음]</a>
              </c:if>
                
              <!-- **이전페이지 블록으로 이동 : 현재 페이지 블럭이 1보다 크면 [이전]하이퍼링크를 화면에 출력 -->
              <c:if test="${paging.curBlock > 1}">
                  <a href="javascript:list('${paging.prevPage}')">[이전]</a>
              </c:if>
                
              <!-- **하나의 블럭에서 반복문 수행 시작페이지부터 끝페이지까지 -->
              <c:forEach var="num" begin="${paging.blockBegin}" end="${paging.blockEnd}">
                  <!-- **현재페이지이면 하이퍼링크 제거 -->
                  <c:choose>
                      <c:when test="${num == paging.curPage}">
                          <span style="color: red">${num}</span>&nbsp;
                      </c:when>
                      <c:otherwise>
                          <a href="javascript:list('${num}')">${num}</a>&nbsp;
                      </c:otherwise>
                  </c:choose>
              </c:forEach>
                
              <!-- **다음페이지 블록으로 이동 : 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 [다음]하이퍼링크를 화면에 출력 -->
              <c:if test="${paging.curBlock <= paging.totBlock}">
                  <a href="javascript:list('${paging.nextPage}')">[다음]</a>
              </c:if>
               
              <!-- **끝페이지로 이동 : 현재 페이지가 전체 페이지보다 작거나 같으면 [끝]하이퍼링크를 화면에 출력 -->
              <c:if test="${paging.curPage <= paging.totPage}">
                  <a href="javascript:list('${paging.totPage}')">[끝]</a>
              </c:if>
			<input type="hidden" name="">	
	</div>
</form>	
</body>
</html>